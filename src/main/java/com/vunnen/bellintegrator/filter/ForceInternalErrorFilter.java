package com.vunnen.bellintegrator.filter;

import com.vunnen.bellintegrator.config.AppConfig;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class ForceInternalErrorFilter extends OncePerRequestFilter {

    private final AppConfig config;

    public ForceInternalErrorFilter(AppConfig config) {
        this.config = config;
    }

    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse resp,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = req.getRequestURI();

        if (path.startsWith("/config")) {
            filterChain.doFilter(req, resp);
            return;
        }

        sleep();

        if (config.isForceInternalError()) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Forced 500");
            return;
        }

        filterChain.doFilter(req, resp);
    }

    private void sleep() {
        try {
            Thread.sleep(config.getDelay());
        } catch (InterruptedException e) {
            log.error("Thread error while sleeping", e);
            throw new RuntimeException(e);
        }
    }
}



