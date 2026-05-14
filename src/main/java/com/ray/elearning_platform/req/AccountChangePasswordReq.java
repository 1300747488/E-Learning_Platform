package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountChangePasswordReq {

    private Integer accountId; // 账户ID，必填；用于定位需要修改密码的用户

    private String oldPassword; // 原密码，必填；用于修改密码前校验当前登录用户身份

    private String newPassword; // 新密码，必填；后续实现时需要加密后保存，不能明文入库

    private String confirmPassword; // 确认新密码，必填；需要与 newPassword 保持一致
}
