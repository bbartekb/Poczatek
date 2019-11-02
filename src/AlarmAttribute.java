import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class AlarmAttribute{

    @XmlAttribute(name = "name")
    private String mName;

    @XmlAttribute(name = "value")
    private String mValue;

    public String getName() {
        return mName;
    }

    public void setName(String aName) {
        this.mName = aName;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String aValue) {
        this.mValue = aValue;
    }
}
