package com.sorcererscode.fileflow.common.exceptions;

import com.sorcererscode.fileflow.common.models.ErrorDto;
import com.sorcererscode.fileflow.common.models.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class ExceptionUtil {

    public static ResponseEntity<Result<?>> buildExceptionResponse(
            Exception exception,
            HttpStatus status
    ) {
        Result<?> responseBody = Result.builder()
                .success(false)
                .error(ErrorDto.builder()
                        .errorMessage(exception.getMessage())
                        .timestamp(new Date().toString())
                        .build())
                .build();

        return new ResponseEntity<>(responseBody, status);
    }

}
