# E-Learning Platform 接口文档

## 1. 文档说明

本文档根据当前项目中的 Controller、Req、Resp、Service 接口定义整理。

当前阶段只定义接口、请求参数、响应结构和注释说明，Controller 与 ServiceImpl 均返回默认成功响应，不包含具体业务逻辑。

`PageController` 当前为空类，无请求路径，不列入 REST API 文档。

统一返回格式：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| code | Integer | 状态码，成功为 0 |
| msg | String | 提示信息，成功为 success |
| data | Object | 返回数据，当前默认返回 null，后续实现时按接口说明返回对应 Resp |

统一成功示例：

```json
{
  "code": 0,
  "msg": "success",
  "data": null
}
```

Authorization 请求头格式：

```text
Authorization: Bearer token
```

## 2. 枚举值说明

| 枚举 | 可选值 | 说明 |
| --- | --- | --- |
| 用户角色 | ADMIN / TEACHER / STUDENT | 管理员 / 教师 / 学生 |
| 账号状态 | ACTIVE / DISABLED / DELETED | 正常 / 禁用 / 已删除 |
| 课程选课状态 | ACTIVE / LEFT | 已加入 / 已退出 |
| 资料类型 | PDF / VIDEO / NOTE / PPT / OTHER | PDF、视频、笔记、课件、其他 |
| OSS 上传业务类型 | MATERIAL / QUESTION_IMAGE / ANSWER_IMAGE / AVATAR | 课程资料、题干图片、解答题图片答案、头像 |
| 题型 | SINGLE_CHOICE / FILL_BLANK / SHORT_ANSWER | 单选题 / 填空题 / 解答题 |
| 测验状态 | DRAFT / PUBLISHED / CLOSED | 草稿 / 已发布 / 已关闭 |
| 作答状态 | IN_PROGRESS / SUBMITTED | 作答中 / 已提交 |
| 答案状态 | ANSWERED / UNANSWERED | 已作答 / 未作答 |

## 3. 账号模块

基础路径：`/api/account`

### 3.1 用户注册

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/account/register` |
| 请求体 | `AccountRegisterReq` |
| 响应数据 | 账户基础信息 |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| username | String | 是 | 用户名 |
| password | String | 是 | 注册时提交的明文密码，后续实现时需要加密后保存 |
| confirmPassword | String | 是 | 确认密码 |
| fullName | String | 否 | 用户姓名 |
| email | String | 否 | 邮箱 |
| phone | String | 否 | 手机号 |
| avatar | String | 否 | 用户头像地址 |
| role | String | 是 | 用户角色：ADMIN / TEACHER / STUDENT |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| accountId | Integer | 账户ID |
| username | String | 用户名 |
| fullName | String | 用户姓名 |
| email | String | 邮箱 |
| phone | String | 手机号 |
| avatar | String | 用户头像地址 |
| role | String | 用户角色 |
| status | String | 账号状态 |

### 3.2 用户登录

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/account/login` |
| 请求体 | `AccountLoginReq` |
| 响应数据 | `AccountLoginResp` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| username | String | 是 | 用户名 |
| password | String | 是 | 登录时提交的明文密码，只用于校验，不直接保存 |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| accountId | Integer | 账户ID |
| username | String | 用户名 |
| fullName | String | 用户姓名 |
| email | String | 邮箱 |
| phone | String | 手机号 |
| avatar | String | 用户头像地址 |
| role | String | 用户角色 |
| status | String | 账号状态 |
| token | String | 登录令牌 |
| expireAt | Long | 令牌过期时间戳，单位毫秒 |

### 3.3 查询当前用户

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/account/current` |
| 请求头 | `Authorization` |
| 响应数据 | `CurrentUserResp` |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| accountId | Integer | 账户ID |
| username | String | 用户名 |
| fullName | String | 用户姓名 |
| email | String | 邮箱 |
| phone | String | 手机号 |
| avatar | String | 用户头像地址 |
| role | String | 用户角色 |
| status | String | 账号状态 |

### 3.4 修改个人资料

| 项目 | 内容 |
| --- | --- |
| 请求方式 | PUT |
| 请求路径 | `/api/account/profile` |
| 请求体 | `AccountUpdateProfileReq` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| accountId | Integer | 是 | 账户ID |
| fullName | String | 否 | 用户姓名 |
| email | String | 否 | 邮箱 |
| phone | String | 否 | 手机号 |
| avatar | String | 否 | 用户头像地址 |

### 3.5 修改登录密码

| 项目 | 内容 |
| --- | --- |
| 请求方式 | PUT |
| 请求路径 | `/api/account/password` |
| 请求体 | `AccountChangePasswordReq` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| accountId | Integer | 是 | 账户ID |
| oldPassword | String | 是 | 原密码 |
| newPassword | String | 是 | 新密码，后续实现时需要加密后保存 |
| confirmPassword | String | 是 | 确认新密码，需要与 newPassword 一致 |

### 3.6 用户登出

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/account/logout` |
| 请求头 | `Authorization` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

