import java.io.*;
import java.util.*;

class UnilateFormatter{
    public ArrayList<String> readCSV(String filename){
        ArrayList<String> records = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String v : values ) {
                    records.add(v);
                }

            }
        } catch (Exception b){

        }

        return records;
    }
}