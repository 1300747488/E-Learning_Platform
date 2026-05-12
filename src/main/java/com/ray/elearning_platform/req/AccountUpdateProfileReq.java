package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateProfileReq {

    private Integer accountId; // 账户ID

    private String fullName; // 用户姓名

    private String email; // 邮箱

    private String phone; // 手机号

    private String avatar; // 用户头像地址
}