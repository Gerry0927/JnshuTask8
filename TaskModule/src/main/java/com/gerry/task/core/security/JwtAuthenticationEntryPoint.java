package com.gerry.task.core.security;

import com.gerry.task.utils.ServletUtils;
import com.jnshu.common.constant.CommonResult;
import com.jnshu.common.utils.JSONUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//        e.printStackTrace();
        int code = HttpStatus.UNAUTHORIZED.value();
        String msg = "认证失败，请重新登录";
        ServletUtils.renderString(httpServletResponse, JSONUtil.toJSONString(CommonResult.error(code,msg)));
    }
}
