package equo.exercise;

import equo.exercise.models.Drone;
import equo.exercise.models.Plateau;
import equo.exercise.models.Position;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class EquoExerciseApplication {

	public static void main(String[] args) {

        SpringApplication.run(EquoExerciseApplication.class, args);

        Scanner scanner = new Scanner(System.in);

        String output="Final Positions : ";

        //create the plateau
        int positionX = scanner.nextInt();
		int positionY = scanner.nextInt();

        Plateau plateau = new Plateau(positionX,positionY);

        while (scanner.hasNext()) {
            //get drone position data
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char direction = scanner.next().charAt(0);

            if (!plateau.insideThePlateau(x,y)){throw new IllegalArgumentException("Invalid initial drone position. Should be inside the plateau");}

            Position initialPosition = new Position(x, y, direction);
            Drone drone = new Drone(initialPosition, plateau);

            //get drone instructions
            String instructions = scanner.next();

            //execute instructions
            output.concat(drone.executeInstructions(instructions));
        }

        System.out.println(output);
	}

}
