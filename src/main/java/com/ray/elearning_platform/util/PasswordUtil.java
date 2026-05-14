package com.ray.elearning_platform.util;

public class PasswordUtil {

    /**
     * 加密原始密码。
     *
     * @param rawPassword 原始密码，必填；前端提交的明文密码，只用于本次加密处理，不能直接保存
     * @return 默认空字符串；后续实现时返回加密后的密码密文
     */
    public static String encrypt(String rawPassword) {
        return "";
    }

    /**
     * 校验原始密码和已保存密文是否匹配。
     *
     * @param rawPassword       原始密码，必填；用户登录或修改密码时输入的明文密码
     * @param encryptedPassword 已保存的密码密文，必填；数据库 account.password 字段中的值
     * @return 默认 false；后续实现时返回密码是否匹配
     */
    public static Boolean matches(String rawPassword, String encryptedPassword) {
        return false;
    }
}
