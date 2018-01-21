package com.practice.tinyurl.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class ErrorResponseDto {

    private HttpStatus statusCode;
    private String timeStamp;
    private String message;
    private String debugMessage;
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public ErrorResponseDto(HttpStatus statusCode, String message, Exception e)
    {
        this.timeStamp = DATE_FORMAT.format(new Date());
        this.statusCode = statusCode;
        this.message = message;
        this.debugMessage = ExceptionUtils.getStackTrace(e);
    }

    public ErrorResponseDto(HttpStatus statusCode, Exception e)
    {
        this(statusCode, e.getMessage(), e);
    }
}
