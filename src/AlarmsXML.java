import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ExportData")
public class AlarmsXML {
    @XmlElement(name = "DataRow")
    private List<AlarmXML> mAlarms;

    public List<AlarmXML> getAlarms() {
        return mAlarms;
    }

    public void setAlarms(List<AlarmXML> Alarms) {
        this.mAlarms = Alarms;
    }
}