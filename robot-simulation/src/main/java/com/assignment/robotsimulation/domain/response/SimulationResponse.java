package com.assignment.robotsimulation.domain.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SimulationResponse extends BaseResponse{
    private int coordinateX;
    private int coordinateY;
    private String direction;
}
