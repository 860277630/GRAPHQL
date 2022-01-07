package net.boboweike.learn.graphql.listener;

import graphql.kickstart.servlet.core.GraphQLServletListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.Instant;

@Slf4j
@Component
public class LoggingListener implements GraphQLServletListener {
    @Override
    public GraphQLServletListener.RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {
        Instant startTime = Instant.now();
        log.info("Received graphql request");
        return new RequestCallback() {
            @Override
            public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
                // no-op
            }

            @Override
            public void onError(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
                // no-op
            }

            @Override
            public void onFinally(HttpServletRequest request, HttpServletResponse response) {
                log.info("Completed Request. Time Taken: {}",
                        Duration.between(startTime, Instant.now()));
            }
        };
    }
}
