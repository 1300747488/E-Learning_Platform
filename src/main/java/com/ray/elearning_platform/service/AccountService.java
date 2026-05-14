package com.ray.elearning_platform.service;

import com.ray.elearning_platform.req.AccountLoginReq;
import com.ray.elearning_platform.req.AccountRegisterReq;
import com.ray.elearning_platform.req.AccountUpdateProfileReq;
import com.ray.elearning_platform.util.JsonData;

public interface AccountService {

    /**
     * 用户注册。
     *
     * @param req 注册请求体，包含用户名、密码、确认密码、姓名、联系方式和角色
     * @return 注册结果，成功时可返回账户基础信息
     */
    JsonData register(AccountRegisterReq req);

    /**
     * 用户登录。
     *
     * @param req 登录请求体，包含用户名和密码
     * @return 登录结果，成功时返回 AccountLoginResp，包含用户信息、token 和过期时间
     */
    JsonData login(AccountLoginReq req);

    /**
     * 查询当前登录用户信息。
     *
     * @param token 请求头中的登录令牌
     * @return 当前用户信息 CurrentUserResp
     */
    JsonData currentUser(String token);

    /**
     * 修改个人资料。
     *
     * @param req 个人资料更新请求体
     * @return 修改结果
     */
    JsonData updateProfile(AccountUpdateProfileReq req);

    /**
     * 用户登出。
     *
     * @param token 请求头中的登录令牌
     * @return 登出结果
     */
    JsonData logout(String token);
}
