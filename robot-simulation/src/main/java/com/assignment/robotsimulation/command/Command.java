package com.assignment.robotsimulation.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Command {
    private final String action;
    private final List<String> arguments;
}