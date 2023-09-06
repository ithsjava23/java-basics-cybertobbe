package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menuChoise = "";


        String [] timeArray = new String[]{
                "00-01", "01-02", "02-03", "03-04", "04-05", "05-06",
                "06-07", "07-08", "08-09", "09-10", "10-11", "11-12",
                "12-13", "13-14", "14-15", "15-16", "16-17", "17-18",
                "18-19", "19-20", "20-21", "21-22", "22-23", "23-24"
        };

        String [] timeArray2 = new String[]{
                "00-01", "01-02", "02-03", "03-04", "04-05", "05-06",
                "06-07", "07-08", "08-09", "09-10", "10-11", "11-12",
                "12-13", "13-14", "14-15", "15-16", "16-17", "17-18",
                "18-19", "19-20", "20-21", "21-22", "22-23", "23-24"
        };
        int [] energyPrices = new int[24];
        int [] energyPrices2 = new int[24];

        do{
            showMenu();
            menuChoise = scanner.nextLine();

            switch(menuChoise){
                case "1":
                    addEnergyPrices(scanner, energyPrices);


                    for(int i = 0; i<energyPrices.length; i++){
                        System.out.println(timeArray[i] + "\t" + energyPrices[i] + " öre/kWh" + "\n");
                    }
                    break;
                case "2":
                    //ToDO Print low, hi price and time. Calc mean
                    break;
                case "3":
                    break;
                case "4":
                    break;


            }

        }while(!"e".equals(menuChoise) && !"E".equals(menuChoise));

    }

    public static void showMenu(){

        String appMenu = """
                Elpriser
                ========
                1. Inmatning
                2. Min, Max, Medel
                3. Sortering
                4. Bästa Laddningstid (4h)
                e. Avsluta
                """;
        System.out.print(appMenu);

    }

    public static void addEnergyPrices(Scanner scanner, int energyPrices []){

        for(int i = 0; i<energyPrices.length; i++) {
            System.out.print("Ange elpris: \n");
            int price = scanner.nextInt();
            energyPrices[i] = price;

        }


    }

}
