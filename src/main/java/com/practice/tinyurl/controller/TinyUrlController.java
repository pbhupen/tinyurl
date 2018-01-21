package com.practice.tinyurl.controller;

import com.practice.tinyurl.exception.UrlNotFoundException;
import com.practice.tinyurl.dto.OriginalUrlRequestDto;
import com.practice.tinyurl.dto.ShortUrlRequestDto;
import com.practice.tinyurl.service.TinyUrlService;
import com.practice.tinyurl.util.TinyUrlServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(TinyUrlServiceUtils.APP_URL)
@Slf4j
public class TinyUrlController {

    // TODO logs are not generating check how to fix

    @Autowired
    TinyUrlService tinyUrlService;

    @RequestMapping(value = TinyUrlServiceUtils.SHORTEN_URL_REQUEST, method = RequestMethod.POST)
    public ResponseEntity<String> generateShortUrl(@RequestBody ShortUrlRequestDto requestDto) {
        log.debug("Got request to generate short url for " + requestDto.getOriginalUrl());
        String shortUrl =  tinyUrlService.generateShortUrl(requestDto.getOriginalUrl());
        return ResponseEntity.status(HttpStatus.CREATED).body(shortUrl);
    }

    @RequestMapping(value = TinyUrlServiceUtils.ORIGINAL_URL_REQUEST, method = RequestMethod.POST)
    public ResponseEntity<String> getOriginalUrl(@RequestBody OriginalUrlRequestDto requestDto) throws UrlNotFoundException {
        log.debug("Got request to fetch short url for " + requestDto.getShortUrl());
        String originalUrl = tinyUrlService.getOriginalUrl(requestDto.getShortUrl());
        if(originalUrl == null)
        {
            throw new UrlNotFoundException(requestDto.getShortUrl());
        }
        return ResponseEntity.status(HttpStatus.OK).body(originalUrl);
    }

}
