package com.assignment.robotsimulation.domain;

import com.assignment.robotsimulation.enums.Direction;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Robot {
    private Direction direction;
    private Coordinates coordinates;
    @Override
    public String toString() {
        return coordinates.getX() + "," + coordinates.getY() + "," + direction.name();
    }
    public Coordinates move(int steps) {
        return direction.move(coordinates, steps);
    }
    public void turn(Direction newDirection) {
        direction = newDirection;
    }
}
