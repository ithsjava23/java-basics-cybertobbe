package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {



        String menuChoise;

        Scanner sc = new Scanner(System.in);


        do {
            System.out.print("\nElpriser\n");
            System.out.print("========\n");
            System.out.print("1. Inmatning\n");
            System.out.print("2. Min, Max och Medel\n");
            System.out.print("3. Sortera\n");
            System.out.print("4. Bästa Laddningstid (4h)\n");
            System.out.print("e. Avsluta\n");

            System.out.print("Välj meny: \n");
            menuChoise = sc.nextLine();


            switch (menuChoise){
                case "1":
                    //Pass to method insert prices into array
                    //Prices returned to String arr.
                    String[] priser = new String[24];
                    priser = insertPrices();


                    break;
                case "2":
                    System.out.print(menuChoise);

                    break;
                case "3":
                    System.out.print(menuChoise);
                    break;
                case "4":
                    System.out.print(menuChoise);
                    break;
            }



        }while(!"e".equals(menuChoise) && !"E".equals(menuChoise));








    }
   
    //Method takes no parameters but returns a String[] array back to main.
    public static String[] insertPrices(){

        Scanner sc = new Scanner(System.in);
        String tempElpris = "";
        //Create an array of 24 prices.
        String [] elPriser = new String[24];

        //Add prices to array elPriser[]
        System.out.print("Ange 4 elpriser i hela ören för dygnets timmar: \n");
        for(int i=0; i<elPriser.length; i++){
            tempElpris = sc.nextLine();
            elPriser[i] = tempElpris;
        }
        System.out.println("Tack!");
        return elPriser;
    }




}
