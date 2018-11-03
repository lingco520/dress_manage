package com.battcn.framework.common.exception;

import com.battcn.framework.common.exception.enums.CustomResponseCode;

import java.text.MessageFormat;

/**
 * 自定义异常。
 *
 * @author Levin
 * @since 2018-01-10
 */
public class BattcnException extends BaseException {

    private static final long serialVersionUID = -8994969925213820584L;

    private static final int BAD_REQUEST = 400;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int RESOURCE_REPLICATION = 409;

    /**
     * 规范的HTTP状态响应码,如400/403/503等
     */
    private transient int code;
    /**
     * 自定义返回码
     */
    private int customCode;

    public static BattcnException badRequest(String message, Object... arguments) {
        return new BattcnException(BAD_REQUEST, MessageFormat.format(message, arguments));
    }

    public static BattcnException badRequest(String message) {
        return new BattcnException(BAD_REQUEST, message);
    }

    public static BattcnException badRequest(CustomResponseCode responseCode) {
        return new BattcnException(BAD_REQUEST, responseCode.code(), responseCode.message());
    }

    public static BattcnException badRequest(Integer customCode, String message) {
        return new BattcnException(BAD_REQUEST, customCode, message);
    }

    public static BattcnException notFound(String message, Object... arguments) {
        return new BattcnException(NOT_FOUND, MessageFormat.format(message, arguments));
    }

    public static BattcnException notFound(String message) {
        return new BattcnException(NOT_FOUND, message);
    }

    public static BattcnException notFound(CustomResponseCode responseCode) {
        return new BattcnException(NOT_FOUND, responseCode.code(), responseCode.message());
    }

    public static BattcnException notFound(Integer customCode, String message) {
        return new BattcnException(NOT_FOUND, customCode, message);
    }

    public static BattcnException resourceReplication(String message) {
        return new BattcnException(RESOURCE_REPLICATION, message);
    }

    public static BattcnException forbidden() {
        return new BattcnException(FORBIDDEN, "登录过期,请重新登录");
    }

    public BattcnException(String message) {
        super(message);
        this.setCustomCode(BAD_REQUEST);
        this.setCode(BAD_REQUEST);
    }

    public BattcnException(String message, Throwable e) {
        super(message, e);
        this.setCustomCode(BAD_REQUEST);
        this.setCode(BAD_REQUEST);
    }

    public BattcnException(int code, String message) {
        super(message);
        this.setCustomCode(code);
        this.setCode(code);
    }

    public BattcnException(int code, int customcode, String message) {
        super(message);
        this.setCustomCode(customcode);
        this.setCode(code);
    }

    public BattcnException(int code, String message, Throwable t) {
        super(message, t);
        this.code = code;
    }

    public ErrorResponseEntity toErrorResponseEntity() {
        return new ErrorResponseEntity(this.customCode, this.getMessage());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCustomCode() {
        return customCode;
    }

    public void setCustomCode(int customcode) {
        this.customCode = customcode;
    }

}
