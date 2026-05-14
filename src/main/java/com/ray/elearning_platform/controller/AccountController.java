package com.ray.elearning_platform.controller;

import com.ray.elearning_platform.req.AccountLoginReq;
import com.ray.elearning_platform.req.AccountRegisterReq;
import com.ray.elearning_platform.req.AccountUpdateProfileReq;
import com.ray.elearning_platform.util.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    /**
     * 用户注册接口。
     *
     * @param req 注册请求体
     * @return 默认成功响应，后续开发时返回账户信息
     */
    @PostMapping("/register")
    public JsonData register(@RequestBody AccountRegisterReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 用户登录接口。
     *
     * @param req 登录请求体
     * @return 默认成功响应，后续开发时返回 AccountLoginResp，包含 token
     */
    @PostMapping("/login")
    public JsonData login(@RequestBody AccountLoginReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 查询当前用户接口。
     *
     * @param authorization 请求头 Authorization，格式为 Bearer token
     * @return 默认成功响应，后续开发时返回 CurrentUserResp
     */
    @GetMapping("/current")
    public JsonData currentUser(@RequestHeader(value = "Authorization", required = false) String authorization) {
        return JsonData.buildSuccess();
    }

    /**
     * 修改个人资料接口。
     *
     * @param req 个人资料更新请求体
     * @return 默认成功响应
     */
    @PutMapping("/profile")
    public JsonData updateProfile(@RequestBody AccountUpdateProfileReq req) {
        return JsonData.buildSuccess();
    }

    /**
     * 用户登出接口。
     *
     * @param authorization 请求头 Authorization，格式为 Bearer token
     * @return 默认成功响应
     */
    @PostMapping("/logout")
    public JsonData logout(@RequestHeader(value = "Authorization", required = false) String authorization) {
        return JsonData.buildSuccess();
    }
}
