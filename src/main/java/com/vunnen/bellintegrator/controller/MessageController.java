package com.vunnen.bellintegrator.controller;

import com.vunnen.bellintegrator.dto.MessageIn;
import com.vunnen.bellintegrator.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/post-message")
    public HttpStatus sendMessage(@RequestBody MessageIn messageIn) {
        String message = messageService.getMessage(messageIn);
        messageService.sendMessage(message);
        return HttpStatus.OK;
    }
}
