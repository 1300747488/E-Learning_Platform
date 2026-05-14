package com.ray.elearning_platform.util;

/**
 * 登录令牌工具类。
 *
 * 说明：
 * 1. 当前只定义方法和默认返回，不写具体 token 生成、解析、验签逻辑。
 * 2. 后续可在这里实现 JWT 或自定义 token。
 * 3. token 中建议包含 accountId、username、role、status、expireAt。
 */
public class TokenUtil {

    /**
     * 生成登录令牌。
     *
     * @param accountId 账户ID
     * @param username 用户名
     * @param role 用户角色：ADMIN / TEACHER / STUDENT
     * @param status 账户状态：ACTIVE / DISABLED / DELETED
     * @param expireAt 过期时间戳，单位毫秒
     * @return 登录令牌字符串
     */
    public static String generateToken(Integer accountId,
                                       String username,
                                       String role,
                                       String status,
                                       Long expireAt) {
        return "";
    }

    /**
     * 校验令牌是否有效。
     *
     * @param token 登录令牌
     * @return true 表示有效，false 表示无效
     */
    public static boolean validateToken(String token) {
        return false;
    }

    /**
     * 判断令牌是否过期。
     *
     * @param token 登录令牌
     * @return true 表示已过期，false 表示未过期
     */
    public static boolean isExpired(String token) {
        return true;
    }

    /**
     * 从令牌中解析账户ID。
     *
     * @param token 登录令牌
     * @return 账户ID
     */
    public static Integer getAccountId(String token) {
        return null;
    }

    /**
     * 从令牌中解析用户名。
     *
     * @param token 登录令牌
     * @return 用户名
     */
    public static String getUsername(String token) {
        return null;
    }

    /**
     * 从令牌中解析用户角色。
     *
     * @param token 登录令牌
     * @return 用户角色：ADMIN / TEACHER / STUDENT
     */
    public static String getRole(String token) {
        return null;
    }

    /**
     * 从令牌中解析账户状态。
     *
     * @param token 登录令牌
     * @return 账户状态：ACTIVE / DISABLED / DELETED
     */
    public static String getStatus(String token) {
        return null;
    }

    /**
     * 从 Authorization 请求头中提取 token。
     *
     * @param authorization Authorization 请求头，格式为 Bearer token
     * @return token 字符串
     */
    public static String getTokenFromAuthorization(String authorization) {
        return null;
    }
}
