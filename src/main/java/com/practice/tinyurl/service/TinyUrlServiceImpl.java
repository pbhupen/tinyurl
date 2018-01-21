package com.practice.tinyurl.service;

import com.practice.tinyurl.generator.TinyUrlGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TinyUrlServiceImpl implements TinyUrlService {

    // TODO how to autowire different types of generator based on some configuration
    @Autowired
    TinyUrlGenerator tinyUrlGenerator;

    @Override
    public String generateShortUrl(String originalUrl) {
        log.debug("Generating short url for original url : " + originalUrl);
        String shortUrl = tinyUrlGenerator.generateUrl();
        log.debug("Generated short url '" + shortUrl +  "' for original url : " + originalUrl);
        return shortUrl;
    }

    @Override
    public String getOriginalUrl(String shorUrl) {
        return null;
    }
}
