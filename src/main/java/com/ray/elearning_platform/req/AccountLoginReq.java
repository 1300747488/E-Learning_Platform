package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountLoginReq {

    private String username; // 用户名

    private String password; // 密码，登录时前端提交的明文密码，后续实现时只用于校验，不直接保存
}
