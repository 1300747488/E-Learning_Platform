package com.ray.elearning_platform.service;

import com.ray.elearning_platform.req.AccountChangePasswordReq;
import com.ray.elearning_platform.req.AccountLoginReq;
import com.ray.elearning_platform.req.AccountRegisterReq;
import com.ray.elearning_platform.req.AccountUpdateProfileReq;
import com.ray.elearning_platform.resp.AccountLoginResp;
import com.ray.elearning_platform.resp.CurrentUserResp;

public interface AccountService {

    /**
     * 用户注册。
     *
     * @param req 注册请求体，包含用户名、密码、确认密码、姓名、联系方式和角色
     * @return 注册成功后的当前用户信息
     */
    CurrentUserResp register(AccountRegisterReq req);

    /**
     * 用户登录。
     *
     * @param req 登录请求体，包含用户名和密码
     * @return 登录结果，包含用户信息、token 和过期时间
     */
    AccountLoginResp login(AccountLoginReq req);

    /**
     * 查询当前登录用户信息。
     *
     * @param token 请求头中的登录令牌
     * @return 当前用户信息
     */
    CurrentUserResp currentUser(String token);

    /**
     * 修改个人资料。
     *
     * @param req 个人资料更新请求体
     */
    void updateProfile(AccountUpdateProfileReq req);

    /**
     * 修改登录密码。
     *
     * @param req 修改密码请求体，包含账户ID、原密码、新密码和确认新密码
     */
    void changePassword(AccountChangePasswordReq req);

    /**
     * 用户登出。
     *
     * @param token 请求头中的登录令牌
     */
    void logout(String token);
}
