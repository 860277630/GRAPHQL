package com.example.demo.Interfance;

import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class BaseTypesDataFetcher implements MyDataFetcher {
    @Override
    public String fieldName() {
        return "baseTypes";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        return null;
    }
}
