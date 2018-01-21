package com.practice.tinyurl.exception;

public class UrlNotFoundException extends Exception{

    private static String ERROR_MESSAGE = "Url not found : ";

    public UrlNotFoundException(String url)
    {
        super(ERROR_MESSAGE + url);
    }

    public UrlNotFoundException(String url, Exception cause)
    {
        super(ERROR_MESSAGE + url, cause);
    }
}
