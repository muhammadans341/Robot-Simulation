package com.assignment.robotsimulation.domain.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimulationResponse extends BaseResponse{
    private int coordinateX;
    private int coordinateY;
    private String direction;
}
