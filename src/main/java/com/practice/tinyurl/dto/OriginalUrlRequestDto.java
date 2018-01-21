package com.practice.tinyurl.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class OriginalUrlRequestDto {

    @NonNull
    String shortUrl;
}
