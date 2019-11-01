import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@XmlRootElement(name = "ExportData")
public class AlarmsXML {
   @XmlElement(name = "DataRow")
   private List<AlarmXML> mAlarms;

    @XmlTransient
    public List<AlarmXML> getAlarms() {
        return mAlarms;
    }

    public void setAlarms(List<AlarmXML> Alarms) {
        this.mAlarms = Alarms;
    }

    public void addAlarm(AlarmXML e){
        mAlarms.add(e);
    }
}