## 4. 管理员模块

基础路径：`/api/admin`

### 4.1 查询用户列表

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/admin/users` |
| 请求参数 | `role`、`keyword` |
| 响应数据 | `List<UserListResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| role | String | 否 | 用户角色 |
| keyword | String | 否 | 搜索关键词 |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| accountId | Integer | 账户ID |
| username | String | 用户名 |
| fullName | String | 用户姓名 |
| email | String | 邮箱 |
| phone | String | 手机号 |
| avatar | String | 用户头像地址 |
| role | String | 用户角色 |
| status | String | 账号状态 |
| createdAt | LocalDateTime | 创建时间 |

### 4.2 修改账户状态

| 项目 | 内容 |
| --- | --- |
| 请求方式 | PUT |
| 请求路径 | `/api/admin/users/{accountId}/status` |
| 路径参数 | `accountId` |
| 请求参数 | `status` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| accountId | Integer | 是 | 账户ID |
| status | String | 是 | 目标账号状态：ACTIVE / DISABLED / DELETED |

### 4.3 管理员查询课程列表

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/admin/courses` |
| 请求参数 | `category`、`keyword` |
| 响应数据 | `List<CourseListResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| category | String | 否 | 课程分类 |
| keyword | String | 否 | 搜索关键词 |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| courseId | Integer | 课程ID |
| title | String | 课程标题 |
| category | String | 课程分类 |
| teacherId | Integer | 教师ID |
| teacherName | String | 教师姓名 |
| status | String | 课程状态 |
| createdAt | LocalDateTime | 创建时间 |
| studentCount | Integer | 已加入学生数 |
| joined | Boolean | 当前学生是否已加入 |

## 5. 课程模块

基础路径：`/api/courses`

### 5.1 创建课程

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/courses` |
| 请求体 | `CourseCreateReq` |
| 响应数据 | `CourseDetailResp` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| title | String | 是 | 课程标题 |
| description | String | 否 | 课程描述 |
| category | String | 否 | 课程分类 |
| teacherId | Integer | 是 | 教师ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| courseId | Integer | 课程ID |
| title | String | 课程标题 |
| description | String | 课程描述 |
| category | String | 课程分类 |
| teacherId | Integer | 教师ID |
| teacherName | String | 教师姓名 |
| status | String | 课程状态 |
| createdAt | LocalDateTime | 创建时间 |
| updatedAt | LocalDateTime | 更新时间 |

### 5.2 修改课程

| 项目 | 内容 |
| --- | --- |
| 请求方式 | PUT |
| 请求路径 | `/api/courses` |
| 请求体 | `CourseUpdateReq` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| courseId | Integer | 是 | 课程ID |
| title | String | 否 | 课程标题 |
| description | String | 否 | 课程描述 |
| category | String | 否 | 课程分类 |
| status | String | 否 | 课程状态 |

### 5.3 删除课程

| 项目 | 内容 |
| --- | --- |
| 请求方式 | DELETE |
| 请求路径 | `/api/courses/{courseId}` |
| 路径参数 | `courseId` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| courseId | Integer | 是 | 课程ID |

### 5.4 查询课程详情

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/courses/{courseId}` |
| 路径参数 | `courseId` |
| 响应数据 | `CourseDetailResp` |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| courseId | Integer | 课程ID |
| title | String | 课程标题 |
| description | String | 课程描述 |
| category | String | 课程分类 |
| teacherId | Integer | 教师ID |
| teacherName | String | 教师姓名 |
| status | String | 课程状态 |
| createdAt | LocalDateTime | 创建时间 |
| updatedAt | LocalDateTime | 更新时间 |

### 5.5 查询课程列表

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/courses` |
| 请求参数 | `category`、`keyword` |
| 响应数据 | `List<CourseListResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| category | String | 否 | 课程分类 |
| keyword | String | 否 | 搜索关键词 |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| courseId | Integer | 课程ID |
| title | String | 课程标题 |
| category | String | 课程分类 |
| teacherId | Integer | 教师ID |
| teacherName | String | 教师姓名 |
| status | String | 课程状态 |
| createdAt | LocalDateTime | 创建时间 |
| studentCount | Integer | 已加入学生数 |
| joined | Boolean | 当前学生是否已加入 |

