package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRegisterReq {

    private String username; // 用户名

    private String password; // 密码，注册时前端提交的明文密码，后续实现时需要加密后保存

    private String confirmPassword; // 确认密码

    private String fullName; // 用户姓名

    private String email; // 邮箱

    private String phone; // 手机号

    private String avatar; // 用户头像地址，可选

    private String role; // 用户角色：ADMIN / TEACHER / STUDENT
}
