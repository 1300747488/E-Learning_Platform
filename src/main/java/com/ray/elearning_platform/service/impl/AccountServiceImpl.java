package com.ray.elearning_platform.service.impl;

import com.ray.elearning_platform.req.AccountLoginReq;
import com.ray.elearning_platform.req.AccountRegisterReq;
import com.ray.elearning_platform.req.AccountUpdateProfileReq;
import com.ray.elearning_platform.service.AccountService;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    /**
     * 用户注册。
     *
     * @param req 注册请求体，必填；包含 username 用户名、password 密码、confirmPassword 确认密码、
     *            fullName 用户姓名、email 邮箱、phone 手机号、avatar 头像地址、role 用户角色
     * @return 默认成功响应；后续实现时返回新注册账户信息
     */
    @Override
    public JsonData register(AccountRegisterReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 用户登录。
     *
     * @param req 登录请求体，必填；包含 username 用户名和 password 密码
     * @return 默认成功响应；后续实现时返回 AccountLoginResp，包含用户信息、token 和 expireAt
     */
    @Override
    public JsonData login(AccountLoginReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询当前登录用户。
     *
     * @param token 登录令牌，必填；从 Authorization 请求头中解析得到
     * @return 默认成功响应；后续实现时返回 CurrentUserResp
     */
    @Override
    public JsonData currentUser(String token) {
        return JsonData.buildSuccess();
    }

    /**
     * 修改个人资料。
     *
     * @param req 个人资料更新请求体，必填；包含 accountId 账户ID、fullName 姓名、email 邮箱、
     *            phone 手机号和 avatar 头像地址
     * @return 默认成功响应；后续实现时返回修改结果
     */
    @Override
    public JsonData updateProfile(AccountUpdateProfileReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 用户登出。
     *
     * @param token 登录令牌，必填；用于定位当前登录账户或废弃当前令牌
     * @return 默认成功响应；后续实现时返回登出结果
     */
    @Override
    public JsonData logout(String token) {
        return JsonData.buildSuccess();
    }
}