### 5.6 学生端查询课程列表

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/courses/student-list` |
| 请求参数 | `studentId`、`category`、`keyword` |
| 响应数据 | `List<CourseListResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| studentId | Integer | 是 | 学生ID |
| category | String | 否 | 课程分类 |
| keyword | String | 否 | 搜索关键词 |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| courseId | Integer | 课程ID |
| title | String | 课程标题 |
| category | String | 课程分类 |
| teacherId | Integer | 教师ID |
| teacherName | String | 教师姓名 |
| status | String | 课程状态 |
| createdAt | LocalDateTime | 创建时间 |
| studentCount | Integer | 已加入学生数 |
| joined | Boolean | 当前学生是否已加入 |

### 5.7 查询教师创建的课程

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/courses/teacher/{teacherId}` |
| 路径参数 | `teacherId` |
| 响应数据 | `List<CourseListResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| teacherId | Integer | 是 | 教师ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| courseId | Integer | 课程ID |
| title | String | 课程标题 |
| category | String | 课程分类 |
| teacherId | Integer | 教师ID |
| teacherName | String | 教师姓名 |
| status | String | 课程状态 |
| createdAt | LocalDateTime | 创建时间 |
| studentCount | Integer | 已加入学生数 |
| joined | Boolean | 当前学生是否已加入 |

### 5.8 学生加入课程

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/courses/{courseId}/students/{studentId}/join` |
| 路径参数 | `courseId`、`studentId` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| courseId | Integer | 是 | 课程ID |
| studentId | Integer | 是 | 学生ID |

### 5.9 学生退出课程

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/courses/{courseId}/students/{studentId}/leave` |
| 路径参数 | `courseId`、`studentId` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| courseId | Integer | 是 | 课程ID |
| studentId | Integer | 是 | 学生ID |

### 5.10 查询课程学生

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/courses/{courseId}/students` |
| 路径参数 | `courseId` |
| 请求参数 | `status` |
| 响应数据 | `List<CourseStudentResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| courseId | Integer | 是 | 课程ID |
| status | String | 否 | 选课状态：ACTIVE / LEFT |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| enrollmentId | Integer | 选课记录ID |
| courseId | Integer | 课程ID |
| studentId | Integer | 学生ID |
| username | String | 用户名 |
| fullName | String | 学生姓名 |
| email | String | 邮箱 |
| phone | String | 手机号 |
| avatar | String | 学生头像地址 |
| status | String | 选课状态 |
| enrolledAt | LocalDateTime | 加入课程时间 |

### 5.11 查询学生课程

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/courses/by-student/{studentId}` |
| 路径参数 | `studentId` |
| 请求参数 | `status` |
| 响应数据 | `List<StudentCourseResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| studentId | Integer | 是 | 学生ID |
| status | String | 否 | 选课状态：ACTIVE / LEFT |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| enrollmentId | Integer | 选课记录ID |
| courseId | Integer | 课程ID |
| title | String | 课程标题 |
| description | String | 课程描述 |
| category | String | 课程分类 |
| teacherId | Integer | 教师ID |
| teacherName | String | 教师姓名 |
| courseStatus | String | 课程状态 |
| enrollmentStatus | String | 选课状态 |
| enrolledAt | LocalDateTime | 加入课程时间 |

## 6. 学习资料模块

基础路径：`/api/materials`

### 6.1 保存资料上传记录

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/materials` |
| 请求体 | `MaterialUploadReq` |
| 响应数据 | `MaterialDetailResp` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| courseId | Integer | 是 | 课程ID |
| title | String | 是 | 资料标题 |
| materialType | String | 是 | 资料类型：PDF / VIDEO / NOTE / PPT / OTHER |
| filePath | String | 是 | 文件路径或 OSS 文件访问地址 |
| fileSize | Long | 否 | 文件大小，单位字节 |
| uploadedBy | Integer | 是 | 上传者ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| materialId | Integer | 资料ID |
| courseId | Integer | 课程ID |
| courseTitle | String | 课程标题 |
| title | String | 资料标题 |
| materialType | String | 资料类型 |
| filePath | String | 文件路径 |
| fileSize | Long | 文件大小 |
| uploadedBy | Integer | 上传者ID |
| uploaderName | String | 上传者姓名 |
| createdAt | LocalDateTime | 上传时间 |

### 6.2 删除资料

| 项目 | 内容 |
| --- | --- |
| 请求方式 | DELETE |
| 请求路径 | `/api/materials/{materialId}` |
| 路径参数 | `materialId` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| materialId | Integer | 是 | 资料ID |

### 6.3 查询资料详情

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/materials/{materialId}` |
| 路径参数 | `materialId` |
| 响应数据 | `MaterialDetailResp` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| materialId | Integer | 是 | 资料ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| materialId | Integer | 资料ID |
| courseId | Integer | 课程ID |
| courseTitle | String | 课程标题 |
| title | String | 资料标题 |
| materialType | String | 资料类型 |
| filePath | String | 文件路径 |
| fileSize | Long | 文件大小 |
| uploadedBy | Integer | 上传者ID |
| uploaderName | String | 上传者姓名 |
| createdAt | LocalDateTime | 上传时间 |

