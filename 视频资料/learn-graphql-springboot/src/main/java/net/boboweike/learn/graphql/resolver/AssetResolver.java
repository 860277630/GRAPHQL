package net.boboweike.learn.graphql.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import net.boboweike.learn.graphql.domain.Asset;
import net.boboweike.learn.graphql.domain.BankAccount;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class AssetResolver implements GraphQLResolver<BankAccount> {
    private final ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public CompletableFuture<List<Asset>> assets(BankAccount bankAccount) {
        return CompletableFuture.supplyAsync(
                () -> {
                    log.info("Getting assets for bank account id {}", bankAccount.getId());
                    return List.of();
                },
                executorService
        );
    }
}
