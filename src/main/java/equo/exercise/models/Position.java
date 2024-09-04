package equo.exercise.models;

public class Position {
    private int x;
    private int y;
    private char direction;

    public Position(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public char getDirection() { return direction; }

    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}
    public void setDirection(char c){this.direction=c;}

    @Override
    public String toString (){
        return "("+x+","+y+","+direction+")";
    }
}
