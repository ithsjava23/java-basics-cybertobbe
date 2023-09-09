package org.example;

import java.util.Arrays;


import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        String menuChoise = "";


        String[] timeArray = new String[]{
                "00-01", "01-02", "02-03", "03-04", "04-05", "05-06", "06-07", "07-08", "08-09", "09-10", "10-11", "11-12",
                "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-19", "19-20", "20-21", "21-22", "22-23", "23-24"
        };


        int[] energyPrices = new int[24];
        int[] energyPricesCopied = new int[24];


        do {
            showMenu();
            menuChoise = scanner.nextLine();

            switch (menuChoise) {
                case "1":
                    addEnergyPrices(scanner, energyPrices, energyPricesCopied);
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
                    cheapestFourHours(energyPricesCopied, timeArray);
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

    public static void addEnergyPrices(Scanner scanner, int energyPrices[], int energyPricesCopied[]) {

        for (int i = 0; i < energyPrices.length; i++) {
            System.out.print("Ange elpris: \n");
            int price = scanner.nextInt();
            energyPrices[i] = price;

        }
        //Copy a unsorted array of energyPrices.
        System.arraycopy(energyPrices,0,energyPricesCopied,0,energyPrices.length);

    }

    public static void findMaxMin(int[] arrayPrice, String[] arrayTime) {

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

    public static void cheapestFourHours(int[] energyPricesCopied, String[] timeArray){
        /*double energyPriceOverFourHours =  Double.MAX_VALUE;
        String startHour = "";
        double fourHourMeanPrice;

        for(int i = 0; i<energyPricesCopied.length-4; i++){
            if(energyPriceOverFourHours > (energyPricesCopied[i] + energyPricesCopied[i+1] + energyPricesCopied[i+2] + energyPricesCopied[i+3])){
                energyPriceOverFourHours = (energyPricesCopied[i] + energyPricesCopied[i+1] + energyPricesCopied[i+2] + energyPricesCopied[i+3]);

            }

            startHour = timeArray[i].substring(0,2);

        }

        fourHourMeanPrice = energyPriceOverFourHours/4;

        String response = """
                Påbörja Laddning klockan %s
                Medelpris 4h: %.1f öre/KWh
                """;
        String cheapestTime = String.format(response, startHour, fourHourMeanPrice);
        System.out.print("\n" + cheapestTime);*/

        float fourHourMeanPrice = energyPricesCopied[0] + energyPricesCopied[1] + energyPricesCopied[2] + energyPricesCopied[3];
        String startPoint = timeArray[0];
        for (int i = 1; i < timeArray.length - 3; i++) {
            if (fourHourMeanPrice > (energyPricesCopied[i] + energyPricesCopied[i + 1] + energyPricesCopied[i + 2] + energyPricesCopied[i + 3])) {
                fourHourMeanPrice = (energyPricesCopied[i] + energyPricesCopied[i + 1] + energyPricesCopied[i + 2] + energyPricesCopied[i + 3]);
                startPoint = timeArray[i];
            }
        }
        String[] print = startPoint.split("-");
        System.out.printf(Locale.getDefault(),"Påbörja laddning klockan %s\nMedelpris 4h: %.1f öre/kWh\n",print[0], (fourHourMeanPrice / 4));
    }
}
