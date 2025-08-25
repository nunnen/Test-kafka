package com.vunnen.bellintegrator.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MessageTo {
    private String msg_id;
    private String timestamp;
    private String method;
    private String uri;
}
