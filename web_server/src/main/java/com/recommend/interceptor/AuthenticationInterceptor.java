package com.recommend.interceptor;

import cn.hutool.json.JSONUtil;
import com.recommend.common.Response;
import com.recommend.domain.bo.LoginUser;
import com.recommend.service.login.LoginService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * [ 登录拦截器 ]
 */
@Component
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    private LoginService loginService;

    public AuthenticationInterceptor(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 拦截服务器端响应处理ajax请求返回结果
     *
     * @param request
     * @param response
     * @param handler
     * @return 是否通过拦截器
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isHandlerMethod = handler instanceof HandlerMethod;
        if (!isHandlerMethod) {
            return true;
        }
        //放行的Uri前缀
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String target = uri.replaceFirst(contextPath, "");
        List<String> keys = Arrays.asList("userinfo2", "image", "scmail", "fpmail", "login"
                , "usercheck", "usercheckMail", "userregMail", "fpCodeVerify", "caps", "getLoginToken",
                "scphone","usercheckPhone","userregPhone","fpphone", "phoneSupport");
        for (String key : keys) {
            if (target.contains(key)) {
                log.info("target.contains(key):{}",key);
                return true;
            }
        }
        LoginUser user = loginService.get();
        if (user != null&&user.getUname()!=null&&user.getUpass()!=null) {
            return true;
        }
        outputAccessTokenError(response);
        return false;
    }

    /**
     * 登录令牌失效
     *
     * @param response 响应
     * @throws IOException ioexception
     */
    private void outputAccessTokenError(HttpServletResponse response) throws IOException {
        Response<Object> responseDTO = new Response<>(-4004, "Access-Token 失效");
        outputResult(JSONUtil.toJsonStr(responseDTO), response);
    }

    /**
     * 输出默认错误
     *
     * @param response 响应
     * @throws IOException ioexception
     */
    private void outputDefaultError(HttpServletResponse response) throws IOException {
        String msg = Response.error().toString();
        outputResult(msg, response);
    }

    /**
     * 错误输出
     *
     * @param response
     * @throws IOException
     */
    private void outputResult(String msg, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(msg);
        response.flushBuffer();
    }
}