### 6.4 查询资料列表

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/materials` |
| 请求参数 | `MaterialQueryReq` |
| 响应数据 | `List<MaterialListResp>` |

请求参数：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| courseId | Integer | 否 | 课程ID |
| materialType | String | 否 | 资料类型 |
| keyword | String | 否 | 搜索关键词 |

资料响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| materialId | Integer | 资料ID |
| courseId | Integer | 课程ID |
| courseTitle | String | 课程标题 |
| title | String | 资料标题 |
| materialType | String | 资料类型 |
| filePath | String | 文件路径 |
| fileSize | Long | 文件大小 |
| uploadedBy | Integer | 上传者ID |
| uploaderName | String | 上传者姓名 |
| createdAt | LocalDateTime | 上传时间 |

## 7. OSS 文件模块

基础路径：`/api/oss`

### 7.1 上传文件到阿里云 OSS

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/oss/upload` |
| 请求类型 | multipart/form-data |
| 请求参数 | `file`、`bizType`、`uploaderId` |
| 响应数据 | `OssUploadResp` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| file | MultipartFile | 是 | 上传文件，字段名为 file |
| bizType | String | 是 | MATERIAL / QUESTION_IMAGE / ANSWER_IMAGE / AVATAR |
| uploaderId | Integer | 是 | 上传者账户ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| originalFilename | String | 原始文件名 |
| fileName | String | 处理后的文件名 |
| objectKey | String | OSS 对象Key |
| fileUrl | String | 文件访问地址，可保存到业务表 |
| bucketName | String | OSS Bucket 名称 |
| contentType | String | 文件 MIME 类型 |
| fileSize | Long | 文件大小，单位字节 |
| bizType | String | 上传业务类型 |

### 7.2 删除 OSS 文件

| 项目 | 内容 |
| --- | --- |
| 请求方式 | DELETE |
| 请求路径 | `/api/oss/file` |
| 请求参数 | `objectKey` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| objectKey | String | 是 | OSS 对象Key |

### 7.3 获取 OSS 文件访问地址

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/oss/url` |
| 请求参数 | `objectKey` |
| 响应数据 | String 文件访问地址 |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| objectKey | String | 是 | OSS 对象Key |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| data | String | OSS 文件访问地址 |

## 8. 测验模块

基础路径：`/api/quizzes`

### 8.1 创建测验

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/quizzes` |
| 请求体 | `QuizCreateReq` |
| 响应数据 | `QuizDetailResp` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| courseId | Integer | 是 | 课程ID |
| title | String | 是 | 测验标题 |
| description | String | 否 | 测验说明 |
| timeLimit | Integer | 否 | 答题时长，单位分钟 |
| totalMarks | Integer | 否 | 测验总分 |
| startTime | LocalDateTime | 否 | 开始时间 |
| endTime | LocalDateTime | 否 | 结束时间 |
| createdBy | Integer | 是 | 创建者ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| quizId | Integer | 测验ID |
| courseId | Integer | 课程ID |
| courseTitle | String | 课程标题 |
| title | String | 测验标题 |
| description | String | 测验说明 |
| timeLimit | Integer | 答题时长，单位分钟 |
| totalMarks | Integer | 测验总分 |
| startTime | LocalDateTime | 开始时间 |
| endTime | LocalDateTime | 结束时间 |
| status | String | 测验状态 |
| createdBy | Integer | 创建者ID |
| creatorName | String | 创建者姓名 |
| createdAt | LocalDateTime | 创建时间 |
| updatedAt | LocalDateTime | 更新时间 |

### 8.2 修改测验

| 项目 | 内容 |
| --- | --- |
| 请求方式 | PUT |
| 请求路径 | `/api/quizzes` |
| 请求体 | `QuizUpdateReq` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| quizId | Integer | 是 | 测验ID |
| title | String | 否 | 测验标题 |
| description | String | 否 | 测验说明 |
| timeLimit | Integer | 否 | 答题时长，单位分钟 |
| totalMarks | Integer | 否 | 测验总分 |
| startTime | LocalDateTime | 否 | 开始时间 |
| endTime | LocalDateTime | 否 | 结束时间 |
| status | String | 否 | 测验状态：DRAFT / PUBLISHED / CLOSED |

### 8.3 发布或关闭测验

| 项目 | 内容 |
| --- | --- |
| 请求方式 | PUT |
| 请求路径 | `/api/quizzes/publish` |
| 请求体 | `QuizPublishReq` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| quizId | Integer | 是 | 测验ID |
| status | String | 是 | 发布状态：PUBLISHED / CLOSED |

