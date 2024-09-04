package equo.exercise;

import equo.exercise.models.Drone;
import equo.exercise.models.Plateau;
import equo.exercise.models.Position;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class EquoExerciseApplicationTests {

	@Test
	public void testFirstInputScenario() {
		//plateau
		Plateau plateau = new Plateau(5, 5);

		//first drone
		Position position1 = new Position(1, 2, 'N');
		Drone drone1 = new Drone(position1, plateau);
		String finalPosition1 = drone1.executeInstructions("LMLMLMLMM");
		assertEquals("(1,3,N)", finalPosition1);

		//second drone
		Position position2 = new Position(3, 3, 'E');
		Drone drone2 = new Drone(position2, plateau);
		String finalPosition2 = drone2.executeInstructions("MMRMMRMRRM");
		assertEquals("(5,1,E)", finalPosition2);
	}

	@Test
	public void testSecondInputScenario() {
		//invalid plateau
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Plateau invalidPlateau = new Plateau(0, 5);
		});

		assertEquals("Invalid arguments to create the plateau. Dimensions must be greater than zero.", exception.getMessage());
	}

}
