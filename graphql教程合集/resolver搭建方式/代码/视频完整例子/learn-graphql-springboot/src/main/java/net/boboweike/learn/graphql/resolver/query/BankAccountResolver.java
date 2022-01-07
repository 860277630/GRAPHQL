package net.boboweike.learn.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import net.boboweike.learn.graphql.domain.BankAccount;
import net.boboweike.learn.graphql.domain.Currency;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account, id {}", id);

        return BankAccount.builder()
                .id(id)
                .currency(Currency.RMB)
                .build();
    }
}
