package com.vunnen.bellintegrator.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class AppConfig {
    private long delay = 100;
    private boolean forceInternalError = false;
}
