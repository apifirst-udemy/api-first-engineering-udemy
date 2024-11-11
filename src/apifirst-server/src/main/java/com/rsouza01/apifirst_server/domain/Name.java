package com.rsouza01.apifirst_server.domain;

import lombok.*;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Name {

    @Size(min = 0, max = 25)
    private String prefix;

    @NotNull
    @Size(min = 2, max = 100)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 100)
    private String lastName;

    @Size(min = 0, max = 25)
    private String suffix;
}