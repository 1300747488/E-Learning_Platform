package com.ray.elearning_platform.util;

import com.ray.elearning_platform.enums.BizCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonData {

    private Integer code; // 状态码

    private String msg; // 提示信息

    private Object data; // 返回数据

    /**
     * 构建成功返回结果，不携带数据
     *
     * @return JsonData 成功响应对象
     */
    public static JsonData buildSuccess() {
        return new JsonData(BizCodeEnum.SUCCESS.getCode(), BizCodeEnum.SUCCESS.getMsg(), null);
    }

    /**
     * 构建成功返回结果，携带返回数据
     *
     * @param data 返回给前端的数据
     * @return JsonData 成功响应对象
     */
    public static JsonData buildSuccess(Object data) {
        return new JsonData(BizCodeEnum.SUCCESS.getCode(), BizCodeEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 构建失败返回结果，使用默认服务器错误状态码
     *
     * @param msg 错误提示信息
     * @return JsonData 失败响应对象
     */
    public static JsonData buildError(String msg) {
        return new JsonData(BizCodeEnum.SERVER_ERROR.getCode(), msg, null);
    }

    /**
     * 构建失败返回结果，使用业务状态码枚举
     *
     * @param bizCodeEnum 业务状态码枚举
     * @return JsonData 失败响应对象
     */
    public static JsonData buildError(BizCodeEnum bizCodeEnum) {
        return new JsonData(bizCodeEnum.getCode(), bizCodeEnum.getMsg(), null);
    }

    /**
     * 构建失败返回结果，自定义状态码和提示信息
     *
     * @param code 状态码
     * @param msg 错误提示信息
     * @return JsonData 失败响应对象
     */
    public static JsonData buildError(Integer code, String msg) {
        return new JsonData(code, msg, null);
    }
}