# E-Learning Platform 后端完整开发文档

## 1. 当前项目状态

当前项目已经完成：

- Controller 接口路径定义。
- Service 接口定义。
- ServiceImpl 默认实现类，当前只返回业务默认值（`null`、空列表、空字符串或 `void`）。
- Req 请求体类。
- Resp 响应体类。
- Entity 实体类。
- Mapper 接口和 Mapper XML。
- SQL 建表脚本和测试数据。
- Token、密码加密、OSS 上传的工具类或配置类骨架。
- 完整接口文档：`docs/API_INTERFACE.md`。

当前项目还没有完成：

- ServiceImpl 真实业务逻辑。
- 参数校验。
- 登录 Token 生成、解析和拦截。
- 密码真实加密和校验。
- 数据库增删改查真实调用。
- OSS SDK 上传逻辑。
- 测验提交后的判分逻辑。
- 权限控制。
- 统一异常处理。

所以现在的接口可以访问并由 Controller 返回默认成功，但功能还不能真正使用。

完整后端最终应该形成这个调用链：

```text
前端请求
  -> Controller 接收参数
  -> Service 接口
  -> ServiceImpl 业务逻辑
  -> Mapper 接口
  -> Mapper XML SQL
  -> MySQL 数据库
  -> Resp 响应体
  -> JsonData 统一返回
```

## 2. 包结构和类职责

### 2.1 controller

位置：`src/main/java/com/ray/elearning_platform/controller`

职责：

- 定义 HTTP 请求路径。
- 接收 `@RequestBody`、`@RequestParam`、`@PathVariable`、`@RequestHeader` 参数。
- 调用对应 Service。
- 返回 `JsonData`。

后续实现要求：

- Controller 不写业务逻辑。
- Controller 不直接调用 Mapper。
- Controller 不处理密码加密、Token 生成、OSS 细节。
- Controller 只负责参数入口和调用 Service。

主要类：

| 类 | 功能 |
| --- | --- |
| AccountController | 注册、登录、当前用户、修改资料、修改密码、登出 |
| AdminController | 用户管理、管理员课程列表 |
| CourseController | 课程创建、修改、删除、查询、学生加入/退出课程 |
| MaterialController | 学习资料记录保存、查询、删除 |
| OssController | 阿里云 OSS 文件上传、删除、获取访问地址 |
| QuizController | 测验创建、修改、发布、关闭、删除、查询 |
| QuestionController | 题目创建、修改、删除、查询 |
| AttemptController | 开始作答、保存答案、提交测验、查询结果、历史作答 |
| AnalyticsController | 学生成绩分析、排行榜、教师成绩统计 |

### 2.2 service

位置：`src/main/java/com/ray/elearning_platform/service`

职责：

- 定义业务方法。
- 给 Controller 调用。
- 不写具体实现。

主要类：

| 类 | 功能 |
| --- | --- |
| AccountService | 账号相关业务定义 |
| AdminService | 管理员业务定义 |
| CourseService | 课程业务定义 |
| CourseEnrollmentService | 学生选课业务定义 |
| MaterialService | 学习资料业务定义 |
| OssService | OSS 文件业务定义 |
| QuizService | 测验业务定义 |
| QuestionService | 题目业务定义 |
| AttemptService | 作答业务定义 |
| AnalyticsService | 数据分析业务定义 |

### 2.3 service.impl

位置：`src/main/java/com/ray/elearning_platform/service/impl`

职责：

- 实现 Service 接口。
- 进行参数校验。
- 进行权限和状态判断。
- 调用 Mapper 操作数据库。
- 调用工具类处理密码、Token、OSS。
- 组装 Resp 返回对象。

这是后续主要开发位置。

### 2.4 mapper

位置：`src/main/java/com/ray/elearning_platform/mapper`

职责：

- 定义数据库操作方法。
- 方法参数通过 `@Param` 或实体类传入。
- 返回 Entity 或 Resp。

后续实现要求：

- ServiceImpl 调用 Mapper。
- Mapper 不写业务判断。
- Mapper 方法名和 XML 中 SQL 的 `id` 必须一致。

### 2.5 mapper XML

位置：`src/main/resources/mapper`

职责：

- 编写 MyBatis SQL。
- 配置 `resultMap` 字段映射。
- 实现增删改查。

后续实现要求：

- Entity 字段、数据库字段、XML 映射三者必须一致。
- 查询列表时注意条件为空的情况。
- 删除建议优先做逻辑删除或状态更新，除非明确需要物理删除。

