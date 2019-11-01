import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

public class AlarmXML {
   @XmlElement(name = "Record")
    private List<AlarmAttribute> mAttributes;

    @XmlTransient
    public List<AlarmAttribute> getRecord() {
        return mAttributes;
    }

    public void setRecord(List<AlarmAttribute> Attributes) {
        this.mAttributes = Attributes;
    }
}