### 8.4 删除测验

| 项目 | 内容 |
| --- | --- |
| 请求方式 | DELETE |
| 请求路径 | `/api/quizzes/{quizId}` |
| 路径参数 | `quizId` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| quizId | Integer | 是 | 测验ID |

### 8.5 查询测验详情

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/quizzes/{quizId}` |
| 路径参数 | `quizId` |
| 响应数据 | `QuizDetailResp` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| quizId | Integer | 是 | 测验ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| quizId | Integer | 测验ID |
| courseId | Integer | 课程ID |
| courseTitle | String | 课程标题 |
| title | String | 测验标题 |
| description | String | 测验说明 |
| timeLimit | Integer | 答题时长，单位分钟 |
| totalMarks | Integer | 测验总分 |
| startTime | LocalDateTime | 开始时间 |
| endTime | LocalDateTime | 结束时间 |
| status | String | 测验状态 |
| createdBy | Integer | 创建者ID |
| creatorName | String | 创建者姓名 |
| createdAt | LocalDateTime | 创建时间 |
| updatedAt | LocalDateTime | 更新时间 |

### 8.6 查询测验列表

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/quizzes` |
| 请求参数 | `courseId`、`status` |
| 响应数据 | `List<QuizListResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| courseId | Integer | 否 | 课程ID |
| status | String | 否 | 测验状态：DRAFT / PUBLISHED / CLOSED |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| quizId | Integer | 测验ID |
| courseId | Integer | 课程ID |
| courseTitle | String | 课程标题 |
| title | String | 测验标题 |
| timeLimit | Integer | 答题时长，单位分钟 |
| totalMarks | Integer | 测验总分 |
| startTime | LocalDateTime | 开始时间 |
| endTime | LocalDateTime | 结束时间 |
| status | String | 测验状态 |
| createdBy | Integer | 创建者ID |
| creatorName | String | 创建者姓名 |

## 9. 题目模块

基础路径：`/api/questions`

### 9.1 创建题目

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/questions` |
| 请求体 | `QuestionCreateReq` |
| 响应数据 | `QuestionDetailResp` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| quizId | Integer | 是 | 测验ID |
| questionType | String | 是 | SINGLE_CHOICE / FILL_BLANK / SHORT_ANSWER |
| questionText | String | 是 | 题干 |
| questionImage | String | 否 | 题干图片地址，来自 OSS 上传 |
| optionA | String | 单选题必填 | 选项A |
| optionB | String | 单选题必填 | 选项B |
| optionC | String | 单选题必填 | 选项C |
| optionD | String | 单选题必填 | 选项D |
| correctOption | String | 单选题必填 | 正确答案：A / B / C / D |
| referenceAnswer | String | 填空题或解答题必填 | 参考答案 |
| explanation | String | 否 | 题目解析 |
| marks | Integer | 是 | 分值 |
| topic | String | 否 | 知识点 |

说明：

- 题干可以包含图片，图片地址使用 `questionImage`。
- 选项不支持图片，只保存文字。
- 解答题和填空题使用 `referenceAnswer` 保存参考答案。
- 解析统一使用 `explanation` 字段。

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| questionId | Integer | 题目ID |
| quizId | Integer | 测验ID |
| questionType | String | 题型 |
| questionText | String | 题干 |
| questionImage | String | 题干图片地址 |
| optionA | String | 选项A |
| optionB | String | 选项B |
| optionC | String | 选项C |
| optionD | String | 选项D |
| correctOption | String | 正确答案 |
| referenceAnswer | String | 填空题或解答题参考答案 |
| explanation | String | 题目解析 |
| marks | Integer | 分值 |
| topic | String | 知识点 |
| createdAt | LocalDateTime | 创建时间 |
| updatedAt | LocalDateTime | 更新时间 |

### 9.2 修改题目

| 项目 | 内容 |
| --- | --- |
| 请求方式 | PUT |
| 请求路径 | `/api/questions` |
| 请求体 | `QuestionUpdateReq` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| questionId | Integer | 是 | 题目ID |
| questionType | String | 否 | SINGLE_CHOICE / FILL_BLANK / SHORT_ANSWER |
| questionText | String | 否 | 题干 |
| questionImage | String | 否 | 题干图片地址，来自 OSS 上传 |
| optionA | String | 单选题使用 | 选项A |
| optionB | String | 单选题使用 | 选项B |
| optionC | String | 单选题使用 | 选项C |
| optionD | String | 单选题使用 | 选项D |
| correctOption | String | 单选题使用 | 正确答案：A / B / C / D |
| referenceAnswer | String | 填空题或解答题使用 | 参考答案 |
| explanation | String | 否 | 题目解析 |
| marks | Integer | 否 | 分值 |
| topic | String | 否 | 知识点 |

