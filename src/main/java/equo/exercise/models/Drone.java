package equo.exercise.models;

public class Drone {
    private final Position position;
    private final Plateau plateau;

    public Drone (Position position, Plateau plateau){
        this.position=position;
        this.plateau=plateau;
    }

    private void turnLeft(){
        switch(position.getDirection()){
            case 'N': position.setDirection('W');
            case 'W': position.setDirection('S');
            case 'S': position.setDirection('E');
            case 'E': position.setDirection('N');

        }
    }

    private void turnRight(){
        switch(position.getDirection()){
            case 'N': position.setDirection('E');
            case 'E': position.setDirection('S');
            case 'S': position.setDirection('W');
            case 'W': position.setDirection('N');

        }
    }

    private void moveForward(){

        int x = position.getX();
        int y = position.getY();

        switch(position.getDirection()){
            case 'N': y++;
            case 'E': x++;
            case 'S': y--;
            case 'W': x--;
        }

        if (plateau.insideThePlateau(x,y)){
            position.setX(x);
            position.setY(y);
        } else {
            System.out.println("Warning a Drone has outside the plateau");
        }

    }
}
