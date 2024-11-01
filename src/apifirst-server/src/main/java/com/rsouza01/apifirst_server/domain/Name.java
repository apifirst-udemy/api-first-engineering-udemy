package com.rsouza01.apifirst_server.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Name {

    private String prefix;
    private String firstName;
    private String lastName;
    private String suffix;
}