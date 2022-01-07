package net.boboweike.learn.graphql.resolver.mutation;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class UploadFileMutation implements GraphQLMutationResolver {
    public UUID uploadFile(DataFetchingEnvironment environment) {
      DefaultGraphQLServletContext ctx =  environment.getContext();

      ctx.getFileParts().forEach(
              p -> {
                  log.info("uploading {}, size: {}", p.getSubmittedFileName(), p.getSize());
              }
      );

      return UUID.randomUUID();
    }
}
