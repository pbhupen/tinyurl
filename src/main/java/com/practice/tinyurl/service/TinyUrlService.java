package com.practice.tinyurl.service;

public interface TinyUrlService {

    public String generateShortUrl(String originalUrl);

    public String getOriginalUrl(String shorUrl);
}
