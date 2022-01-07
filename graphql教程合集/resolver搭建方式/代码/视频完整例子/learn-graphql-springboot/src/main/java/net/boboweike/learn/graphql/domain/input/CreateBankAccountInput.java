package net.boboweike.learn.graphql.domain.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateBankAccountInput {
    @NotBlank
    String firstName;
    int age;
}