### 2.6 entity

位置：`src/main/java/com/ray/elearning_platform/entity`

职责：

- 对应数据库表。
- 主要用于 Mapper 入参和结果映射。

主要类：

| 类 | 对应表 | 功能 |
| --- | --- | --- |
| Account | account | 用户账号 |
| Course | course | 课程 |
| CourseEnrollment | course_enrollment | 学生选课记录 |
| Material | material | 学习资料 |
| Quiz | quiz | 测验 |
| Question | question | 题目 |
| QuizAttempt | quiz_attempt | 学生作答记录 |
| StudentAnswer | student_answer | 学生答案 |

### 2.7 req

位置：`src/main/java/com/ray/elearning_platform/req`

职责：

- 接收前端请求体或查询参数。
- 不直接对应数据库表。
- 字段以接口需要为准。

### 2.8 resp

位置：`src/main/java/com/ray/elearning_platform/resp`

职责：

- 返回给前端的数据结构。
- 可以来自多表联查。
- 不一定和 Entity 一一对应。

### 2.9 enums

位置：`src/main/java/com/ray/elearning_platform/enums`

职责：

- 定义固定状态值。
- 避免业务代码中到处写字符串。

主要枚举：

| 枚举 | 功能 |
| --- | --- |
| AccountRoleEnum | 用户角色 |
| AccountStatusEnum | 账号状态 |
| CourseEnrollmentStatusEnum | 选课状态 |
| MaterialTypeEnum | 资料类型 |
| OssUploadBizTypeEnum | OSS 上传业务类型 |
| QuestionTypeEnum | 题型 |
| QuizStatusEnum | 测验状态 |
| QuizAttemptStatusEnum | 作答状态 |
| StudentAnswerStatusEnum | 答案状态 |
| BizCodeEnum | 统一返回状态码 |

### 2.10 util

位置：`src/main/java/com/ray/elearning_platform/util`

职责：

- `JsonData`：统一响应格式。
- `PasswordUtil`：密码加密和密码匹配，内部使用，不暴露 Controller。
- `TokenUtil`：Token 生成、解析、校验，内部使用。

### 2.11 filter

位置：`src/main/java/com/ray/elearning_platform/filter`

职责：

- `LoginFilter`：检查用户是否登录。
- `AuthFilter`：检查用户是否有权限。

后续需要在 `web.xml` 中配置过滤规则，或使用 Spring MVC 相关拦截机制。

## 3. 完整开发顺序

建议按下面顺序实现，不要一上来做所有模块。

### 第一步：数据库准备

目标：

- 能成功创建数据库和表。
- 能插入测试数据。
- Mapper XML 能正常解析。

操作：

1. 执行 `src/main/resources/sql/init.sql`。
2. 执行 `src/main/resources/sql/test-data.sql`。
3. 检查数据库连接：`jdbc.properties`。
4. 跑测试：

```text
./mvnw -q test
```

### 第二步：账号登录模块

这是后续所有权限和业务的基础。

实现类：

- `AccountServiceImpl`
- `AccountMapper`
- `AccountMapper.xml`
- `PasswordUtil`
- `TokenUtil`
- `LoginFilter`

实现顺序：

1. 实现 `PasswordUtil.encrypt(rawPassword)`。
2. 实现 `PasswordUtil.matches(rawPassword, encryptedPassword)`。
3. 实现 `AccountServiceImpl.register`。
4. 实现 `AccountServiceImpl.login`。
5. 实现 `TokenUtil.generateToken`。
6. 实现 `TokenUtil.validateToken`。
7. 实现 `TokenUtil.getAccountId`、`getRole`、`getStatus`。
8. 实现 `currentUser`。
9. 实现 `logout`。
10. 实现 `LoginFilter`。

注册流程：

```text
AccountController.register
  -> AccountService.register
  -> 校验 username/password/confirmPassword/role
  -> AccountMapper.selectByUsername
  -> 如果用户名已存在，返回 ACCOUNT_REPEAT
  -> PasswordUtil.encrypt
  -> 构建 Account
  -> AccountMapper.insertAccount
  -> 返回账户基础信息
```

登录流程：

```text
AccountController.login
  -> AccountService.login
  -> 校验 username/password
  -> AccountMapper.selectByUsername
  -> 如果账号不存在，返回 ACCOUNT_NOT_EXIST
  -> 如果账号禁用，返回 ACCOUNT_DISABLED
  -> PasswordUtil.matches
  -> 如果密码错误，返回 PASSWORD_ERROR
  -> TokenUtil.generateToken
  -> 组装 AccountLoginResp
  -> 返回 token 和用户信息
```

