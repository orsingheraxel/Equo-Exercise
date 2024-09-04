package equo.exercise.models;

public class Plateau {

    private final int[][] plateau;

    public Plateau(int x, int y) {
        plateau= new int [x][y];
    }

    public static boolean validPlateau(int x, int y){
        return x>0 && y>0;
    }

    public boolean insideThePlateau(int x, int y){
        return !(x> plateau.length || y>plateau[0].length);
    }
}
