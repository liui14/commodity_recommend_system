package com.recommend.interceptor;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @Description: 获取header中的token的值
 * @Author XMuser
 * @Date 2021-06-03 14:21
 */
public class RequestHolder {

    private RequestHolder() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * 获取对应的HttpServletRequest对象
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取请求头中的Access-Token值
     *
     * @return {@link Optional<String>}
     */
    public static Optional<String> getAccessToken() {
        return Optional.ofNullable(getRequest().getHeader("Access-Token"));
    }

    /**
     * 获取请求头中的Code-Token值
     *
     * @return {@link Optional<String>}
     */
    public static Optional<String> getCodeToken() {
        return Optional.ofNullable(getRequest().getHeader("Code-Token"));
    }

}
