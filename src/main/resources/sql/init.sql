-- 创建数据库
CREATE DATABASE IF NOT EXISTS e_learning_platform
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_general_ci;

USE e_learning_platform;

-- 为了方便重复执行，先删除旧表
DROP TABLE IF EXISTS student_answer;
DROP TABLE IF EXISTS quiz_attempt;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS quiz;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS course_enrollment;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS account;

-- 1. 账户表
CREATE TABLE account (
                         account_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '账户ID',
                         username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
                         password VARCHAR(100) NOT NULL COMMENT '密码',
                         full_name VARCHAR(100) COMMENT '用户姓名',
                         email VARCHAR(100) COMMENT '邮箱',
                         phone VARCHAR(30) COMMENT '手机号',
                         avatar VARCHAR(255) COMMENT '用户头像地址',
                         role VARCHAR(20) NOT NULL COMMENT '用户角色：ADMIN / TEACHER / STUDENT',
                         status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' COMMENT '账号状态：ACTIVE / DISABLED / DELETED',
                         created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT='账户表';

-- 2. 课程表
CREATE TABLE course (
                        course_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '课程ID',
                        title VARCHAR(100) NOT NULL COMMENT '课程标题',
                        description TEXT COMMENT '课程描述',
                        category VARCHAR(50) COMMENT '课程分类',
                        teacher_id INT NOT NULL COMMENT '教师ID',
                        status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' COMMENT '课程状态',
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

                        CONSTRAINT fk_course_teacher
                            FOREIGN KEY (teacher_id)
                                REFERENCES account(account_id)
) COMMENT='课程表';

-- 3. 课程选课表
CREATE TABLE course_enrollment (
                                   enrollment_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '选课记录ID',
                                   course_id INT NOT NULL COMMENT '课程ID',
                                   student_id INT NOT NULL COMMENT '学生ID',
                                   status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' COMMENT '选课状态：ACTIVE / LEFT',
                                   enrolled_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '加入课程时间',
                                   updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

                                   CONSTRAINT uk_course_enrollment_course_student
                                       UNIQUE (course_id, student_id),

                                   CONSTRAINT fk_enrollment_course
                                       FOREIGN KEY (course_id)
                                           REFERENCES course(course_id),

                                   CONSTRAINT fk_enrollment_student
                                       FOREIGN KEY (student_id)
                                           REFERENCES account(account_id)
) COMMENT='课程选课表';

-- 4. 学习资料表
CREATE TABLE material (
                          material_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '资料ID',
                          course_id INT NOT NULL COMMENT '课程ID',
                          title VARCHAR(100) NOT NULL COMMENT '资料标题',
                          material_type VARCHAR(20) NOT NULL COMMENT '资料类型：PDF / VIDEO / NOTE / PPT / OTHER',
                          file_path VARCHAR(255) NOT NULL COMMENT '文件路径',
                          file_size BIGINT COMMENT '文件大小，单位字节',
                          uploaded_by INT NOT NULL COMMENT '上传者ID',
                          created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',

                          CONSTRAINT fk_material_course
                              FOREIGN KEY (course_id)
                                  REFERENCES course(course_id),

                          CONSTRAINT fk_material_uploader
                              FOREIGN KEY (uploaded_by)
                                  REFERENCES account(account_id)
) COMMENT='学习资料表';

-- 5. 测验表
CREATE TABLE quiz (
                      quiz_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '测验ID',
                      course_id INT NOT NULL COMMENT '课程ID',
                      title VARCHAR(100) NOT NULL COMMENT '测验标题',
                      description TEXT COMMENT '测验说明',
                      time_limit INT COMMENT '答题时长，单位分钟',
                      total_marks INT NOT NULL DEFAULT 0 COMMENT '测验总分',
                      start_time DATETIME COMMENT '开始时间',
                      end_time DATETIME COMMENT '结束时间',
                      status VARCHAR(20) NOT NULL DEFAULT 'DRAFT' COMMENT '测验状态：DRAFT / PUBLISHED / CLOSED',
                      created_by INT NOT NULL COMMENT '创建者ID',
                      created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                      updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

                      CONSTRAINT fk_quiz_course
                          FOREIGN KEY (course_id)
                              REFERENCES course(course_id),

                      CONSTRAINT fk_quiz_creator
                          FOREIGN KEY (created_by)
                              REFERENCES account(account_id)
) COMMENT='测验表';

-- 6. 题目表
CREATE TABLE question (
                          question_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '题目ID',
                          quiz_id INT NOT NULL COMMENT '测验ID',
                          question_type VARCHAR(20) NOT NULL DEFAULT 'SINGLE_CHOICE' COMMENT '题型：SINGLE_CHOICE / FILL_BLANK / SHORT_ANSWER',
                          question_text TEXT NOT NULL COMMENT '题干',
                          question_image VARCHAR(255) COMMENT '题干图片地址',
                          option_a VARCHAR(255) COMMENT '选项A',
                          option_b VARCHAR(255) COMMENT '选项B',
                          option_c VARCHAR(255) COMMENT '选项C',
                          option_d VARCHAR(255) COMMENT '选项D',
                          correct_option VARCHAR(5) COMMENT '选择题正确答案：A / B / C / D',
                          reference_answer TEXT COMMENT '填空题或解答题参考答案',
                          explanation TEXT COMMENT '题目解析',
                          marks INT NOT NULL DEFAULT 0 COMMENT '题目分值',
                          topic VARCHAR(100) COMMENT '知识点',
                          created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

                          CONSTRAINT fk_question_quiz
                              FOREIGN KEY (quiz_id)
                                  REFERENCES quiz(quiz_id)
) COMMENT='题目表';

-- 7. 测验提交记录表
CREATE TABLE quiz_attempt (
                              attempt_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '提交记录ID',
                              quiz_id INT NOT NULL COMMENT '测验ID',
                              student_id INT NOT NULL COMMENT '学生ID',
                              score INT NOT NULL DEFAULT 0 COMMENT '学生得分',
                              total_marks INT NOT NULL DEFAULT 0 COMMENT '测验总分',
                              correct_count INT NOT NULL DEFAULT 0 COMMENT '答对题数',
                              wrong_count INT NOT NULL DEFAULT 0 COMMENT '答错题数',
                              status VARCHAR(20) NOT NULL DEFAULT 'IN_PROGRESS' COMMENT '作答状态：IN_PROGRESS / SUBMITTED',
                              started_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '开始作答时间',
                              submitted_at DATETIME COMMENT '提交时间',
                              duration_seconds INT COMMENT '答题用时，单位秒',

                              CONSTRAINT fk_attempt_quiz
                                  FOREIGN KEY (quiz_id)
                                      REFERENCES quiz(quiz_id),

                              CONSTRAINT fk_attempt_student
                                  FOREIGN KEY (student_id)
                                      REFERENCES account(account_id)
) COMMENT='测验提交记录表';

-- 8. 学生答案表
CREATE TABLE student_answer (
                                answer_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '答案记录ID',
                                attempt_id INT NOT NULL COMMENT '提交记录ID',
                                question_id INT NOT NULL COMMENT '题目ID',
                                selected_option VARCHAR(5) COMMENT '学生选择的答案',
                                answer_text TEXT COMMENT '填空题或解答题答案',
                                answer_image VARCHAR(255) COMMENT '解答题图片答案地址',
                                answer_status VARCHAR(20) NOT NULL DEFAULT 'UNANSWERED' COMMENT '作答状态：ANSWERED / UNANSWERED',
                                is_correct TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否答对：1正确，0错误',
                                awarded_marks INT NOT NULL DEFAULT 0 COMMENT '本题得分',

                                CONSTRAINT uk_answer_attempt_question
                                    UNIQUE (attempt_id, question_id),

                                CONSTRAINT fk_answer_attempt
                                    FOREIGN KEY (attempt_id)
                                        REFERENCES quiz_attempt(attempt_id),

                                CONSTRAINT fk_answer_question
                                    FOREIGN KEY (question_id)
                                        REFERENCES question(question_id)
) COMMENT='学生答案表';

-- 常用索引
CREATE INDEX idx_course_teacher_id ON course(teacher_id);
CREATE INDEX idx_enrollment_course_id ON course_enrollment(course_id);
CREATE INDEX idx_enrollment_student_id ON course_enrollment(student_id);
CREATE INDEX idx_enrollment_status ON course_enrollment(status);
CREATE INDEX idx_material_course_id ON material(course_id);
CREATE INDEX idx_quiz_course_id ON quiz(course_id);
CREATE INDEX idx_question_quiz_id ON question(quiz_id);
CREATE INDEX idx_question_type ON question(question_type);
CREATE INDEX idx_attempt_quiz_id ON quiz_attempt(quiz_id);
CREATE INDEX idx_attempt_student_id ON quiz_attempt(student_id);
CREATE INDEX idx_attempt_status ON quiz_attempt(status);
CREATE INDEX idx_answer_attempt_id ON student_answer(attempt_id);
CREATE INDEX idx_answer_question_id ON student_answer(question_id);
CREATE INDEX idx_answer_status ON student_answer(answer_status);
