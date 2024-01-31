import java.util.*;

public class Interfaces {
    public static void main(String args[]) {
        Queen q = new Queen();
        q.moves();

        Bear b = new Bear();
        b.eatPlants();
        b.eatMeat();
    }
}

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves (){
        System.out.println("The queen can move in any direction");
    }
}

class Rook implements ChessPlayer {
    public void moves (){
        System.out.println("Rook moves up, down");
    }
}

interface Herbivore {
    void eatPlants();
}

interface Carnivore {
    void eatMeat();
}

class Bear implements Herbivore, Carnivore{
    public void eatPlants() {
        System.out.println("Bear eats plants");
    }
    public void eatMeat() {
        System.out.println("Bear eats meat");
    }
}