package Modul4;

import java.util.Scanner;

public class BnSearch {

    public static void main(String[] args) {
        while(true){
            Scanner in = new Scanner(System.in);
            String name;

            String[][] data1 = { { "Alex", "Aqin", "Aril", "Bella" },
                    { "Caca", "Dinda", "Dwi", "Egi" },
                    { "Farli", "Farkhan", "Gilly", "Ichsan" },
                    { "Lidya", "Syahfei", "Syifa", "Wahyu" } };



            System.out.print("Nama yang dicari :");
            name = in.nextLine();

            System.out.println( "Alex \t\tAqin \t\tAril \t\tBella" +
                    "\nCaca \t\tDinda \t\tDwi \t\tEgi" +
                    "\nFarli \t\tFarkhan \tGilly \t\tIchsan" +
                    "\nLidya \t\tSyahfei \tSyifa \t\tWahyu");


            System.out.println();

            String result = binarySearch(data1, name);
            System.out.println(result);

        }
    }
    public static String[] convertArray(String[][] data) {

        String[] convertedArray = new String[data.length * data.length];
        int k = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                convertedArray[k] = data[i][j];
                k++;
            }
        }
        return convertedArray;
    }

    public static String binarySearch(String[][] data, String value) {

        String[] dataArray = convertArray(data);
        int dataMedian = dataArray.length / 2;
        int low = 0, high = dataArray.length - 1, row = 0, column, indexData = 0;
        boolean error = false;

        if (value.compareToIgnoreCase(dataArray[dataMedian]) == 0) {
            indexData = dataMedian;
        }

        else if (value.compareToIgnoreCase(dataArray[dataMedian]) < 0) {
            while (low <= dataMedian) {
                if (value.compareToIgnoreCase(dataArray[low]) == 0) {
                    indexData = low;
                    break;
                }
                low++;
                if (low == dataMedian) {
                    error = true;
                }
            }

        } else {
            while (high >= dataMedian) {
                if (value.compareToIgnoreCase(dataArray[high]) == 0) {
                    indexData = high;
                    break;
                }
                high--;
                if (high == dataMedian) {
                    error = true;
                }
            }
        }
        if (error) {
            return "Nama Tidak Ditemukan !!";
        }

        else {
            while (indexData - data.length >= 0){
                indexData -= data.length;
                row++;
            }
            column = indexData;
        }

        return "Nama ditemukan di (" + row + "," + column + ")";
    }
}











