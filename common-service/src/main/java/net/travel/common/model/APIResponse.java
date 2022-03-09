package net.travel.common.model;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.Nullable;



public class APIResponse<T> implements Serializable {
	private static final long serialVersionUID = -5703947198742752613L;
    public static final String DEFAULT_OK_STATUS = "201";
    public static final String DEFAULT_ERROR_STATUS = "500";

    public static final String SUCCESS = "successfully";
    public static final String ERROR = "error";

    private String message = SUCCESS;
    private String error = ERROR;
    private Integer count = 0;
    private T data = null;

    public APIResponse() {
        this(null);
    }

    public APIResponse(@Nullable T data) {
        this( "", SUCCESS, data, 0);
    }

    public APIResponse( @Nullable String error, @Nullable String message, @Nullable T data) {
        this.message = Optional.ofNullable(message).orElse(SUCCESS);
        this.data = data;
        this.count = 0;
        
        this.error = error;
    }
    public APIResponse( @Nullable String error, @Nullable String message, @Nullable T data, @Nullable Integer count) {
        this.message = Optional.ofNullable(message).orElse(SUCCESS);
        this.data = data;
        this.count = count;
        this.error = error;
    }

    public static <T> APIResponse<T> ok(@Nullable T data) {
        return new APIResponse<>(data);
    }

    public static <T> APIResponse<T> general(@Nullable String message, @Nullable T data) {
        return new APIResponse<>("", message, data);
    }

    public static <T> APIResponse<T> general(@Nullable String message, @Nullable T data, @Nullable Integer count) {
        return new APIResponse<>("", message, data, count);
    }

    public static <T> APIResponse<T> error(@Nullable String message) {
        return error(message, null);
    }

    public static <T> APIResponse<T> error(@Nullable String message, @Nullable T data) {
        return new APIResponse<>("error", message, data);
    }

    public APIResponse<T> setMessage(@Nullable String message) {
        this.message = Optional.ofNullable(message).orElse(SUCCESS);
        return this;
    }

    public APIResponse<T> setCount(@Nullable Integer count) {
        this.count = count;
        return this;
    }

    public APIResponse<T> setData(@Nullable T data) {
        this.data = data;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Integer getCount() {
        return count;
    }

    public Optional<T> optionalData() {
        return Optional.ofNullable(data);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResponseModel [");
        builder.append("message=");
        builder.append(message);
        builder.append("]");
        return builder.toString();
    }
}
