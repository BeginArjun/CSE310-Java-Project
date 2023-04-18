package fileHandle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class fileHandle {

    public static boolean isRoomAvailable(String room, String date) {
        String filePath = "reservations.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equals(date) && data[4].equals(room)) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void writeToCSV(String[] data) {
        String filePath = "reservations.csv";
        
        try (FileWriter writer = new FileWriter(filePath, true)) {
            for (int i = 0; i < data.length; i++) {
                writer.append(data[i]);
                if (i < data.length - 1) {
                    writer.append(",");
                }
            }
            writer.append("\n");
            writer.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}