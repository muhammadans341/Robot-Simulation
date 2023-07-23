package com.assignment.robotsimulation.domain.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private int resultCode;
    private String resultMessage;
}
