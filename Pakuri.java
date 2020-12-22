import javax.swing.*;

public class Pakuri implements Comparable<Pakuri>{
    private String species;//represents the critters
    private int attack;
    private int defense;
    private int speed;

    public Pakuri(String species){//Constructor with 1 argument
        this.species = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    public String getSpecies()//Accessor for species
    {
        return species;

    }
    public int getAttack(){//Accessor for attack

        return attack;
    }
    public int getDefense(){//Accessor for defense

        return defense;
    }
    public int getSpeed() {//Accessor for speed

        return speed;
    }
    public void setAttack(int newAttack){//mutator for attack

        attack = newAttack;
    }
    public void evolve(){//It upgrades an specie
        attack = 2 * attack;
        defense = 4 * defense;
        speed = 3 * speed;
    }

    @Override
    public int compareTo(Pakuri target){
           return this.species.compareTo(target.getSpecies());//Inspired by Andrew Kennedy
    }
}
