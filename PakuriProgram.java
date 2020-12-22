import java.util.Scanner;

public class PakuriProgram {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int maxCap = 0;
        String str = null;
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");//Welcome message
        System.out.print("Enter max capacity of the Pakudex: ");

        boolean check = true;
        while (check){//Will check if user entered a valid size and will continue in the loop until the user enters a valid size
            try {
                String string = scanner.next();
                int a = Integer.parseInt(string);//if the user enters a string
                if(a < 1){//if the integer is less than 1
                    System.out.println("Please enter a valid size.");
                }
                else{
                    maxCap = a;//if it's not a string or a a number less than 1 then the the max capacity will go through
                    break;
                }

            }
            catch (Exception e){
                System.out.println("Please enter a valid size.");
            }
            System.out.print("Enter max capacity of the Pakudex: ");
        }



        Pakudex pakudexCall = new Pakudex(maxCap);//creating a Pakudex object
        System.out.println("The Pakudex can hold " + maxCap + " species of Pakuri.");

        boolean gameStart = true;
        while (gameStart){//Outer while loop


            int userInput = -1;
            while (check){//inner while loop
                try {
                    System.out.println("\n Pakudex Main Menu");//Menu with all the options user can choose from
                    System.out.println("-----------------");
                    System.out.println("1. List Pakuri");
                    System.out.println("2. Show Pakuri");
                    System.out.println("3. Add Pakuri");
                    System.out.println("4. Evolve Pakuri");
                    System.out.println("5. Sort Pakuri");
                    System.out.println("6. Exit");

                    System.out.print("\nWhat would you like to do? ");

                    String string = scanner.next();
                    userInput = Integer.parseInt(string);

                    break;
                }
                catch (Exception e){//if the user's choice wasn't matching up to the one from the menu then an exception will pop up
                    System.out.println("Unrecognized menu selection!");
                }

            }

            if (userInput == 1 ){//List Pakuri
                String[] store = pakudexCall.getSpeciesArray();
                if(store == null){//if there are no Pakuri's stored

                    System.out.println("No Pakuri in Pakudex yet!");
                }
                else {
                    System.out.println("Pakuri In Pakudex: ");
                    for (int i = 0; i < store.length; i++){//Will go through the loop and print out the Pakuri's stored
                        System.out.println((i +1) + ". " + store[i]);
                    }
                }

            }

            else if (userInput == 2) {//Show Pakuri
                System.out.print("Enter the name of the species to display: ");
                String _userInput = scanner.next();
                int[] store = pakudexCall.getStats(_userInput);//Will search Stats to see if the inputted Pakuri exists
                if(store == null){//If the input doesn't match will the ones already added
                    System.out.println("Error: No such Pakuri!");
                }
                else{//Will print out description of that Pakuri
                    System.out.println("Species: " + _userInput);
                    System.out.println("Attack: " + store[0]);
                    System.out.println("Defense: " + store[1]);
                    System.out.println("Speed: " + store[2]);
                }
            }

            else if(userInput == 3){//Add Pakuri

                if(pakudexCall.getSize() >= pakudexCall.getCapacity()) {//If the size exceeds the capacity. Inspired by Angela
                    System.out.println("Error: Pakudex is full! ");
                }
                else {

                    System.out.print("Enter the name of the species to add: ");

                    String _userInput = scanner.next();

                    if (pakudexCall.addPakuri(_userInput)) {//Will add the Pakuri to the deck
                        System.out.println("Pakuri species " + _userInput + " successfully added! ");
                    }
                    else {//however, if the specie already exist then a error message will pop up
                        System.out.println("Error: Pakudex already contains this species! ");
                    }
                }

            }

            else if (userInput == 4) {//Evolve Pakuri
                System.out.println("Enter the name of the species to evolve: ");
                String _userInput = scanner.next();
                if (pakudexCall.evolveSpecies(_userInput)){//Will search for that specie in the array and evolve it
                    System.out.println(_userInput + " has evolved!");
                }
                else{//If that specie doesn't exist then an error will pop up
                    System.out.println("Error: No such Pakuri! ");
                }

            }

            else if (userInput == 5){//Sort Pakuri
                pakudexCall.sortPakuri();//Will connect to the sort method in Pakudex
                System.out.println("Pakuri have been sorted! ");
            }

            else if (userInput == 6){//Exist
                System.out.println("Thanks for using Pakudex! Bye!");
                gameStart = false;
                break;
            }
            else{//If user input isn't one from the menu. Inspired by Robin Fintz
                System.out.println("Unrecognized menu selection!");
            }
        }




    }
}