当前用户流程：

```text
AccountController.currentUser
  -> 从 Authorization 取 token
  -> AccountService.currentUser
  -> TokenUtil.validateToken
  -> TokenUtil.getAccountId
  -> AccountMapper.selectById
  -> 组装 CurrentUserResp
```

修改密码流程：

```text
AccountController.changePassword
  -> AccountService.changePassword
  -> 校验 accountId/oldPassword/newPassword/confirmPassword
  -> AccountMapper.selectById
  -> PasswordUtil.matches 校验旧密码
  -> PasswordUtil.encrypt 加密新密码
  -> AccountMapper.updatePassword
```

### 第三步：课程模块

实现类：

- `CourseServiceImpl`
- `CourseEnrollmentServiceImpl`
- `CourseMapper`
- `CourseEnrollmentMapper`
- `CourseMapper.xml`
- `CourseEnrollmentMapper.xml`

课程创建流程：

```text
CourseController.createCourse
  -> CourseService.createCourse
  -> 校验 title/teacherId
  -> AccountMapper.selectById 检查 teacherId 是否存在且角色为 TEACHER
  -> 构建 Course
  -> CourseMapper.insertCourse
  -> CourseMapper.selectDetailById
  -> 返回 CourseDetailResp
```

课程列表流程：

```text
CourseController.listCourses
  -> CourseService.listCourses
  -> CourseMapper.selectCourseList
  -> 返回 List<CourseListResp>
```

学生端课程列表流程：

```text
CourseController.listCoursesForStudent
  -> CourseService.listCoursesForStudent
  -> CourseMapper.selectCourseListForStudent
  -> 返回课程列表，并带 joined 字段
```

学生加入课程流程：

```text
CourseController.joinCourse
  -> CourseEnrollmentService.joinCourse
  -> 校验 courseId/studentId
  -> CourseMapper.selectById 检查课程存在
  -> AccountMapper.selectById 检查学生存在且角色为 STUDENT
  -> CourseEnrollmentMapper.selectByCourseIdAndStudentId
  -> 如果不存在，insert
  -> 如果已退出，update status = ACTIVE
  -> 如果已加入，直接返回成功或提示已加入
```

查询课程学生流程：

```text
CourseController.listCourseStudents
  -> CourseEnrollmentService.listCourseStudents
  -> CourseEnrollmentMapper.selectCourseStudents
  -> 返回 List<CourseStudentResp>
```

查询学生课程流程：

```text
CourseController.listStudentCourses
  -> CourseEnrollmentService.listStudentCourses
  -> CourseEnrollmentMapper.selectStudentCourses
  -> 返回 List<StudentCourseResp>
```

### 第四步：OSS 文件上传模块

实现类：

- `OssServiceImpl`
- `OssConfig`
- `OssController`
- `upload.properties`

实现前准备：

1. 在 `pom.xml` 添加阿里云 OSS SDK 依赖。
2. 在 `upload.properties` 配置：

```properties
oss.endpoint=
oss.accessKeyId=
oss.accessKeySecret=
oss.bucketName=
oss.publicUrlPrefix=
oss.materialDir=materials/
oss.questionImageDir=questions/
oss.answerImageDir=answers/
oss.avatarDir=avatars/
```

上传流程：

```text
OssController.upload
  -> OssService.upload
  -> 校验 file/bizType/uploaderId
  -> 根据 bizType 决定目录
  -> 生成 objectKey
  -> 调用 OSS SDK 上传文件
  -> 组装 OssUploadResp
  -> 返回 fileUrl/objectKey/fileSize/contentType
```

业务使用方式：

- 课程资料：先调用 `/api/oss/upload`，`bizType = MATERIAL`，拿到 `fileUrl`，再调用 `/api/materials` 保存资料记录。
- 题干图片：先上传，`bizType = QUESTION_IMAGE`，拿到 `fileUrl` 后写入 `questionImage`。
- 解答题图片答案：先上传，`bizType = ANSWER_IMAGE`，拿到 `fileUrl` 后写入 `answerImage`。
- 用户头像：先上传，`bizType = AVATAR`，拿到 `fileUrl` 后写入 `avatar`。

### 第五步：学习资料模块

实现类：

- `MaterialServiceImpl`
- `MaterialMapper`
- `MaterialMapper.xml`

保存资料记录流程：

