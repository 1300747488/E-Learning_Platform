package com.ray.elearning_platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    /**
     * 首页入口。
     *
     * @return 转发到 webapp 根目录下的 index.jsp 测试首页
     */
    @GetMapping({"/", "/index", "/home"})
    public String index() {
        return "forward:/index.jsp";
    }
}
