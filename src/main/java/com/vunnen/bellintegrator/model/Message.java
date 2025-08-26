package com.vunnen.bellintegrator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name = "msg_id")
    private Long msgId;
    @Column(name = "timestamp")
    private Long timestamp;
    @Column(name = "method")
    private String method;
    @Column(name = "uri")
    private String uri;
}