```text
MaterialController.upload
  -> MaterialService.upload
  -> 校验 courseId/title/materialType/filePath/uploadedBy
  -> CourseMapper.selectById 检查课程存在
  -> AccountMapper.selectById 检查上传者存在
  -> 构建 Material
  -> MaterialMapper.insertMaterial
  -> MaterialMapper.selectDetailById
  -> 返回 MaterialDetailResp
```

资料列表流程：

```text
MaterialController.list
  -> MaterialService.list
  -> MaterialMapper.selectMaterialList
  -> 返回 List<MaterialListResp>
```

删除资料流程：

```text
MaterialController.delete
  -> MaterialService.delete
  -> MaterialMapper.selectById
  -> MaterialMapper.deleteById
  -> 可选：OssService.delete 删除 OSS 文件
```

### 第六步：测验模块

实现类：

- `QuizServiceImpl`
- `QuizMapper`
- `QuizMapper.xml`

创建测验流程：

```text
QuizController.createQuiz
  -> QuizService.createQuiz
  -> 校验 courseId/title/createdBy
  -> CourseMapper.selectById 检查课程存在
  -> AccountMapper.selectById 检查创建者为 TEACHER 或 ADMIN
  -> 校验 startTime/endTime
  -> 构建 Quiz，默认 status = DRAFT
  -> QuizMapper.insertQuiz
  -> QuizMapper.selectDetailById
  -> 返回 QuizDetailResp
```

发布测验流程：

```text
QuizController.publish
  -> QuizService.publish
  -> 校验 quizId/status
  -> QuizMapper.selectById
  -> status 只能改为 PUBLISHED 或 CLOSED
  -> QuizMapper.updateStatus
```

测验列表流程：

```text
QuizController.list
  -> QuizService.list
  -> QuizMapper.selectQuizList
  -> 返回 List<QuizListResp>
```

### 第七步：题目模块

实现类：

- `QuestionServiceImpl`
- `QuestionMapper`
- `QuestionMapper.xml`

创建题目流程：

```text
QuestionController.createQuestion
  -> QuestionService.createQuestion
  -> 校验 quizId/questionType/questionText/marks
  -> QuizMapper.selectById 检查测验存在
  -> 如果 SINGLE_CHOICE，校验 optionA-D 和 correctOption
  -> 如果 FILL_BLANK 或 SHORT_ANSWER，校验 referenceAnswer
  -> questionImage 可以为空，非空时保存 OSS URL
  -> explanation 可以为空
  -> QuestionMapper.insertQuestion
  -> QuestionMapper.selectDetailById
  -> 返回 QuestionDetailResp
```

题型处理规则：

| 题型 | 必填字段 | 答案字段 |
| --- | --- | --- |
| SINGLE_CHOICE | optionA、optionB、optionC、optionD、correctOption | correctOption |
| FILL_BLANK | referenceAnswer | referenceAnswer |
| SHORT_ANSWER | referenceAnswer | referenceAnswer |

学生端查询题目流程：

```text
QuestionController.listForStudent
  -> QuestionService.listForStudent
  -> QuestionMapper.selectStudentQuestionList
  -> 如果 attemptId 不为空，关联 student_answer 回显答案
  -> 如果 showAnswer = false，隐藏 correctOption/referenceAnswer/explanation/isCorrect/awardedMarks
  -> 如果 showAnswer = true，返回答案和解析
```

### 第八步：作答模块

实现类：

- `AttemptServiceImpl`
- `QuizAttemptMapper`
- `StudentAnswerMapper`
- `QuestionMapper`
- `QuizMapper`

开始或继续作答流程：

```text
AttemptController.startOrContinue
  -> AttemptService.startOrContinue
  -> 校验 quizId/studentId
  -> QuizMapper.selectById 检查测验存在且已发布
  -> 检查当前时间是否在 startTime/endTime 范围内
  -> CourseEnrollmentMapper 检查学生是否加入课程
  -> QuizAttemptMapper.selectInProgressAttempt
  -> 如果有 IN_PROGRESS 记录，继续使用
  -> 如果没有，创建 QuizAttempt，status = IN_PROGRESS
  -> QuestionMapper.selectStudentQuestionList 回显题目和已保存答案
  -> 返回 attemptId 和题目列表
```

保存答案流程：

