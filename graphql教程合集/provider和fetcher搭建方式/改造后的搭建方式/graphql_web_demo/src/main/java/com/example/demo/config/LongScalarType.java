package com.example.demo.config;

import graphql.language.IntValue;
import graphql.language.StringValue;
import graphql.schema.*;

import java.math.BigDecimal;
import java.math.BigInteger;

//因为  到目前了解为止  fetcher形式是不支持  ExtendedScalars  所以所有的graphqls都需要  用该种形式实现
public class LongScalarType extends GraphQLScalarType {
    private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);


    //其实照抄ExtendedScalars  里面的Long实现方式就可以  下面就是照抄的
    //见 graphql.scalars.java.JavaPrimitives
    public LongScalarType(){
        super("Long","Long type for graphql", new Coercing<Long, Long>() {

            private Long convertImpl(Object input) {
                if (input instanceof Long) {
                    return (Long) input;
                } else if (isNumberIsh(input)) {
                    BigDecimal value;
                    try {
                        value = new BigDecimal(input.toString());
                    } catch (NumberFormatException e) {
                        return null;
                    }
                    try {
                        return value.longValueExact();
                    } catch (ArithmeticException e) {
                        return null;
                    }
                } else {
                    return null;
                }

            }

            @Override
            public Long serialize(Object input) {
                Long result = convertImpl(input);
                if (result == null) {
                    throw new CoercingSerializeException(
                            "Expected type 'Long' but was '" + typeName(input) + "'."
                    );
                }
                return result;
            }

            @Override
            public Long parseValue(Object input) {
                Long result = convertImpl(input);
                if (result == null) {
                    throw new CoercingParseValueException(
                            "Expected type 'Long' but was '" + typeName(input) + "'."
                    );
                }
                return result;
            }

            @Override
            public Long parseLiteral(Object input) {
                if (input instanceof StringValue) {
                    try {
                        return Long.parseLong(((StringValue) input).getValue());
                    } catch (NumberFormatException e) {
                        throw new CoercingParseLiteralException(
                                "Expected value to be a Long but it was '" + String.valueOf(input) + "'"
                        );
                    }
                } else if (input instanceof IntValue) {
                    BigInteger value = ((IntValue) input).getValue();
                    if (value.compareTo(LONG_MIN) < 0 || value.compareTo(LONG_MAX) > 0) {
                        throw new CoercingParseLiteralException(
                                "Expected value to be in the Long range but it was '" + value.toString() + "'"
                        );
                    }
                    return value.longValue();
                }
                throw new CoercingParseLiteralException(
                        "Expected AST type 'IntValue' or 'StringValue' but was '" + typeName(input) + "'."
                );
            }
        });
    }

    private static boolean isNumberIsh(Object input) {
        return input instanceof Number || input instanceof String;
    }


    private static String typeName(Object input) {
        if (input == null) {
            return "null";
        }

        return input.getClass().getSimpleName();
    }


}
