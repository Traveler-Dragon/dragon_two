package com.traveler.server.model.bo;


/**
 * 公共响应类
 *
 * @param <T>
 */
public class BaseResponse<T> {

    private static final String CODE_SUCCESS = "200";

    private static final String CODE_FAIL = "500";

    private static final String CODE_ERROR = "500";

    private static final String CODE_NO_LOGIN = "300";

    private String code;

    private String msg;

    private T data;

    public BaseResponse() {
    }

    public BaseResponse(String code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public static <T> BaseResponse<T> success() {
        return new BaseResponse<T>(CODE_SUCCESS, "success", null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>(CODE_SUCCESS, "success", data);
    }

    public static <T> BaseResponse<T> success(String message, T data) {
        return new BaseResponse<T>(CODE_SUCCESS, message, data);
    }

    public static <T> BaseResponse<T> error() {
        return new BaseResponse<T>(CODE_ERROR, "fail", null);
    }

    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<T>(CODE_ERROR, message, null);
    }

    public static <T> BaseResponse<T> error(String code, String message) {
        return new BaseResponse<T>(code, message, null);
    }

    public static <T> BaseResponse<T> error(String code, String message, T data) {
        return new BaseResponse<T>(code, message, data);
    }

    public static <T> BaseResponse<T> noLogin(String message) {
        return new BaseResponse<T>(CODE_NO_LOGIN, message, null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public boolean isSuccess() {
        return CODE_SUCCESS.equals(this.code);
    }
}
