package org.example;

import java.io.StringBufferInputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

    /*String [] meny = {"ELpriser", "========", "1. Inmatning", "2. Min, Max och Medel", "3. Sortera", "4. Bästa Laddningstid (4h)", "e. Avsluta" };
    for(int i = 0; i<meny.length; i++){
        System.out.println(meny[i]);
    }*/

        String menuChoise = "";

        Scanner sc = new Scanner(System.in);


        do {
            System.out.printf("Elpriser\n");
            System.out.printf("========\n");
            System.out.printf("1. Inmatning\n");
            System.out.printf("2. Min, Max och Medel\n");
            System.out.printf("3. Sortera\n");
            System.out.printf("4. Bästa Laddningstid (4h)\n");
            System.out.printf("e. Avsluta\n");

            System.out.println("Välj meny: ");
            menuChoise = sc.nextLine();

            switch (menuChoise){
                case "1":
                    System.out.println(menuChoise);
                    break;
                case "2":
                    System.out.println(menuChoise);
                    break;
                case "3":
                    System.out.println(menuChoise);
                    break;
                case "4":
                    System.out.println(menuChoise);
                    break;
            }



        }while(!"e".equals(menuChoise) && !"E".equals(menuChoise));








    }
}