### 9.3 删除题目

| 项目 | 内容 |
| --- | --- |
| 请求方式 | DELETE |
| 请求路径 | `/api/questions/{questionId}` |
| 路径参数 | `questionId` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| questionId | Integer | 是 | 题目ID |

### 9.4 查询题目详情

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/questions/{questionId}` |
| 路径参数 | `questionId` |
| 响应数据 | `QuestionDetailResp` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| questionId | Integer | 是 | 题目ID |

题目详情响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| questionId | Integer | 题目ID |
| quizId | Integer | 测验ID |
| questionType | String | 题型 |
| questionText | String | 题干 |
| questionImage | String | 题干图片地址 |
| optionA | String | 选项A |
| optionB | String | 选项B |
| optionC | String | 选项C |
| optionD | String | 选项D |
| correctOption | String | 正确答案 |
| referenceAnswer | String | 填空题或解答题参考答案 |
| explanation | String | 题目解析 |
| marks | Integer | 分值 |
| topic | String | 知识点 |
| createdAt | LocalDateTime | 创建时间 |
| updatedAt | LocalDateTime | 更新时间 |

### 9.5 教师端查询题目列表

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/questions/teacher-list` |
| 请求参数 | `quizId` |
| 响应数据 | `List<QuestionListResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| quizId | Integer | 是 | 测验ID |

教师题目列表响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| questionId | Integer | 题目ID |
| quizId | Integer | 测验ID |
| questionType | String | 题型 |
| questionText | String | 题干 |
| questionImage | String | 题干图片地址 |
| optionA | String | 选项A |
| optionB | String | 选项B |
| optionC | String | 选项C |
| optionD | String | 选项D |
| correctOption | String | 正确答案 |
| referenceAnswer | String | 填空题或解答题参考答案 |
| explanation | String | 题目解析 |
| marks | Integer | 分值 |
| topic | String | 知识点 |

### 9.6 学生端查询题目列表

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/questions/student-list` |
| 请求参数 | `quizId`、`attemptId`、`showAnswer` |
| 响应数据 | `List<StudentQuestionResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| quizId | Integer | 是 | 测验ID |
| attemptId | Integer | 否 | 作答记录ID，有值时回显已保存或已提交答案 |
| showAnswer | Boolean | 否 | 是否显示正确答案、参考答案和解析，默认 false |

学生题目响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| questionId | Integer | 题目ID |
| quizId | Integer | 测验ID |
| questionType | String | 题型 |
| questionText | String | 题干 |
| questionImage | String | 题干图片地址 |
| optionA | String | 选项A |
| optionB | String | 选项B |
| optionC | String | 选项C |
| optionD | String | 选项D |
| selectedOption | String | 学生已保存或已提交的单选题答案 |
| answerText | String | 填空题或解答题文字答案 |
| answerImage | String | 解答题图片答案地址 |
| answerStatus | String | ANSWERED / UNANSWERED |
| correctOption | String | 正确答案，提交或截止后返回 |
| referenceAnswer | String | 参考答案，提交或截止后返回 |
| explanation | String | 题目解析，提交或截止后返回 |
| isCorrect | Boolean | 是否答对，提交或截止后返回 |
| awardedMarks | Integer | 本题得分，提交或截止后返回 |
| marks | Integer | 分值 |
| topic | String | 知识点 |

## 10. 作答模块

基础路径：`/api/attempts`

### 10.1 开始或继续作答

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/attempts/start` |
| 请求参数 | `quizId`、`studentId` |
| 响应数据 | 作答记录和学生题目列表 |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| quizId | Integer | 是 | 测验ID |
| studentId | Integer | 是 | 学生ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| attemptId | Integer | 作答记录ID |
| quizId | Integer | 测验ID |
| studentId | Integer | 学生ID |
| status | String | 作答状态：IN_PROGRESS / SUBMITTED |
| startedAt | LocalDateTime | 开始作答时间 |
| submittedAt | LocalDateTime | 提交时间 |
| durationSeconds | Integer | 已用时长，单位秒 |
| questions | List<StudentQuestionResp> | 学生端题目列表，字段同 9.6 |

