package equo.exercise;

import equo.exercise.models.Drone;
import equo.exercise.models.Plateau;
import equo.exercise.models.Position;
import equo.exercise.services.DroneService;
import equo.exercise.services.FileReaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
public class EquoExerciseApplication {

    public static void main(String[] args) {
        //verify empty args
        if (args.length == 0) {
            System.err.println("Error: You must provide the path to an input file.");
            System.exit(1);
        }

        SpringApplication.run(EquoExerciseApplication.class, args);

        FileReaderService fileReaderService = new FileReaderService();
        DroneService droneService = new DroneService();

        try{
            Scanner scanner = fileReaderService.readFile(args[0]);
            StringBuilder output = new StringBuilder("Final Positions : \n");

            //create the plateau
            int positionX = scanner.nextInt();
            int positionY = scanner.nextInt();
            Plateau plateau = new Plateau(positionX, positionY);

            while (scanner.hasNext()) {
                //get drone position data
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                char direction = scanner.next().charAt(0);

                if (!plateau.insideThePlateau(x, y)) {
                    throw new IllegalArgumentException("Invalid initial drone position. It should be inside the plateau.");
                }

                //create drone
                Drone drone = droneService.createDrone(x, y, direction, plateau);
                String instructions = scanner.next();
                output.append("Drone with ID ")
                        .append(drone.getId())
                        .append(" finished in position ")
                        .append(droneService.executeInstructions(drone, instructions))
                        .append("\n");
            }

            System.out.println(output.toString().trim());
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found.");
        }
    }
}

