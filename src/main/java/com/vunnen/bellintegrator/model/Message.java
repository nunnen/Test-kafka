package com.vunnen.bellintegrator.model;

import lombok.Data;

@Data
public class Message {
    private long msg_id;
    private long timestamp;
    private String method;
    private String uri;
}
