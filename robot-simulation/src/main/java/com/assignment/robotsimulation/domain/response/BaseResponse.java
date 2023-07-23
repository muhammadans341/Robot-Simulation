package com.assignment.robotsimulation.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private int resultCode;
    private String resultMessage;
}
