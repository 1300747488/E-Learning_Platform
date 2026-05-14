<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Learning Platform 接口测试首页</title>
    <style>
        * { box-sizing: border-box; }
        body {
            margin: 0;
            font-family: Arial, "Microsoft YaHei", sans-serif;
            color: #1f2937;
            background: #f4f7fb;
            overflow: hidden;
        }
        .topbar {
            position: sticky;
            top: 0;
            z-index: 10;
            min-height: 64px;
            padding: 12px 28px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            gap: 16px;
            background: #fff;
            border-bottom: 1px solid #e5e7eb;
        }
        .brand { font-size: 20px; font-weight: 700; color: #111827; }
        .base { color: #4b5563; font-size: 13px; word-break: break-all; }
        .page {
            max-width: 1440px;
            margin: 0 auto;
            padding: 24px;
            height: calc(100vh - 64px);
            display: grid;
            grid-template-columns: minmax(360px, 0.95fr) minmax(420px, 1.05fr);
            gap: 18px;
            overflow: hidden;
        }
        .panel {
            background: #fff;
            border: 1px solid #e5e7eb;
            border-radius: 8px;
            padding: 18px;
            box-shadow: 0 10px 26px rgba(15, 23, 42, 0.06);
        }
        h1 { margin: 0 0 8px; font-size: 28px; line-height: 1.25; }
        h2 { margin: 0 0 12px; font-size: 17px; }
        p { margin: 0; color: #4b5563; line-height: 1.7; }
        .left { display: grid; gap: 14px; align-content: start; }
        .left {
            height: 100%;
            overflow: auto;
            padding-right: 4px;
        }
        .right {
            height: 100%;
            display: grid;
            grid-template-rows: minmax(360px, 1fr) minmax(260px, 0.9fr);
            gap: 14px;
            overflow: hidden;
        }
        .request-panel {
            min-height: 0;
            overflow: auto;
        }
        .group { display: grid; gap: 8px; }
        .group-head {
            display: flex;
            align-items: center;
            justify-content: space-between;
            gap: 12px;
        }
        .count {
            font-size: 12px;
            color: #64748b;
            padding: 3px 8px;
            border-radius: 999px;
            background: #eef2ff;
        }
        .buttons {
            display: grid;
            grid-template-columns: repeat(2, minmax(0, 1fr));
            gap: 8px;
        }
        button {
            min-height: 38px;
            border: 1px solid #d1d5db;
            border-radius: 6px;
            background: #fff;
            color: #111827;
            font-size: 13px;
            font-weight: 600;
            cursor: pointer;
            text-align: left;
            padding: 9px 10px;
        }
        button:hover { border-color: #2563eb; background: #eff6ff; }
        .primary {
            color: #fff;
            border-color: #2563eb;
            background: #2563eb;
            text-align: center;
        }
        .secondary {
            color: #2563eb;
            border-color: #bfdbfe;
            background: #eff6ff;
            text-align: center;
        }
        .danger { border-color: #fecaca; color: #991b1b; }
        .method {
            display: inline-block;
            min-width: 48px;
            margin-right: 8px;
            color: #2563eb;
            font-weight: 700;
        }
        .form-grid {
            display: grid;
            grid-template-columns: 130px 1fr;
            gap: 10px;
            align-items: center;
        }
        label {
            color: #374151;
            font-size: 13px;
            font-weight: 700;
        }
        select, input, textarea {
            width: 100%;
            border: 1px solid #d1d5db;
            border-radius: 6px;
            background: #fff;
            color: #111827;
            font: 13px/1.5 Arial, "Microsoft YaHei", sans-serif;
            padding: 9px 10px;
        }
        textarea {
            min-height: 150px;
            max-height: 240px;
            resize: vertical;
            font-family: Menlo, Consolas, monospace;
        }
        .actions {
            display: grid;
            grid-template-columns: repeat(4, minmax(0, 1fr));
            gap: 8px;
            margin-top: 12px;
        }
        pre {
            height: 100%;
            min-height: 160px;
            overflow: auto;
            margin: 0;
            padding: 14px;
            border-radius: 8px;
            background: #111827;
            color: #e5e7eb;
            font-size: 13px;
            line-height: 1.6;
            white-space: pre-wrap;
            word-break: break-word;
        }
        .hint { color: #6b7280; font-size: 13px; }
        .result-panel {
            min-height: 0;
            display: grid;
            grid-template-rows: auto auto minmax(0, 1fr);
            overflow: hidden;
        }
        .file-row {
            display: grid;
            grid-template-columns: 1fr 130px;
            gap: 8px;
        }
        .upload-panel {
            display: none;
            margin-top: 12px;
            padding-top: 12px;
            border-top: 1px solid #e5e7eb;
        }
        .upload-panel.show {
            display: block;
        }
        @media (max-width: 1100px) {
            body { overflow: auto; }
            .page {
                height: auto;
                min-height: calc(100vh - 64px);
                grid-template-columns: 1fr;
                overflow: visible;
            }
            .left,
            .right {
                height: auto;
                overflow: visible;
            }
            .right { grid-template-rows: auto; }
            .request-panel { overflow: visible; }
            pre {
                height: auto;
                max-height: 420px;
            }
        }
        @media (max-width: 680px) {
            .topbar { align-items: flex-start; flex-direction: column; padding: 14px 18px; }
            .page { padding: 14px; }
            .buttons, .actions, .form-grid, .file-row { grid-template-columns: 1fr; }
            h1 { font-size: 23px; }
        }
    </style>
</head>
<body>
<header class="topbar">
    <div class="brand">E-Learning Platform 接口测试首页</div>
    <div class="base">Context Path：${pageContext.request.contextPath}</div>
</header>

<main class="page">
    <section class="left">
        <div class="panel">
            <h1>接口测试面板</h1>
            <p>点击左侧接口会把默认请求加载到右侧表单。你可以实时编辑 Method、Path、Token、JSON 请求体，再点击发送。</p>
        </div>

        <div id="groups"></div>
    </section>

    <section class="right">
        <div class="panel request-panel">
            <h2>可编辑请求表单</h2>
            <div class="form-grid">
                <label for="method">请求方式</label>
                <select id="method">
                    <option>GET</option>
                    <option>POST</option>
                    <option>PUT</option>
                    <option>DELETE</option>
                </select>

                <label for="path">请求路径</label>
                <input id="path" value="/api/courses" placeholder="/api/courses?keyword=Java">

                <label for="token">Authorization</label>
                <input id="token" value="Bearer test-token" placeholder="Bearer token，可为空">

                <label for="body">JSON 请求体</label>
                <textarea id="body" placeholder="GET/DELETE 通常可以留空"></textarea>
            </div>

            <div class="actions">
                <button class="primary" onclick="sendFromForm()">发送当前请求</button>
                <button class="secondary" onclick="formatBody()">格式化 JSON</button>
                <button class="secondary" onclick="clearBody()">清空 Body</button>
                <button class="secondary" onclick="clearResult()">清空结果</button>
            </div>

            <div id="uploadPanel" class="upload-panel">
                <h2>OSS 文件上传表单</h2>
                <div class="form-grid">
                    <label for="uploadFile">文件</label>
                    <input id="uploadFile" type="file">
                    <label for="bizType">业务类型</label>
                    <select id="bizType">
                        <option value="MATERIAL">MATERIAL</option>
                        <option value="QUESTION_IMAGE">QUESTION_IMAGE</option>
                        <option value="ANSWER_IMAGE">ANSWER_IMAGE</option>
                        <option value="AVATAR">AVATAR</option>
                    </select>
                    <label for="uploaderId">上传者ID</label>
                    <input id="uploaderId" value="2">
                </div>
                <div class="actions">
                    <button class="primary" onclick="uploadFromForm()">上传文件</button>
                    <button class="secondary" onclick="hideUploadPanel()">收起上传表单</button>
                </div>
            </div>
        </div>

        <div class="panel result-panel">
            <h2>请求结果</h2>
            <p class="hint">显示请求方法、路径、状态码和响应内容。</p>
            <pre id="result">等待测试接口...</pre>
        </div>
    </section>
</main>

<script>
    const basePath = '${pageContext.request.contextPath}';
    const methodEl = document.getElementById('method');
    const pathEl = document.getElementById('path');
    const tokenEl = document.getElementById('token');
    const bodyEl = document.getElementById('body');
    const resultBox = document.getElementById('result');

    const samples = {
        register: {username: 'test_student', password: '123456', confirmPassword: '123456', fullName: 'Test Student', email: 'student@test.com', phone: '18800000000', avatar: 'https://example.com/avatar.png', role: 'STUDENT'},
        login: {username: 'student01', password: '123456'},
        profile: {accountId: 3, fullName: 'Student One', email: 'student01@test.com', phone: '18800000003', avatar: 'https://example.com/avatar.png'},
        password: {accountId: 3, oldPassword: '123456', newPassword: '1234567', confirmPassword: '1234567'},
        courseCreate: {title: 'Java Web Development', description: 'Test course from homepage.', category: 'Programming', teacherId: 2},
        courseUpdate: {courseId: 1, title: 'Java Web Development Updated', description: 'Updated by homepage.', category: 'Programming', status: 'ACTIVE'},
        material: {courseId: 1, title: 'Java PDF', materialType: 'PDF', filePath: 'https://example.com/java.pdf', fileSize: 1024, uploadedBy: 2},
        quizCreate: {courseId: 1, title: 'Java Basic Quiz', description: 'Homepage test quiz.', timeLimit: 60, totalMarks: 100, startTime: null, endTime: null, createdBy: 2},
        quizUpdate: {quizId: 1, title: 'Java Basic Quiz Updated', description: 'Updated quiz.', timeLimit: 45, totalMarks: 100, startTime: null, endTime: null, status: 'PUBLISHED'},
        quizPublish: {quizId: 1, status: 'PUBLISHED'},
        questionCreate: {quizId: 1, questionType: 'SINGLE_CHOICE', questionText: 'Which option is correct?', questionImage: 'https://example.com/question.png', optionA: 'A', optionB: 'B', optionC: 'C', optionD: 'D', correctOption: 'A', referenceAnswer: 'A', explanation: 'A is correct.', marks: 10, topic: 'Java'},
        questionUpdate: {questionId: 1, questionType: 'SINGLE_CHOICE', questionText: 'Updated question text', questionImage: 'https://example.com/question-updated.png', optionA: 'A', optionB: 'B', optionC: 'C', optionD: 'D', correctOption: 'A', referenceAnswer: 'A', explanation: 'Updated explanation.', marks: 10, topic: 'Java'},
        answerSave: {attemptId: 1, quizId: 1, studentId: 3, durationSeconds: 120, answers: [{questionId: 1, selectedOption: 'A', answerText: null, answerImage: null, answerStatus: 'ANSWERED'}]},
        submit: {attemptId: 1, quizId: 1, studentId: 3, durationSeconds: 300, answers: [{questionId: 1, selectedOption: 'A', answerText: null, answerImage: null, answerStatus: 'ANSWERED'}]}
    };

    const groups = [
        {name: '账号接口', items: [
            ['POST', '/api/account/register', samples.register, '注册用户'],
            ['POST', '/api/account/login', samples.login, '用户登录'],
            ['GET', '/api/account/current', null, '当前用户', true],
            ['PUT', '/api/account/profile', samples.profile, '修改资料'],
            ['PUT', '/api/account/password', samples.password, '修改密码'],
            ['POST', '/api/account/logout', null, '退出登录', true]
        ]},
        {name: '管理员接口', items: [
            ['GET', '/api/admin/users?role=STUDENT&keyword=student', null, '用户列表'],
            ['PUT', '/api/admin/users/3/status?status=ACTIVE', null, '修改用户状态'],
            ['GET', '/api/admin/courses?category=Programming&keyword=Java', null, '管理员课程列表']
        ]},
        {name: '课程接口', items: [
            ['POST', '/api/courses', samples.courseCreate, '创建课程'],
            ['PUT', '/api/courses', samples.courseUpdate, '修改课程'],
            ['DELETE', '/api/courses/1', null, '删除课程'],
            ['GET', '/api/courses/1', null, '课程详情'],
            ['GET', '/api/courses?category=Programming&keyword=Java', null, '课程列表'],
            ['GET', '/api/courses/student-list?studentId=3&category=Programming&keyword=Java', null, '学生端课程列表'],
            ['GET', '/api/courses/teacher/2', null, '教师课程'],
            ['POST', '/api/courses/1/students/3/join', null, '学生加入课程'],
            ['POST', '/api/courses/1/students/3/leave', null, '学生退出课程'],
            ['GET', '/api/courses/1/students?status=ACTIVE', null, '课程学生'],
            ['GET', '/api/courses/by-student/3?status=ACTIVE', null, '学生课程']
        ]},
        {name: '资料接口', items: [
            ['POST', '/api/materials', samples.material, '保存资料记录'],
            ['DELETE', '/api/materials/1', null, '删除资料'],
            ['GET', '/api/materials/1', null, '资料详情'],
            ['GET', '/api/materials?courseId=1&materialType=PDF&keyword=Java', null, '资料列表']
        ]},
        {name: 'OSS 接口', items: [
            ['UPLOAD', '/api/oss/upload', null, '打开上传表单'],
            ['DELETE', '/api/oss/file?objectKey=materials/test.txt', null, '删除 OSS 文件'],
            ['GET', '/api/oss/url?objectKey=materials/test.txt', null, '获取 OSS 地址']
        ]},
        {name: '测验接口', items: [
            ['POST', '/api/quizzes', samples.quizCreate, '创建测验'],
            ['PUT', '/api/quizzes', samples.quizUpdate, '修改测验'],
            ['PUT', '/api/quizzes/publish', samples.quizPublish, '发布测验'],
            ['DELETE', '/api/quizzes/1', null, '删除测验'],
            ['GET', '/api/quizzes/1', null, '测验详情'],
            ['GET', '/api/quizzes?courseId=1&status=PUBLISHED', null, '测验列表']
        ]},
        {name: '题目接口', items: [
            ['POST', '/api/questions', samples.questionCreate, '创建题目'],
            ['PUT', '/api/questions', samples.questionUpdate, '修改题目'],
            ['DELETE', '/api/questions/1', null, '删除题目'],
            ['GET', '/api/questions/1', null, '题目详情'],
            ['GET', '/api/questions/teacher-list?quizId=1', null, '教师题目列表'],
            ['GET', '/api/questions/student-list?quizId=1&attemptId=1&showAnswer=true', null, '学生题目列表']
        ]},
        {name: '作答接口', items: [
            ['POST', '/api/attempts/start?quizId=1&studentId=3', null, '开始或继续作答'],
            ['POST', '/api/attempts/save', samples.answerSave, '保存答案'],
            ['POST', '/api/attempts/submit', samples.submit, '提交测验'],
            ['GET', '/api/attempts/1/result', null, '查询结果'],
            ['GET', '/api/attempts/history?studentId=3', null, '历史作答']
        ]},
        {name: '数据分析接口', items: [
            ['GET', '/api/analytics/student/summary?studentId=3&courseId=1&quizId=1', null, '学生概览'],
            ['GET', '/api/analytics/student/progress?studentId=3&courseId=1&quizId=1', null, '成绩趋势'],
            ['GET', '/api/analytics/student/weak-topics?studentId=3&courseId=1&quizId=1', null, '薄弱知识点'],
            ['GET', '/api/analytics/leaderboard?courseId=1&quizId=1', null, '排行榜'],
            ['GET', '/api/analytics/teacher/course-scores?teacherId=2&courseId=1&quizId=1', null, '教师课程成绩']
        ]}
    ];

    function renderGroups() {
        document.getElementById('groups').innerHTML = groups.map(group => {
            const buttons = group.items.map(item => {
                const danger = item[0] === 'DELETE' ? ' danger' : '';
                return '<button class="' + danger + '" onclick="loadRequestByIndex(\'' + group.name + '\',' + group.items.indexOf(item) + ')"><span class="method">' + item[0] + '</span>' + item[3] + '</button>';
            }).join('');
            return '<div class="panel group"><div class="group-head"><h2>' + group.name + '</h2><span class="count">' + group.items.length + '</span></div><div class="buttons">' + buttons + '</div></div>';
        }).join('');
    }

    function loadRequestByIndex(groupName, index) {
        const group = groups.find(item => item.name === groupName);
        const item = group.items[index];
        if (item[0] === 'UPLOAD') {
            showUploadPanel();
            loadRequest('POST', item[1], null, true);
            return;
        }
        loadRequest(item[0], item[1], item[2], Boolean(item[4]));
    }

    function loadRequest(method, path, body, withToken) {
        methodEl.value = method;
        pathEl.value = path;
        tokenEl.value = withToken ? 'Bearer test-token' : tokenEl.value;
        bodyEl.value = body ? JSON.stringify(body, null, 2) : '';
    }

    function clearResult() {
        resultBox.textContent = '等待测试接口...';
    }

    function clearBody() {
        bodyEl.value = '';
    }

    function showUploadPanel() {
        document.getElementById('uploadPanel').classList.add('show');
    }

    function hideUploadPanel() {
        document.getElementById('uploadPanel').classList.remove('show');
    }

    function appendResult(text) {
        const current = resultBox.textContent === '等待测试接口...' ? '' : resultBox.textContent + '\n\n';
        resultBox.textContent = current + text;
    }

    function formatJson(text) {
        try { return JSON.stringify(JSON.parse(text), null, 2); } catch (e) { return text; }
    }

    function formatBody() {
        if (!bodyEl.value.trim()) {
            return;
        }
        bodyEl.value = formatJson(bodyEl.value);
    }

    function buildHeaders(hasBody) {
        const headers = {};
        if (hasBody) {
            headers['Content-Type'] = 'application/json';
        }
        if (tokenEl.value.trim()) {
            headers['Authorization'] = tokenEl.value.trim();
        }
        return headers;
    }

    async function sendFromForm() {
        const method = methodEl.value;
        const path = pathEl.value.trim();
        const rawBody = bodyEl.value.trim();
        let parsedBody = null;

        if (rawBody) {
            try {
                parsedBody = JSON.parse(rawBody);
            } catch (e) {
                appendResult('JSON 格式错误: ' + e.message);
                return;
            }
        }

        await send(method, path, parsedBody);
    }

    async function send(method, path, body) {
        const options = { method: method, headers: buildHeaders(Boolean(body)) };
        if (body) {
            options.body = JSON.stringify(body);
        }

        appendResult('请求中: ' + method + ' ' + path);
        try {
            const response = await fetch(basePath + path, options);
            const text = await response.text();
            appendResult(method + ' ' + path + '\nHTTP ' + response.status + '\n' + formatJson(text));
        } catch (error) {
            appendResult(method + ' ' + path + '\n请求失败: ' + error.message);
        }
    }

    async function uploadFromForm() {
        const fileInput = document.getElementById('uploadFile');
        const formData = new FormData();
        const file = fileInput.files[0] || new Blob(['homepage upload test'], {type: 'text/plain'});
        formData.append('file', file, fileInput.files[0] ? fileInput.files[0].name : 'homepage-test.txt');
        formData.append('bizType', document.getElementById('bizType').value);
        formData.append('uploaderId', document.getElementById('uploaderId').value);

        const path = '/api/oss/upload';
        appendResult('请求中: POST ' + path);
        try {
            const response = await fetch(basePath + path, {method: 'POST', body: formData});
            const text = await response.text();
            appendResult('POST ' + path + '\nHTTP ' + response.status + '\n' + formatJson(text));
        } catch (error) {
            appendResult('POST ' + path + '\n请求失败: ' + error.message);
        }
    }

    renderGroups();
    loadRequest('GET', '/api/courses?category=Programming&keyword=Java', null, false);
</script>
</body>
</html>
