USE e_learning_platform;

-- 清空测试数据
DELETE FROM student_answer;
DELETE FROM quiz_attempt;
DELETE FROM question;
DELETE FROM quiz;
DELETE FROM material;
DELETE FROM course;
DELETE FROM account;

-- 重置自增ID
ALTER TABLE account AUTO_INCREMENT = 1;
ALTER TABLE course AUTO_INCREMENT = 1;
ALTER TABLE material AUTO_INCREMENT = 1;
ALTER TABLE quiz AUTO_INCREMENT = 1;
ALTER TABLE question AUTO_INCREMENT = 1;
ALTER TABLE quiz_attempt AUTO_INCREMENT = 1;
ALTER TABLE student_answer AUTO_INCREMENT = 1;

-- 1. 测试账号
INSERT INTO account
(username, password, full_name, email, phone, avatar, role, status)
VALUES
    ('admin', '123456', 'Admin User', 'admin@test.com', '10000000001', NULL, 'ADMIN', 'ACTIVE'),
    ('teacher01', '123456', 'Teacher One', 'teacher01@test.com', '10000000002', NULL, 'TEACHER', 'ACTIVE'),
    ('student01', '123456', 'Student One', 'student01@test.com', '10000000003', NULL, 'STUDENT', 'ACTIVE');

-- 2. 测试课程
INSERT INTO course
(title, description, category, teacher_id, status)
VALUES
    ('Java Web Development', 'Basic course for JSP, Servlet, Spring MVC and MyBatis.', 'Programming', 2, 'ACTIVE');

-- 3. 测试学习资料
INSERT INTO material
(course_id, title, material_type, file_path, file_size, uploaded_by)
VALUES
    (1, 'Chapter 1 Notes', 'PDF', '/upload/materials/chapter1.pdf', 204800, 2),
    (1, 'Spring MVC Introduction', 'PPT', '/upload/materials/springmvc.ppt', 1024000, 2);

-- 4. 测试测验
INSERT INTO quiz
(course_id, title, description, time_limit, total_marks, start_time, end_time, status, created_by)
VALUES
    (1, 'Java Web Basic Quiz', 'A basic quiz for Java Web learning.', 30, 20,
     '2026-01-01 08:00:00', '2026-12-31 23:59:59', 'PUBLISHED', 2);

-- 5. 测试题目
INSERT INTO question
(quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option, marks, topic)
VALUES
    (1, 'Which technology is used to build dynamic web pages in this project?',
     'JSP', 'Excel', 'Photoshop', 'PowerPoint', 'A', 5, 'JSP'),

    (1, 'Which framework is used to handle backend web requests?',
     'Spring MVC', 'Bootstrap', 'MySQL', 'Git', 'A', 5, 'Spring MVC'),

    (1, 'Which framework is used for database operations?',
     'MyBatis', 'jQuery', 'Tomcat', 'HTML', 'A', 5, 'MyBatis'),

    (1, 'Which database is used in this project?',
     'Oracle', 'MySQL', 'MongoDB', 'Redis', 'B', 5, 'Database');

-- 6. 模拟学生提交一次测验
INSERT INTO quiz_attempt
(quiz_id, student_id, score, total_marks, correct_count, wrong_count, submitted_at, duration_seconds)
VALUES
    (1, 3, 15, 20, 3, 1, '2026-05-01 10:00:00', 600);

-- 7. 模拟学生每道题答案
INSERT INTO student_answer
(attempt_id, question_id, selected_option, is_correct, awarded_marks)
VALUES
    (1, 1, 'A', 1, 5),
    (1, 2, 'A', 1, 5),
    (1, 3, 'A', 1, 5),
    (1, 4, 'C', 0, 0);