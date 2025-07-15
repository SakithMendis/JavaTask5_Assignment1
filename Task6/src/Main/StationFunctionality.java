package Main;

import java.io.*;
import java.util.ArrayList;

public class StationFunctionality {

    public ArrayList<String> addStationDataList(){
        ArrayList<String> stations = new ArrayList<>();
        File file = new File("C:\\Users\\snimpura\\Desktop\\JavaTask5_Assignment1\\Task6\\Station List");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line =reader.readLine())!=null) {
                stations.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading the file: ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stations;
    }

    public void  stationsAlongTheJourney (ArrayList<String> stations,String destination,String Start) {
        try {
            if (stations.contains(Start) || stations.contains(destination)) {
                int startIndex = stations.indexOf(Start);
                int endIndex = stations.indexOf(destination);
                if (startIndex > endIndex) {
                    for (int i = endIndex; i <= startIndex; i++) {
                        System.out.println(stations.get(i));
                    }
                } else {
                    for (int i = endIndex; i >= startIndex; i--) {
                        System.out.println(stations.get(i));
                    }
                }
            } else {
                System.out.println("Station not found");
            }


        }catch (Exception e) {
            System.out.println("Station not found");
        }
    }


}
