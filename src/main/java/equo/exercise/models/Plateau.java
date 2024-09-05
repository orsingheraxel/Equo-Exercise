package equo.exercise.models;

public class Plateau {

    private final int borderX;
    private final int borderY;

    public Plateau(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Invalid arguments to create the plateau. Dimensions must be greater than or equal to zero.");
        }
        this.borderX = x;
        this.borderY = y;
    }

    public boolean insideThePlateau(int x, int y) {
        return x >= 0 && x <= borderX && y >= 0 && y <= borderY;
    }
}
