package com.vunnen.bellintegrator.controller;

import com.vunnen.bellintegrator.config.AppConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/config")
public class AdminController {
    private final AppConfig config;

    @PostMapping("/delay/{ms}")
    public HttpStatus setDelay(@PathVariable long ms) {
        log.info("Setting delay to {} ms", ms);
        config.setDelay(ms);
        return HttpStatus.OK;
    }

    @PostMapping("/force500/{value}")
    public HttpStatus setForceInternalError(@PathVariable boolean value) {
        log.info("Force internal error: {}", value);
        config.setForceInternalError(value);
        return HttpStatus.OK;
    }
}

