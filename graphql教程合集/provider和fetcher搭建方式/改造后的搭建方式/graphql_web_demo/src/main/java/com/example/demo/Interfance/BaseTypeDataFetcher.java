package com.example.demo.Interfance;

import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class BaseTypeDataFetcher implements MyDataFetcher {
    @Override
    public String fieldName() {
        return "baseType";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        return "shshshshshhs";
    }
}
