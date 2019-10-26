import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class AlarmXML {
    @XmlElement(name = "Record")
    private List<AlarmAttribute> mAttributes;

    public List<AlarmAttribute> getAttributes() {
        return mAttributes;
    }

    public void setAttributes(List<AlarmAttribute> Attributes) {
        this.mAttributes = Attributes;
    }
}