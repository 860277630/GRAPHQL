package net.boboweike.learn.graphql.domain;

import lombok.Builder;
import lombok.Setter;

import java.util.UUID;

@Setter
@Builder
public class Asset {
    UUID id;
}