```text
AttemptController.saveAnswers
  -> AttemptService.saveAnswers
  -> 校验 attemptId/quizId/studentId
  -> QuizAttemptMapper.selectById 检查记录存在且 IN_PROGRESS
  -> 遍历 AnswerReq
  -> 对每道题检查 questionId 是否属于该 quiz
  -> answerStatus = UNANSWERED 时清空答案字段或按设计保存未作答
  -> answerStatus = ANSWERED 时按题型保存 selectedOption/answerText/answerImage
  -> StudentAnswerMapper.upsertAnswer
  -> 更新 QuizAttempt.durationSeconds
```

提交测验流程：

```text
AttemptController.submit
  -> AttemptService.submit
  -> 校验 attemptId/quizId/studentId
  -> QuizAttemptMapper.selectById
  -> 检查是否已经 SUBMITTED
  -> 保存本次提交中的 answers
  -> 查询 quiz 下所有 question
  -> 查询该 attempt 下所有 student_answer
  -> 对所有题目判分
  -> 更新 student_answer.isCorrect 和 awardedMarks
  -> 汇总 score/correctCount/wrongCount
  -> 更新 QuizAttempt.status = SUBMITTED
  -> 更新 submittedAt、durationSeconds、score
  -> 返回 QuizResultResp
```

判分规则建议：

| 题型 | 判分方式 |
| --- | --- |
| SINGLE_CHOICE | `selectedOption` 等于 `correctOption` 则得满分 |
| FILL_BLANK | 简单版可用 `answerText` 等于 `referenceAnswer`；后续可支持忽略大小写和空格 |
| SHORT_ANSWER | 建议先不自动判满分，可默认待人工批改，或简单匹配参考答案 |

未作答规则：

- `answerStatus = UNANSWERED` 表示未作答。
- 未作答题目得 0 分。
- 提交结果中仍然返回题目、正确答案、参考答案和解析。

提交后或截止后查看答案流程：

```text
QuestionController.listForStudent
  -> showAnswer = true
  -> 检查 attempt 已提交，或当前时间超过 quiz.endTime
  -> 返回 correctOption/referenceAnswer/explanation/isCorrect/awardedMarks
```

### 第九步：数据分析模块

实现类：

- `AnalyticsServiceImpl`
- `AnalyticsMapper`
- `AnalyticsMapper.xml`

学生成绩概览流程：

```text
AnalyticsController.studentSummary
  -> AnalyticsService.studentSummary
  -> AnalyticsMapper.selectStudentSummary
  -> 统计 totalAttempts/averageScore/highestScore/lowestScore/passRate
  -> 返回 StudentSummaryResp
```

学生成绩趋势流程：

```text
AnalyticsController.studentProgress
  -> AnalyticsService.studentProgress
  -> AnalyticsMapper.selectStudentProgress
  -> 按 submittedAt 排序
  -> 返回 List<StudentProgressResp>
```

薄弱知识点流程：

```text
AnalyticsController.weakTopics
  -> AnalyticsService.weakTopics
  -> 关联 question.topic 和 student_answer.isCorrect
  -> 统计 totalCount/wrongCount/accuracy
  -> 返回 List<WeakTopicResp>
```

排行榜流程：

```text
AnalyticsController.leaderboard
  -> AnalyticsService.leaderboard
  -> 按 quizId 或 courseId 统计分数
  -> 排序生成 rank
  -> 返回 List<LeaderboardResp>
```

教师课程成绩流程：

```text
AnalyticsController.teacherCourseScores
  -> AnalyticsService.teacherCourseScores
  -> 根据 teacherId 查询该教师课程下学生测验成绩
  -> 返回 List<TeacherCourseScoreResp>
```

## 4. 权限控制设计

建议按角色限制接口。

| 角色 | 权限 |
| --- | --- |
| ADMIN | 管理用户、管理所有课程、查看所有数据 |
| TEACHER | 创建课程、管理自己课程的资料、测验、题目、查看课程学生和成绩 |
| STUDENT | 加入课程、查看课程资料、参加测验、查看自己的成绩 |

权限实现流程：

```text
请求进入
  -> LoginFilter 检查 token
  -> TokenUtil 解析 accountId/role/status
  -> AuthFilter 判断角色是否允许访问当前路径
  -> 允许则进入 Controller
```

第一阶段可以先只做登录校验，第二阶段再做角色权限。

## 5. 参数校验建议

所有 ServiceImpl 开头都应该做参数校验。

通用规则：

- ID 类型不能为空。
- 新增时核心字段不能为空。
- 修改时主键不能为空。
- 枚举字段必须在枚举范围内。
- 时间字段需要检查开始时间早于结束时间。
- 分值不能小于 0。
- 文件大小不能超过配置限制。