### 10.2 保存答案

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/attempts/save` |
| 请求体 | `QuizAnswerSaveReq` |
| 响应数据 | 无业务数据，统一返回中 `data = null` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| attemptId | Integer | 是 | 作答记录ID |
| quizId | Integer | 是 | 测验ID |
| studentId | Integer | 是 | 学生ID |
| durationSeconds | Integer | 否 | 当前答题用时，单位秒 |
| answers | List<AnswerReq> | 是 | 已保存的学生答案列表 |

`AnswerReq` 字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| questionId | Integer | 是 | 题目ID |
| selectedOption | String | 单选题使用 | 学生选择的答案：A / B / C / D |
| answerText | String | 填空题或解答题使用 | 文字答案 |
| answerImage | String | 解答题可用 | 图片答案地址，来自 OSS 上传 |
| answerStatus | String | 是 | ANSWERED / UNANSWERED |

说明：

- 未作答题目使用 `answerStatus = UNANSWERED`。
- 单选题保存 `selectedOption`。
- 填空题和解答题保存 `answerText`。
- 解答题答案可能是图片，图片地址保存到 `answerImage`。

### 10.3 提交测验

| 项目 | 内容 |
| --- | --- |
| 请求方式 | POST |
| 请求路径 | `/api/attempts/submit` |
| 请求体 | `QuizSubmitReq` |
| 响应数据 | `QuizResultResp` |

请求体字段：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| attemptId | Integer | 是 | 作答记录ID |
| quizId | Integer | 是 | 测验ID |
| studentId | Integer | 是 | 学生ID |
| durationSeconds | Integer | 否 | 答题用时，单位秒 |
| answers | List<AnswerReq> | 是 | 学生答案列表 |

提交后响应 `QuizResultResp` 字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| attemptId | Integer | 提交记录ID |
| quizId | Integer | 测验ID |
| quizTitle | String | 测验标题 |
| studentId | Integer | 学生ID |
| studentName | String | 学生姓名 |
| score | Integer | 学生得分 |
| totalMarks | Integer | 测验总分 |
| correctCount | Integer | 答对题数 |
| wrongCount | Integer | 答错题数 |
| status | String | 作答状态 |
| startedAt | LocalDateTime | 开始作答时间 |
| submittedAt | LocalDateTime | 提交时间 |
| durationSeconds | Integer | 答题用时，单位秒 |
| answers | List<AnswerResult> | 每道题作答结果 |

`AnswerResult` 字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| questionId | Integer | 题目ID |
| questionType | String | 题型 |
| questionText | String | 题干 |
| questionImage | String | 题干图片地址 |
| optionA | String | 选项A |
| optionB | String | 选项B |
| optionC | String | 选项C |
| optionD | String | 选项D |
| selectedOption | String | 学生选择的单选题答案 |
| answerText | String | 填空题或解答题文字答案 |
| answerImage | String | 解答题图片答案地址 |
| answerStatus | String | 作答状态：ANSWERED / UNANSWERED |
| correctOption | String | 单选题正确答案 |
| referenceAnswer | String | 填空题或解答题参考答案 |
| explanation | String | 题目解析 |
| isCorrect | Boolean | 是否答对 |
| awardedMarks | Integer | 本题得分 |
| marks | Integer | 本题总分 |

### 10.4 查询测验结果

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/attempts/{attemptId}/result` |
| 路径参数 | `attemptId` |
| 响应数据 | `QuizResultResp` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| attemptId | Integer | 是 | 作答记录ID |

响应字段同 10.3 的 `QuizResultResp` 和 `AnswerResult`。

### 10.5 查询学生历史作答

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/attempts/history` |
| 请求参数 | `studentId` |
| 响应数据 | `List<QuizHistoryResp>` |

参数说明：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| studentId | Integer | 是 | 学生ID |

历史作答响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| attemptId | Integer | 提交记录ID |
| quizId | Integer | 测验ID |
| quizTitle | String | 测验标题 |
| courseId | Integer | 课程ID |
| courseTitle | String | 课程标题 |
| score | Integer | 学生得分 |
| totalMarks | Integer | 测验总分 |
| status | String | 作答状态 |
| submittedAt | LocalDateTime | 提交时间 |
| durationSeconds | Integer | 答题用时，单位秒 |

## 11. 数据分析模块

基础路径：`/api/analytics`

### 11.1 学生成绩概览

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/analytics/student/summary` |
| 请求参数 | `StudentAnalyticsQueryReq` |
| 响应数据 | `StudentSummaryResp` |

请求参数：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| studentId | Integer | 是 | 学生ID |
| courseId | Integer | 否 | 课程ID |
| quizId | Integer | 否 | 测验ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| studentId | Integer | 学生ID |
| studentName | String | 学生姓名 |
| totalAttempts | Integer | 参加测验次数 |
| averageScore | Double | 平均分 |
| highestScore | Integer | 最高分 |
| lowestScore | Integer | 最低分 |
| passRate | Double | 通过率 |

