package com.vunnen.bellintegrator.controller;

import com.vunnen.bellintegrator.dto.MessageDTO;
import com.vunnen.bellintegrator.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping
    public void sendMessage(@RequestBody MessageDTO messageDTO) {
        messageService.getMessage(messageDTO);
    }
}
