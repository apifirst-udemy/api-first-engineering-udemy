package com.rsouza01.apifirst_server.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Dimension {

    private Integer length;
    private Integer width;
    private Integer height;
}
