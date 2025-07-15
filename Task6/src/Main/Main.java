package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        StationFunctionality stationDataListReader = new StationFunctionality();
       Main main = new Main();
        Scanner scanner = new Scanner(System.in);
       main.menuFunctionality(stationDataListReader);
       do {
           System.out.print("Starting station:");
           String Start = scanner.nextLine().trim();
           System.out.print("Destination  station:");
           String Destination = scanner.nextLine().trim();
           System.out.println("---------------------------------------------------------------");
           stationDataListReader.stationsAlongTheJourney(stationDataListReader.addStationDataList(), Start, Destination);
           System.out.println("---------------------------------------------------------------");
           System.out.print("Do you want to Continue (y/n):");
           String Input = scanner.nextLine().trim();
           Input = Input.toLowerCase();
            switch (Input) {
                case "y":
                    System.out.println("---------------------------------------------------------------");
                    case "n":
                        break;
                        default:
                            System.out.println("Invalid input");

            }

       }while (true);

    }

    public void menuFunctionality(StationFunctionality stationDataListReader) {
        System.out.println("""
                ---------------------------------------------------------------
                            train travelling simulation
                ---------------------------------------------------------------
                Bellow are the station list
                """);

        ArrayList<String> stations = stationDataListReader.addStationDataList();
        Iterator<String> iterator = stations.iterator();
        do{
            String stationName = iterator.next();
            System.out.println(stationName);
        }while(iterator.hasNext());
        System.out.println("---------------------------------------------------------------");
    }

}