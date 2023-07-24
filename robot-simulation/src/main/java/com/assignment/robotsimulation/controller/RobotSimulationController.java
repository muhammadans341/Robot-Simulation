package com.assignment.robotsimulation.controller;

import com.assignment.robotsimulation.domain.response.SimulationResponse;
import com.assignment.robotsimulation.service.SimulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5174")
public class RobotSimulationController {

    private final SimulationService simulationService;
    @PostMapping("/robot/simulate")
    public ResponseEntity<SimulationResponse> startSimulation(@RequestBody String simulationRound){
        SimulationResponse simulationResponse;
        simulationResponse = simulationService.simulateObject(simulationRound);
        simulationResponse.setResultCode(HttpStatus.OK.value());
        simulationResponse.setResultMessage("Simulation Successful");

        return ResponseEntity.ok(simulationResponse);
    }
}
