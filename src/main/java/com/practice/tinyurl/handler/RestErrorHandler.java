package com.practice.tinyurl.handler;

import com.practice.tinyurl.exception.UrlNotFoundException;
import com.practice.tinyurl.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler{

    protected ResponseEntity handleHttpMessageNotReadable(HttpMessageNotReadableException e,
                                                                            HttpHeaders headers,
                                                                            HttpStatus status,
                                                                            WebRequest request)
    {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    }

    protected ResponseEntity handleMissingServletRequestPart(MissingServletRequestPartException e,
                                                                     HttpHeaders headers,
                                                                     HttpStatus status,
                                                                     WebRequest request) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    }

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUrlNotFoundException(UrlNotFoundException e) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, e.getMessage(), e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception e) {
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
    }

    private ResponseEntity<ErrorResponseDto> buildResponseEntity(HttpStatus statusCode,String message,  Exception e)
    {
        ErrorResponseDto errorDto = new ErrorResponseDto(statusCode, message, e );
        return ResponseEntity.status(statusCode).body(errorDto);
    }
}
