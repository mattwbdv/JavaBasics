// Stuart Reges
// 5/22/06
// changed 2018 by W.P. Iverson, for CS211 project at Bellevue College
//
// The AnimalInfo interface defines a set of methods for querying the
// state of a animal simulation.  The getX and getY methods return a
// animal's current location in the world.  The getNeighbor method
// takes a direction as a parameter (one of the constants NORTH,
// SOUTH, EAST, WEST or HOLD from the Animal interface).  It
// returns the display character for the animal that is one unit away
// in that direction (a period if the square is empty).  The getHeight
// and getWidth methods return the height and width of the world.

public interface AnimalInfo {
    public int getX();
    public int getY();
    public String getNeighbor(int direction);
    public int getHeight();
    public int getWidth();
}
