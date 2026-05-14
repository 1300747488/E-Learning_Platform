package com.ray.elearning_platform.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assumptions;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

abstract class ControllerTestSupport {

    protected static final MediaType JSON = MediaType.APPLICATION_JSON;

    protected final ObjectMapper objectMapper = new ObjectMapper();

    protected MockMvc mockMvc(Object controller) {
        return MockMvcBuilders.standaloneSetup(controller).build();
    }

    protected String json(Object body) throws Exception {
        return objectMapper.writeValueAsString(body);
    }

    protected void assertDefaultSuccess(ResultActions resultActions) throws Exception {
        String responseBody = resultActions
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertTrue(responseBody.contains("\"code\":0"), responseBody);
    }

    protected SampleData useRealDatabaseSampleData() {
        try {
            Properties properties = new Properties();
            try (InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("config/jdbc.properties")) {
                properties.load(inputStream);
            }

            Class.forName(properties.getProperty("jdbc.driver"));
            try (Connection connection = DriverManager.getConnection(
                    properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password")
            )) {
                return seedSampleData(connection);
            }
        } catch (Exception e) {
            Assumptions.assumeTrue(false, "真实数据库不可用，跳过 Controller 数据库集成测试：" + e.getMessage());
            return null;
        }
    }

    private SampleData seedSampleData(Connection connection) throws Exception {
        connection.setAutoCommit(false);
        try {
            int adminId = ensureAccount(connection, "it_admin", "ADMIN");
            int teacherId = ensureAccount(connection, "it_teacher", "TEACHER");
            int studentId = ensureAccount(connection, "it_student", "STUDENT");
            int courseId = ensureCourse(connection, teacherId);
            ensureEnrollment(connection, courseId, studentId);
            int materialId = ensureMaterial(connection, courseId, teacherId);
            int quizId = ensureQuiz(connection, courseId, teacherId);
            int questionId = ensureQuestion(connection, quizId);
            int attemptId = ensureAttempt(connection, quizId, studentId);
            ensureStudentAnswer(connection, attemptId, questionId);
            connection.commit();
            return new SampleData(adminId, teacherId, studentId, courseId, materialId, quizId, questionId, attemptId);
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    private int ensureAccount(Connection connection, String username, String role) throws Exception {
        Integer existingId = queryId(connection, "SELECT account_id FROM account WHERE username = ?", username);
        if (existingId != null) {
            return existingId;
        }

        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO account (username, password, full_name, email, phone, avatar, role, status)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, username);
            statement.setString(2, "encrypted_password");
            statement.setString(3, username + " name");
            statement.setString(4, username + "@test.com");
            statement.setString(5, "18800000000");
            statement.setString(6, null);
            statement.setString(7, role);
            statement.setString(8, "ACTIVE");
            statement.executeUpdate();
            return generatedId(statement);
        }
    }

