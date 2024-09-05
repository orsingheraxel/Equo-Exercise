package equo.exercise.services;

import equo.exercise.models.Drone;
import equo.exercise.models.Plateau;
import equo.exercise.models.Position;

public class DroneService {

    private int droneIdCounter = 1;

    public Drone createDrone(int x, int y, char direction, Plateau plateau) {
        Position position = new Position(x, y, direction);
        return new Drone(droneIdCounter++, position, plateau);
    }

    public String executeInstructions(Drone drone, String instructions) {
        return drone.executeInstructions(instructions);
    }
}
