import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String arg[]) throws IOException, JAXBException {
        List<AlarmBuilder> listOfAlarms = new ArrayList<>();
        ReaderCSV readerCSV = new ReaderCSV();
        List<List<String>> listCSV = readerCSV.getData();

        for(List<String> e: listCSV){
            listOfAlarms.add(new AlarmBuilder.Builder()
                    .notificationIdentifier(e.get(0))
                    .acknowledgeState(e.get(1))
                    .acknowledgeUserID(e.get(2))
                    .alertCount(Integer.getInteger(e.get(3)))
                    .moTTInfo(e.get(4))
                    .eventTime(e.get(5))
                    .build());
        }

        JAXBContext context = JAXBContext.newInstance(AlarmsXML.class);
        Unmarshaller um = context.createUnmarshaller();
        AlarmsXML alarms = (AlarmsXML) um.unmarshal(new FileReader("C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe.xml"));

        List<List<String>> listXML =new ArrayList<>();
        for (AlarmXML alarm : alarms.getAlarms()) {
            List<String> temporary = new ArrayList<>();
            for (AlarmAttribute attribute : alarm.getRecord()) {
                temporary.add("\""+attribute.getValue() + "\"");
            }
            listXML.add(temporary);
        }
        for(List<String> e: listXML){
            System.out.println(e);
        }

    }
}