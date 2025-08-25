package com.vunnen.bellintegrator.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MessageTo {
    private long msg_id;
    private long timestamp;
    private String method;
    private String uri;
}
