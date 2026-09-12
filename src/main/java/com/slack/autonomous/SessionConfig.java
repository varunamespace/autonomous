package com.slack.autonomous;

import org.springframework.ai.session.DefaultSessionService;
import org.springframework.ai.session.InMemorySessionRepository;
import org.springframework.ai.session.SessionService;
import org.springframework.ai.session.advisor.SessionMemoryAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig {

    @Bean
    public SessionService sessionService() {
        return DefaultSessionService.builder()
                .sessionRepository(
                        InMemorySessionRepository.builder().build()
                )
                .build();
    }

    @Bean
    public SessionMemoryAdvisor sessionMemoryAdvisor(
            SessionService sessionService) {

        return SessionMemoryAdvisor
                .builder(sessionService)
                .build();
    }
}


//SessionConfig
//   ↓
//SessionService bean
//   ↓
//SessionMemoryAdvisor bean