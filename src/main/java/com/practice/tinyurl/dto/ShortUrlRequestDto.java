package com.practice.tinyurl.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class ShortUrlRequestDto {

    @NonNull
    String originalUrl;
}
