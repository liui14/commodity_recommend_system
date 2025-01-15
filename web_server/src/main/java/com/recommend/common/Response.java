package com.recommend.common;

/**
 * 返回类
 *
 * @param <T>
 */
public class Response<T> {

    protected int code;

    protected String msg;

    protected T data;

    private static final int SUCCESS_CODE = 2000;

    private static final int ERROR_CODE = 4000;

    public Response() {
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, T data) {
        super();
        this.code = code;
        this.data = data;
    }

    public Response(int code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static <T> Response<T> succ() {
        return new Response<>(SUCCESS_CODE, "success");
    }

    public static <T> Response<T> succData(T data, String msg) {
        return new Response<>(SUCCESS_CODE, msg, data);
    }

    public static <T> Response<T> succData(T data) {
        return new Response<>(SUCCESS_CODE, data);
    }


    public static <T> Response<T> error() {
        return new Response<>(ERROR_CODE, "false");
    }

    public static <T> Response<T> errorMsg(String msg) {
        return new Response<>(ERROR_CODE, msg);
    }

    public String getMsg() {
        return msg;
    }

    public Response<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Response<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public Response<T> setData(T data) {
        this.data = data;
        return this;
    }


    @Override
    public String toString() {
        return "ResponseDTO{" + "code=" + code + ", msg='" + msg + ", data=" + data
                + '}';
    }
}
