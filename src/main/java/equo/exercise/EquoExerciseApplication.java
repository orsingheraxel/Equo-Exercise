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

		Scanner scanner = new Scanner("txt");

		int positionX = scanner.nextInt();
		int positionY = scanner.nextInt();

		if (Plateau.validPlateau(positionX,positionY)){
			Plateau plateau = new Plateau(positionX,positionY);
		}else{
			//error
		}

		while (scanner.hasNext()){
			if ()
		}

		SpringApplication.run(EquoExerciseApplication.class, args);
	}
}
