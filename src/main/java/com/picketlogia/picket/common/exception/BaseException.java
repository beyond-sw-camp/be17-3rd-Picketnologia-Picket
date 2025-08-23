package com.picketlogia.picket.common.exception;

import com.picketlogia.picket.common.model.BaseResponseStatus;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final BaseResponseStatus status;

    public BaseException(String message, BaseResponseStatus status) {
        super(message);
        this.status = status;
    }

    public static BaseException from(BaseResponseStatus status) {
        return new BaseException(status.getMessage(), status);
    }

}
