package com.vunnen.bellintegrator.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageTo {
    private String msg_id;
    private String timestamp;
    private String method;
    private String uri;
}
