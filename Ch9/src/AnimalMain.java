// Stuart Reges
// 9/6/00 (original code with "Building Java Programs" textbook
// changed 2018 by W.P. Iverson, for CS211 project at Bellevue College
//
//
// AnimalMain provides method main for a simple simulation program.

public class AnimalMain {
    public static void main(String[] args) {
        AnimalFrame frame = new AnimalFrame();

        frame.add(25, Bird.class);
        frame.add(25, Frog.class);
        frame.add(25, Mouse.class);
        frame.add(25, Rabbit.class);
        frame.add(25, Snake.class);
        frame.add(25, Turtle.class);
        frame.add(25, Wolf.class);

        frame.start();
    }
}
