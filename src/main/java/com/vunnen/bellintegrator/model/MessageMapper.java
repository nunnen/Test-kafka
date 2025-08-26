package com.vunnen.bellintegrator.model;

import com.vunnen.bellintegrator.dto.MessageTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageMapper {

    public Message mapTo(MessageTo messageTo) {
        log.info("MessageMapper mapping messageTo-{} to message", messageTo.getMsg_id());
        Message message = new Message();
        message.setMsg_id(Long.parseLong(messageTo.getMsg_id()));
        message.setTimestamp(Long.parseLong(messageTo.getTimestamp()));
        message.setMethod(messageTo.getMethod());
        message.setUri(messageTo.getUri());
        return message;
    }

}