    private int ensureCourse(Connection connection, int teacherId) throws Exception {
        Integer existingId = queryId(connection, "SELECT course_id FROM course WHERE title = ?", "IT Controller Test Course");
        if (existingId != null) {
            return existingId;
        }

        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO course (title, description, category, teacher_id, status)
                VALUES (?, ?, ?, ?, ?)
                """, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "IT Controller Test Course");
            statement.setString(2, "Controller integration test course.");
            statement.setString(3, "Test");
            statement.setInt(4, teacherId);
            statement.setString(5, "ACTIVE");
            statement.executeUpdate();
            return generatedId(statement);
        }
    }

    private void ensureEnrollment(Connection connection, int courseId, int studentId) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO course_enrollment (course_id, student_id, status)
                VALUES (?, ?, ?)
                ON DUPLICATE KEY UPDATE status = VALUES(status)
                """)) {
            statement.setInt(1, courseId);
            statement.setInt(2, studentId);
            statement.setString(3, "ACTIVE");
            statement.executeUpdate();
        }
    }

    private int ensureMaterial(Connection connection, int courseId, int uploadedBy) throws Exception {
        Integer existingId = queryId(connection,
                "SELECT material_id FROM material WHERE course_id = ? AND title = ?",
                courseId, "IT Controller Test Material");
        if (existingId != null) {
            return existingId;
        }

        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO material (course_id, title, material_type, file_path, file_size, uploaded_by)
                VALUES (?, ?, ?, ?, ?, ?)
                """, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, courseId);
            statement.setString(2, "IT Controller Test Material");
            statement.setString(3, "PDF");
            statement.setString(4, "https://example.com/material.pdf");
            statement.setLong(5, 1024L);
            statement.setInt(6, uploadedBy);
            statement.executeUpdate();
            return generatedId(statement);
        }
    }

    private int ensureQuiz(Connection connection, int courseId, int createdBy) throws Exception {
        Integer existingId = queryId(connection,
                "SELECT quiz_id FROM quiz WHERE course_id = ? AND title = ?",
                courseId, "IT Controller Test Quiz");
        if (existingId != null) {
            return existingId;
        }

        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO quiz (course_id, title, description, time_limit, total_marks, start_time, end_time, status, created_by)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, courseId);
            statement.setString(2, "IT Controller Test Quiz");
            statement.setString(3, "Controller integration test quiz.");
            statement.setInt(4, 60);
            statement.setInt(5, 10);
            statement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now().minusDays(1)));
            statement.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now().plusDays(1)));
            statement.setString(8, "PUBLISHED");
            statement.setInt(9, createdBy);
            statement.executeUpdate();
            return generatedId(statement);
        }
    }

    private int ensureQuestion(Connection connection, int quizId) throws Exception {
        Integer existingId = queryId(connection,
                "SELECT question_id FROM question WHERE quiz_id = ? AND question_text = ?",
                quizId, "IT Controller Test Question");
        if (existingId != null) {
            return existingId;
        }

        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO question
                (quiz_id, question_type, question_text, question_image, option_a, option_b, option_c, option_d,
                 correct_option, reference_answer, explanation, marks, topic)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, quizId);
            statement.setString(2, "SINGLE_CHOICE");
            statement.setString(3, "IT Controller Test Question");
            statement.setString(4, "https://example.com/question.png");
            statement.setString(5, "A");
            statement.setString(6, "B");
            statement.setString(7, "C");
            statement.setString(8, "D");
            statement.setString(9, "A");
            statement.setString(10, "A");
            statement.setString(11, "Controller test explanation.");
            statement.setInt(12, 10);
            statement.setString(13, "Test Topic");
            statement.executeUpdate();
            return generatedId(statement);
        }
    }

    private int ensureAttempt(Connection connection, int quizId, int studentId) throws Exception {
        Integer existingId = queryId(connection,
                "SELECT attempt_id FROM quiz_attempt WHERE quiz_id = ? AND student_id = ? LIMIT 1",
                quizId, studentId);
        if (existingId != null) {
            return existingId;
        }

        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO quiz_attempt
                (quiz_id, student_id, score, total_marks, correct_count, wrong_count, status, duration_seconds)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, quizId);
            statement.setInt(2, studentId);
            statement.setInt(3, 0);
            statement.setInt(4, 10);
            statement.setInt(5, 0);
            statement.setInt(6, 0);
            statement.setString(7, "IN_PROGRESS");
            statement.setInt(8, 30);
            statement.executeUpdate();
            return generatedId(statement);
        }
    }

    private void ensureStudentAnswer(Connection connection, int attemptId, int questionId) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO student_answer
                (attempt_id, question_id, selected_option, answer_text, answer_image, answer_status, is_correct, awarded_marks)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE selected_option = VALUES(selected_option), answer_status = VALUES(answer_status)
                """)) {
            statement.setInt(1, attemptId);
            statement.setInt(2, questionId);
            statement.setString(3, "A");
            statement.setString(4, null);
            statement.setString(5, null);
            statement.setString(6, "ANSWERED");
            statement.setBoolean(7, true);
            statement.setInt(8, 10);
            statement.executeUpdate();
        }
    }

    private Integer queryId(Connection connection, String sql, Object... params) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
                return null;
            }
        }
    }

    private int generatedId(Statement statement) throws Exception {
        try (ResultSet resultSet = statement.getGeneratedKeys()) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            throw new IllegalStateException("Failed to read generated id");
        }
    }

    protected record SampleData(
            int adminId,
            int teacherId,
            int studentId,
            int courseId,
            int materialId,
            int quizId,
            int questionId,
            int attemptId
    ) {
    }
}
