package com.szx.server.config.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.szx.server.pojo.RespBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 访问接口没有全权限, 自定义处理
 */
@Configuration
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        RespBean bean = RespBean.error("权限不足!无法登录!");
        bean.setCode(403);
        writer.write(new ObjectMapper().writeValueAsString(bean));
        writer.flush();
        writer.close();
    }
}
