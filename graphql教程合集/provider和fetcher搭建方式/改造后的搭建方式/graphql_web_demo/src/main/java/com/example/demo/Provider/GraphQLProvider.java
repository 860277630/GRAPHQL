package com.example.demo.Provider;

import com.example.demo.Interfance.MyDataFetcher;
import com.example.demo.config.DateTimeScalarType;
import com.example.demo.config.LongScalarType;
import com.example.demo.config.MapScalarType;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    List<MyDataFetcher> fetchers;//依赖注入实现类


    //  加载graphql  并且解析方法  加载该类时自动进行填充
    //  被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行
    @PostConstruct
    public void init() throws FileNotFoundException {






        File file = ResourceUtils.getFile("classpath:graphql/user.graphqls");
        GraphQLSchema graphQLSchema = createGraphQLSchema(file);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }



    //给上面的方法init调用   封装了解析  graphql的方法
    public GraphQLSchema createGraphQLSchema(File file){
        SchemaGenerator schemaGenerator = new SchemaGenerator();

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeRegistry = schemaParser.parse(file);


        return schemaGenerator.makeExecutableSchema(typeRegistry, buildResolver());//注意参数 buildResolver  用于下面的调用
    }

    //然后解释  MyDataFetcher   看不懂为什么要循环
    public RuntimeWiring buildResolver() {
        return RuntimeWiring.newRuntimeWiring()
                //x为接口类型的参数  和runnable方法一样   UnaryOperator  泛型为builder  返回值为泛型
                //所以  x->{}里面就是为了构建一个builder类型即可  用来指定  typeName  fileName  以及datafetcher
                .type("UserQuery", x -> {
                            //接口类型的具体实现方式  UnaryOperator
                            for (MyDataFetcher fetcher : fetchers) {
                                x.dataFetcher(fetcher.fieldName(),
                                        //这里又是一个接口类型的参数  所以需要和runnable方法一样就行实例化
                                        //拉姆达表达式  当有返回值有参数时   x -> System.out.println(x)
                                        //根据官方文档  每个datafetcher都会提供一个dataFetchingEnvironment
                                        dataFetchingEnvironment -> {
                                            return fetcher.dataFetcher(dataFetchingEnvironment);
                                        }
                                );
                            }
                            return x;

                        }



//                        builder.dataFetcher("user",
//                                dataFetchingEnvironment -> {
//                                    Long id = dataFetchingEnvironment.getArgument("id");
//                                    return new User(id,"springboot+graphql" ,15);
//                        }).dataFetcher("card",
//                                dataFetchingEnvironment ->{
//                                    Long id = dataFetchingEnvironment.getArgument("id");
//                                    return  new Card(id, "futian");
//                                })

                )
                //在这里把自定义的类型加进去
                .scalar(new DateTimeScalarType()).scalar(new MapScalarType()).scalar(new LongScalarType())
                .build();
    }




    //将上述lambda表达式  翻译为普通的书写方式为
    public RuntimeWiring buildResolverDemo() {
        return RuntimeWiring.newRuntimeWiring()
                .type("UserQuery",UnaryOperator.identity()).build();
    }


    @Bean
    public GraphQL graphQL(){
        return this.graphQL;
    }

}