错误返回建议：

```java
return JsonData.buildError(BizCodeEnum.PARAM_ERROR);
```

或使用：

```java
return JsonData.buildError("具体错误信息");
```

## 6. Mapper 和 XML 开发要求

每新增一个 Mapper 方法，需要同时检查：

1. Mapper 接口是否有方法。
2. XML 中是否有相同 id。
3. 参数名是否和 XML 中 `#{}` 一致。
4. 返回字段是否和 Resp 或 Entity 对应。
5. SQL 是否处理了空条件。

示例：

```java
Account selectByUsername(@Param("username") String username);
```

对应 XML：

```xml
<select id="selectByUsername" resultMap="AccountResultMap">
    SELECT ...
    FROM account
    WHERE username = #{username}
    LIMIT 1
</select>
```

## 7. 最终验收清单

### 7.1 项目启动和构建

需要通过：

```text
./mvnw -q test
./mvnw -q package -DskipTests
```

### 7.2 账号模块验收

- 可以注册学生、教师、管理员。
- 密码入库不是明文。
- 可以登录并返回 token。
- token 可以查询当前用户。
- 修改密码后旧密码不能登录，新密码可以登录。
- 禁用账号不能登录。

### 7.3 课程模块验收

- 教师可以创建课程。
- 可以查询课程列表。
- 学生可以加入课程。
- 学生不能重复加入同一课程。
- 可以查询课程有哪些学生。
- 可以查询学生加入了哪些课程。

### 7.4 资料和 OSS 验收

- 可以上传文件到 OSS。
- 返回 fileUrl 和 objectKey。
- 可以保存资料记录。
- 可以查询课程资料。
- 可以删除资料记录。

### 7.5 测验和题目验收

- 教师可以创建测验。
- 教师可以发布测验。
- 教师可以创建单选题、填空题、解答题。
- 题目可以包含题干图片。
- 选项只保存文字。
- 题目有解析字段。

### 7.6 作答验收

- 学生可以开始测验。
- 学生可以保存答案。
- 未作答题目可以保存为 `UNANSWERED`。
- 学生退出后再次进入能回显已保存答案。
- 解答题可以提交图片答案。
- 学生可以提交测验。
- 提交后可以看到自己的答案、正确答案、参考答案和解析。
- 截止后再次进入也可以查看答案和解析。

### 7.7 数据分析验收

- 学生可以查看成绩概览。
- 学生可以查看成绩趋势。
- 学生可以查看薄弱知识点。
- 教师可以查看课程成绩。
- 可以查看排行榜。

## 8. 建议团队分工

| 成员 | 模块 | 主要文件 |
| --- | --- | --- |
| 主要负责人 | 架构、账号、Token、作答核心、最终整合 | AccountServiceImpl、AttemptServiceImpl、TokenUtil、Filter、Mapper XML |
| 成员 A | 用户与权限 | AccountController、AccountService、AdminService、LoginFilter、AuthFilter |
| 成员 B | 课程、选课、资料、OSS | CourseServiceImpl、CourseEnrollmentServiceImpl、MaterialServiceImpl、OssServiceImpl |
| 成员 C | 测验、题目、成绩分析 | QuizServiceImpl、QuestionServiceImpl、AnalyticsServiceImpl |

## 9. 推荐实现路线

不要同时开太多模块，建议按这个顺序提交：

1. 账号注册、登录、密码加密、Token。
2. 登录过滤器和当前用户。
3. 课程创建和课程列表。
4. 学生加入课程、课程学生列表、学生课程列表。
5. OSS 上传。
6. 资料记录保存和查询。
7. 测验创建、发布、列表。
8. 题目创建、学生题目列表。
9. 开始作答和保存答案。
10. 提交测验和自动判分。
11. 查询结果、历史作答、提交后答案解析展示。
12. 数据分析和排行榜。
13. 全项目联调和异常处理。

## 10. 开发时不要做的事

- 不要在 Controller 写业务逻辑。
- 不要把密码加密做成对外接口。
- 不要在前端传角色后就完全相信角色，后端必须从 token 或数据库确认身份。
- 不要把 OSS 密钥写死在 Java 代码里。
- 不要在 Mapper XML 里写复杂业务判断。
- 不要让学生端未提交时看到正确答案和解析。
- 不要只保存已作答题目，未作答也要能体现 `UNANSWERED`。
- 不要把 Req 当作 Entity 直接长期复用。
