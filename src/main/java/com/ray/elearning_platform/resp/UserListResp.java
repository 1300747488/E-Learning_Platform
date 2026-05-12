package com.ray.elearning_platform.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListResp {

    private Integer accountId; // 账户ID

    private String username; // 用户名

    private String fullName; // 用户姓名

    private String email; // 邮箱

    private String phone; // 手机号

    private String avatar; // 用户头像地址

    private String role; // 用户角色

    private String status; // 账号状态

    private LocalDateTime createdAt; // 创建时间
}