package com.oxygen.common.vo;

/**
 * 结果消息类
 *
 * @author 王兆祚
 * @since 2023-02-28 0:04
 */
public class ResultMessage {
    private Boolean success;
    private String message;

    public ResultMessage() {
    }

    public ResultMessage(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
