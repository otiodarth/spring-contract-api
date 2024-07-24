package com.otiodarth.contract.response;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private T data;
    private String message;
    private int statusCode;

    public ApiResponse(T data, String message, int statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static <T> ApiResponse<T> success(T data, String message, int statusCode) {
        return new ApiResponse<>(data, message, statusCode);
    }

    public static ApiResponse<String> error(String message, int statusCode) {
        return new ApiResponse<>(null, message, statusCode);
    }
}
