package com.assignment.robotsimulation.enums;

import com.assignment.robotsimulation.domain.Coordinates;

public enum Direction {
    NORTH(new Coordinates(0, -1)),
    EAST(new Coordinates(1, 0)),
    SOUTH(new Coordinates(0, 1)),
    WEST(new Coordinates(-1, 0));

    private final Coordinates directionVector;

    private Direction left;

    static {
        NORTH.left = WEST;
        EAST.left = NORTH;
        SOUTH.left = EAST;
        WEST.left = SOUTH;
    }
    private Direction right;

    static {
        NORTH.right = EAST;
        EAST.right = SOUTH;
        SOUTH.right = WEST;
        WEST.right = NORTH;
    }

    private Direction turnaround;
    static{
        NORTH.turnaround = SOUTH;
        EAST.turnaround = WEST;
        SOUTH.turnaround = NORTH;
        WEST.turnaround = EAST;
    }

    Direction(Coordinates directionVector) {
        this.directionVector = directionVector;
    }

    public Direction left() {
        return left;
    }

    public Direction right() {
        return right;
    }
    public Direction turnaround() {
        return turnaround;
    }

    public Coordinates move(Coordinates coordinates,int steps) {
        int newX = coordinates.getX() + ( steps * directionVector.getX());
        int newY = coordinates.getY() + (steps  * directionVector.getY());
        return new Coordinates(newX, newY);
    }

    public static Direction fromString(String direction) {
        for (Direction d : Direction.values()) {
            if (d.name().equalsIgnoreCase(direction)) {
                return d;
            }
        }

        throw new IllegalArgumentException("Invalid direction: " + direction);
    }

}
