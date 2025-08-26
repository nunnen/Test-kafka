package com.vunnen.bellintegrator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private long msg_id;
    private long timestamp;
    private String method;
    private String uri;
}
