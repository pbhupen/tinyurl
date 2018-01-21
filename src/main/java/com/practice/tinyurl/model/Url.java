package com.practice.tinyurl.model;

import lombok.Data;

import java.util.Date;

@Data
public class Url {

    String originalUrl;
    String shortUrl;
    String owner;
    Date timeStamp;
}
