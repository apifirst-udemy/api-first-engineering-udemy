package com.rsouza01.apifirst_server.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Dimensions {

    private Integer length;
    private Integer width;
    private Integer height;
}
