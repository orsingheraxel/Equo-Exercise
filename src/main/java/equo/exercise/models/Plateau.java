package equo.exercise.models;

public class Plateau {

    private final int[][] plateau;

    public Plateau(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Invalid arguments to create the plateau. Dimensions must be greater than zero.");
        }
        plateau= new int [x][y];
    }

    public boolean insideThePlateau(int x, int y){
        return !(x> plateau.length || y>plateau[0].length);
    }
}
