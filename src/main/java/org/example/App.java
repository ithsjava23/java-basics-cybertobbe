package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menuChoise = "";


        String[] timeArray = new String[]{
                "00-01", "01-02", "02-03", "03-04", "04-05", "05-06",
                "06-07", "07-08", "08-09", "09-10", "10-11", "11-12",
                "12-13", "13-14", "14-15", "15-16", "16-17", "17-18",
                "18-19", "19-20", "20-21", "21-22", "22-23", "23-24"
        };

        String[] timeArray2 = new String[]{
                "00-01", "01-02", "02-03", "03-04", "04-05", "05-06",
                "06-07", "07-08", "08-09", "09-10", "10-11", "11-12",
                "12-13", "13-14", "14-15", "15-16", "16-17", "17-18",
                "18-19", "19-20", "20-21", "21-22", "22-23", "23-24"
        };
        int[] energyPrices = new int[24];
        int[] energyPrices2 = new int[24];

        do {
            showMenu();
            menuChoise = scanner.nextLine();

            switch (menuChoise) {
                case "1":
                    addEnergyPrices(scanner, energyPrices);
                    for (int i = 0; i < energyPrices.length; i++) {
                        System.out.println(timeArray[i] + "\t" + energyPrices[i] + " öre/kWh" + "\n");
                    }
                    break;
                case "2":
                    findMaxMin(energyPrices, timeArray);
                    break;
                case "3":
                    sortingPrices(energyPrices, timeArray);
                    break;
                case "4":
                    break;


            }

        } while (!"e".equals(menuChoise) && !"E".equals(menuChoise));

    }

    public static void showMenu() {

        String appMenu = """
                Elpriser
                ========
                1. Inmatning
                2. Min, Max och Medel
                3. Sortera
                4. Bästa Laddningstid (4h)
                e. Avsluta
                """;
        System.out.print(appMenu);

    }

    public static void addEnergyPrices(Scanner scanner, int energyPrices[]) {

        for (int i = 0; i < energyPrices.length; i++) {
            System.out.print("Ange elpris: \n");
            int price = scanner.nextInt();
            energyPrices[i] = price;

        }


    }

    public static void findMaxMin(int arrayPrice[], String arrayTime[]) {

        //Find min price and calculate mean price
        double mean = 0;
        int min = arrayPrice[0];
        int indexMin = 0;
        for (int i = 0; i < arrayPrice.length; i++) {

            mean = mean + arrayPrice[i];

            if (arrayPrice[i] < min) {
                min = arrayPrice[i];
                indexMin = i;


            }
        }
        mean = (mean / 24);

        //Find max price
        int max = arrayPrice[0];
        int indexMax = 0;
        for (int i = 0; i < arrayPrice.length; i++) {

            if (arrayPrice[i] > max) {
                max = arrayPrice[i];
                indexMax = i;
            }
        }

        String timeMin = arrayTime[indexMin];
        String timeMax = arrayTime[indexMax];
        //System.out.print("Lägsta pris: " + timeMin + ", " + min + " öre/kwh" + "\n");
        //System.out.print("Högsta pris: " + timeMax + ", " + max + " öre/kwh" + "\n");

        //DecimalFormat df = new DecimalFormat("#.##");
        //System.out.print("Medelpriset: "  + df.format(mean) + "öre/kWh" + "\n");

        String response = """
                Lägsta pris: %s, %d öre/kWh
                Högsta pris: %s, %d öre/kWh
                Medelpris: %.2f öre/kWh
                """;
        String MinMaxMean = String.format(response, timeMin, min, timeMax, max, mean);

        System.out.println(MinMaxMean);
    }

    public static void sortingPrices(int[] arrPrice, String[] timeArray){
        int tempPrice;
        String tempString;

        for (int i = 0; i < arrPrice.length-1; i++) {
            for (int j = 0; j < arrPrice.length - i -1; j++) {
                {
                    if(arrPrice[j] < arrPrice[j+1]){
                        tempPrice = arrPrice[j];
                        arrPrice[j] = arrPrice[j+1];
                        arrPrice[j+1] = tempPrice;

                        tempString = timeArray[j];
                        timeArray[j] = timeArray[j+1];
                        timeArray[j+1] = tempString;
                    }
                }
            }
        }
        for (int i = 0; i < arrPrice.length; i++) {
            System.out.print(timeArray[i] + " " + arrPrice[i] + " öre\n");
        }
    }
}
