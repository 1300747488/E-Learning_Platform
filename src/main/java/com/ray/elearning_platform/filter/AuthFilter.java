package com.ray.elearning_platform.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class AuthFilter implements Filter {

    /**
     * 权限校验过滤器。
     *
     * 输入参数：
     * @param request Servlet 请求对象，后续开发时从 request attribute 或 token 中读取 role
     * @param response Servlet 响应对象，后续开发时用于返回无权限 JSON
     * @param chain 过滤器链，权限通过后继续执行
     *
     * 输出结果：
     * 1. 当前默认直接放行，不做任何角色权限校验。
     * 2. 后续实现时，根据请求路径和角色 ADMIN / TEACHER / STUDENT 判断权限。
     * 3. 后续实现时，无权限返回 JsonData.buildError(BizCodeEnum.NO_PERMISSION)。
     *
     * @throws IOException IO异常
     * @throws ServletException Servlet异常
     */
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }
}
