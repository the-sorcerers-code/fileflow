package com.sorcererscode.fileflow.auth.exceptions;


import com.sorcererscode.fileflow.common.exceptions.ExceptionUtil;
import com.sorcererscode.fileflow.common.models.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.security.auth.login.LoginException;


@RestControllerAdvice
public class LoginExceptionHandler {
    @ExceptionHandler(value = LoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Result<?>> handleLoginException(LoginException ex,
                                                                  WebRequest request) {
        return ExceptionUtil.buildExceptionResponse(ex, HttpStatus.BAD_REQUEST);
    }
}
