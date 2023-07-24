package com.assignment.robotsimulation.command;

import java.util.Arrays;
import java.util.List;

public class CommandParser {
    public static Command parseCommand(String command) {
        String[] parts = command.split(" ");
        String action = parts[0];
        List<String> arguments = Arrays.asList(parts).subList(1, parts.length);
        return new Command(action, arguments);
    }
}