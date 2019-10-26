import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderCSV {

    List<List<String>> records = new ArrayList<>();

    public ReaderCSV() throws IOException {
        BufferedReader csvRead = new BufferedReader(new FileReader("C:\\mojkatalog\\test123\\alarmy_gotowe.csv"));
        String row;
        while ((row = csvRead.readLine()) != null) {
            String[] data = row.split(";");
            records.add(Arrays.asList(data));
        }
        csvRead.close();
        records.remove(0);
    }

    public List<List<String>> getData(){
        return records;
    }
}