package com.picketlogia.picket.common.exception;

import com.picketlogia.picket.common.model.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private int httpStatusCodeMapper(int statusCode) {
        if (statusCode >= 40000) {
            return 500;
        }

        return 400;
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<Object>> handleException(BaseException e) {
        return ResponseEntity.status(httpStatusCodeMapper(e.getStatus().getCode()))
                .body(
                        BaseResponse.error(e.getStatus())
                );
    }
}