### 11.2 学生成绩趋势

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/analytics/student/progress` |
| 请求参数 | `StudentAnalyticsQueryReq` |
| 响应数据 | `List<StudentProgressResp>` |

请求参数：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| studentId | Integer | 是 | 学生ID |
| courseId | Integer | 否 | 课程ID |
| quizId | Integer | 否 | 测验ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| quizId | Integer | 测验ID |
| quizTitle | String | 测验标题 |
| courseId | Integer | 课程ID |
| courseTitle | String | 课程标题 |
| score | Integer | 学生得分 |
| totalMarks | Integer | 测验总分 |
| submittedAt | LocalDateTime | 提交时间 |

### 11.3 学生薄弱知识点

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/analytics/student/weak-topics` |
| 请求参数 | `StudentAnalyticsQueryReq` |
| 响应数据 | `List<WeakTopicResp>` |

请求参数：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| studentId | Integer | 是 | 学生ID |
| courseId | Integer | 否 | 课程ID |
| quizId | Integer | 否 | 测验ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| topic | String | 知识点 |
| totalCount | Integer | 答题总数 |
| wrongCount | Integer | 错题数量 |
| accuracy | Double | 正确率 |

### 11.4 排行榜

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/analytics/leaderboard` |
| 请求参数 | `courseId`、`quizId` |
| 响应数据 | `List<LeaderboardResp>` |

请求参数：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| courseId | Integer | 否 | 课程ID |
| quizId | Integer | 否 | 测验ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| rank | Integer | 排名 |
| studentId | Integer | 学生ID |
| studentName | String | 学生姓名 |
| avatar | String | 学生头像地址 |
| score | Integer | 单次测验得分 |
| averageScore | Double | 平均分 |
| totalAttempts | Integer | 参加测验次数 |

### 11.5 教师课程成绩

| 项目 | 内容 |
| --- | --- |
| 请求方式 | GET |
| 请求路径 | `/api/analytics/teacher/course-scores` |
| 请求参数 | `TeacherAnalyticsQueryReq` |
| 响应数据 | `List<TeacherCourseScoreResp>` |

请求参数：

| 字段 | 类型 | 必填 | 说明 |
| --- | --- | --- | --- |
| teacherId | Integer | 是 | 教师ID |
| courseId | Integer | 否 | 课程ID |
| quizId | Integer | 否 | 测验ID |

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| courseId | Integer | 课程ID |
| courseTitle | String | 课程标题 |
| quizId | Integer | 测验ID |
| quizTitle | String | 测验标题 |
| studentId | Integer | 学生ID |
| studentName | String | 学生姓名 |
| score | Integer | 学生得分 |
| totalMarks | Integer | 测验总分 |
| submittedAt | LocalDateTime | 提交时间 |

## 12. Service 接口说明

当前 Service 层全部为接口定义，ServiceImpl 只返回业务默认值（`null`、空列表、空字符串或 `void`），不写业务逻辑。`JsonData` 只用于 Controller 层统一包装接口响应。

| Service | 主要职责 |
| --- | --- |
| AccountService | 注册、登录、当前用户、修改资料、修改密码、登出 |
| AdminService | 用户列表、账户状态管理、管理员课程列表 |
| CourseService | 课程创建、修改、删除、详情、列表、教师课程 |
| CourseEnrollmentService | 学生加入课程、退出课程、课程学生列表、学生课程列表 |
| MaterialService | 资料上传记录、删除、详情、列表 |
| OssService | OSS 上传、删除、获取访问地址 |
| QuizService | 测验创建、修改、发布关闭、删除、详情、列表 |
| QuestionService | 题目创建、修改、删除、详情、教师题目列表、学生题目列表 |
| AttemptService | 开始或继续作答、保存答案、提交测验、查询结果、历史作答 |
| AnalyticsService | 学生成绩概览、成绩趋势、薄弱知识点、排行榜、教师课程成绩 |

## 13. 当前开发注意事项

- 当前接口只做结构定义，不包含参数校验、权限校验、数据库操作和业务逻辑。
- 密码加密不暴露 Controller 接口，只保留 `PasswordUtil.encrypt` 和 `PasswordUtil.matches` 作为内部工具方法，不使用密码盐值。
- Token 只保留登录状态接口和工具方法定义，后续实现时再补生成、解析、校验逻辑。
- OSS 上传只定义接口和配置字段，后续实现时再接入阿里云 OSS SDK。
- 题干图片使用 `questionImage` 字段。
- 选项只支持文字，不支持选项图片。
- 解答题图片答案使用 `answerImage` 字段。
- 未作答使用 `answerStatus = UNANSWERED`。
- 学生再次进入已做题目时，通过 `attemptId` 回显 `selectedOption`、`answerText`、`answerImage` 和 `answerStatus`。
- 提交后或截止后，学生端题目列表可以通过 `showAnswer = true` 返回正确答案、参考答案和解析。
