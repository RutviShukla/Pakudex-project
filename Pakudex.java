import java.util.*;

public class Pakudex {

    private int size = 0;//The amount of critters player currently has in a game
    private int capacity;//The maximum amount of critters a player can have in a game
    private Pakuri[] speciesArray;//array of Pakuri object. one of the main attributes
    int keepCount = 0;//represents the current amount of critters in addPakuri

    public Pakudex()//Default Constructor
    {
        capacity = 20;
        speciesArray = new Pakuri[capacity];

    }
    public Pakudex (int _max){//Constructor with 1 parameter
        capacity = _max;
        speciesArray = new Pakuri[_max];//array can hold only up to the capacity
    }

    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public String[] getSpeciesArray()
    {
        if (size == 0) {//if the size is 0 then in the main program it should return null
            return null;
        }

        String[] speciesArrayS = new String[getSize()];//create a new String array that will reflect the current size of the array
        for (int i = 0; i< size; i++){
            speciesArrayS[i] = speciesArray[i].getSpecies();//Will check and see if the specie at an index matches the one in speciesArray
        }
        return speciesArrayS;
    }

    public int[] getStats(String species)
    {
        int[] name = new int[3];//Will help connect to Pakuri class and get attack,defense, and speed

            for(int i = 0; i < size; i++){//Will start at 0 and increment until it's less then it's size
                if (speciesArray[i].getSpecies().equals(species))//if the critter at a certain index already exists
                {
                    name[0] = speciesArray[i].getAttack();
                    name[1] = speciesArray[i].getDefense();
                    name[2] = speciesArray[i].getSpeed();
                    return name;
                }

            }

        return null;
    }

    public void  sortPakuri()
    {
        //Create new array with no null values
        Pakuri[] sort = new Pakuri[size];//will take in the current size for the sorting
        for (int i = 0; i < size; i++){
            sort[i] = speciesArray[i];//the critter in sort at a certain index should match with the critter in the speciesArray
        }
        Arrays.sort(sort);//Inspired by Andrew Kennedy

        //Overwrite initial array with new values;
        for (int i = 0; i < size; i++){
            speciesArray[i] = sort[i];
        }
    }



    public boolean addPakuri(String species)
    {
        Pakuri name = new Pakuri(species);//create a new obj of Pakuri class
        if(keepCount >= capacity){//if the amount of critters exceed the capacity
            return false;
        }
        else
        {
            for (int i = 0; i < size; i++ ){
                if(speciesArray[i].getSpecies().equals(species)){//if the critter already exists
                    return false;
                }
            }

        }
        speciesArray[keepCount] = name;//if it's a new specie and it doesn't exceed the capacity then it will be added to the array
        keepCount++;
        size++;
        return true;
    }

    public boolean evolveSpecies(String species)
    {
        for(int i = 0; i < size; i++){
            if (speciesArray[i].getSpecies().equals(species)){//if the specie exists already
                speciesArray[i].evolve();//That specific specie at a certain index in the array will evolve
                return true;
            }
        }
        return false;
    }
}
