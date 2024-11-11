package com.rsouza01.apifirst_server.domain;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Dimensions {

    @NotNull
    @Min(1)
    @Max(999)
    private Integer length;

    @NotNull
    @Min(1)
    @Max(999)
    private Integer width;

    @NotNull
    @Min(1)
    @Max(999)
    private Integer height;
}
