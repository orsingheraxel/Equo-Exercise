package equo.exercise.models;

public class Drone {
    private final Position position;
    private final Plateau plateau;

    public Drone (Position position, Plateau plateau){
        this.position=position;
        this.plateau=plateau;
    }

    public String executeInstructions(String instructions){
        for (char c : instructions.toCharArray()){
            switch(c){
                case 'L': turnLeft(); break;
                case 'R': turnRight(); break;
                case 'M': moveForward(); break;
            }
        }
        return position.toString();
    }

    private void turnLeft(){
        switch(position.getDirection()){
            case 'N': position.setDirection('W'); break;
            case 'W': position.setDirection('S'); break;
            case 'S': position.setDirection('E'); break;
            case 'E': position.setDirection('N'); break;

        }
    }

    private void turnRight(){
        switch(position.getDirection()){
            case 'N': position.setDirection('E'); break;
            case 'E': position.setDirection('S'); break;
            case 'S': position.setDirection('W'); break;
            case 'W': position.setDirection('N'); break;

        }
    }

    private void moveForward(){

        int x = position.getX();
        int y = position.getY();

        switch(position.getDirection()){
            case 'N': y++; break;
            case 'E': x++; break;
            case 'S': y--; break;
            case 'W': x--; break;
        }

        if (plateau.insideThePlateau(x,y)){
            position.setX(x);
            position.setY(y);
        } else {
            System.out.println("Warning a Drone has outside the plateau");
        }

    }
}
