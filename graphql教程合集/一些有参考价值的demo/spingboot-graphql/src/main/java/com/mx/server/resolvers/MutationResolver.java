package com.mx.server.resolvers;

import com.mx.server.entity.BankAccount;
import com.mx.server.entity.Currency;
import com.mx.server.entity.User;
import com.mx.server.entity.input.AddUserInput;
import com.mx.server.entity.response.ResponseBuilder;
import com.mx.server.entity.response.Result;
import com.mx.server.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class MutationResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private static final Logger logger = LogManager.getLogger(MutationResolver.class);

    @Resource
    private UserService userService;

    public Result addUser(String mail, String nickname, String password, String description) {
        logger.info("Mutation Resolver ==> addUser");
        logger.info("params: mail:{}, nickname:{}, password:{}, description:{}",
                mail, nickname, password, description);
        return userService.addUser(mail, nickname, password, description);
    }

    public Result deleteUser(String id) {
        if(StringUtils.isAnyBlank(id)){
            return ResponseBuilder.getRespCodeMsg(-101, "参数缺失");
        }
        logger.info("Mutation Resolver ==> deleteUser");
        logger.info("params: id:{}", id);
        return userService.deleteUser(id);
    }
    
    public User updateUser(String id, String mail, String nickname, String description) {
        logger.info("Mutation Resolver ==> updateUser");
        logger.info("params: id:{}, mail:{}, nickname:{}, description:{}",
                id, mail, nickname, description);
        return userService.updateUser(id, mail, nickname, description);
    }

    public User addUserByInput(AddUserInput addUserInput){
        logger.info("Mutation Resolver ==> addUserByInput");
        logger.info("params: {}", addUserInput);
        return userService.addUserInput(addUserInput);
    }

    public BankAccount bankAccount(UUID id) {
        logger.info("Retrieving bank account, id {}", id);

        return BankAccount.builder()
                .id(id)
                .currency(Currency.RMB)
                .build();
    }
}
