package com.ray.elearning_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Integer accountId; // 账户ID，主键

    private String username; // 用户名

    private String password; // 密码

    private String fullName; // 用户姓名

    private String email; // 邮箱

    private String phone; // 手机号

    private String avatar; // 用户头像地址

    private String role; // 用户角色：ADMIN / TEACHER / STUDENT

    private String status; // 账号状态：ACTIVE / DISABLED / DELETED

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}