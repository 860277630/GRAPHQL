package net.boboweike.learn.graphql.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import net.boboweike.learn.graphql.domain.BankAccount;
import net.boboweike.learn.graphql.domain.Client;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
    private final ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public CompletableFuture<Client> client(BankAccount bankAccount) {
        log.info("Stop me for debug");
        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("Retrieving client data for bank account {}", bankAccount.getId());
                    return Client.builder()
                            .id(UUID.randomUUID())
                            .firstName("William")
                            .lastName("Bobo")
                            .build();
                },
                executorService
        );
    }
}
