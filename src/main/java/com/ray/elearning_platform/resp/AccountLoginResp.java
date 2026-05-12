package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountLoginResp {

    private Integer accountId; // 账户ID

    private String username; // 用户名

    private String fullName; // 用户姓名

    private String email; // 邮箱

    private String phone; // 手机号

    private String avatar; // 用户头像地址

    private String role; // 用户角色：ADMIN / TEACHER / STUDENT

    private String status; // 账号状态
}