package com.ray.elearning_platform.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class LoginFilter implements Filter {

    /**
     * 登录校验过滤器。
     *
     * 输入参数：
     * @param request Servlet 请求对象，后续开发时从请求头 Authorization 中读取 token
     * @param response Servlet 响应对象，后续开发时用于返回未登录 JSON
     * @param chain 过滤器链，校验通过后继续执行
     *
     * 输出结果：
     * 1. 当前默认直接放行，不做任何登录校验。
     * 2. 后续实现时，未登录返回 JsonData.buildError(BizCodeEnum.NO_LOGIN)。
     * 3. 后续实现时，登录成功可把 accountId、role 放入 request attribute。
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
