package org.example;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {



        String menuChoise;

        Scanner sc = new Scanner(System.in);


        do {
            System.out.print("Elpriser\n");
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
                    System.out.print(menuChoise);
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
}
