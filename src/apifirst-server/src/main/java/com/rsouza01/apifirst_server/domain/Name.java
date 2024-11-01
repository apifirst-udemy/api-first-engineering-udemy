package com.rsouza01.apifirst_server.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Name {

    private String prefix;
    private String firstName;
    private String lastName;
    private String suffix;
}