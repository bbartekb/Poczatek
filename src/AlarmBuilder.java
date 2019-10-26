import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class AlarmBuilder {
    private String notificationIdentifier;
    private String acknowledgeState;
    private String acknowledgeUserID;
    private Integer alertCount;
    private String moTTInfo;
    private Date eventTime;

    public static final class Builder {
        private String notificationIdentifier;
        private String acknowledgeState;
        private String acknowledgeUserID;
        private Integer alertCount;
        private String moTTInfo;
        private Date eventTime ;
        SimpleDateFormat formatter = new SimpleDateFormat("\"dd-MM-yyyy HH:mm:ss\"");



        public Builder notificationIdentifier(String notificationIdentifier) {
            this.notificationIdentifier = notificationIdentifier;
            return this;
        }

        public Builder acknowledgeState(String acknowledgeState) {
            this.acknowledgeState = acknowledgeState;
            return this;
        }

        public Builder acknowledgeUserID(String acknowledgeUserID) {
            this.acknowledgeUserID = acknowledgeUserID;
            return this;
        }

        public Builder alertCount(Integer alertCount) {
            this.alertCount = alertCount;
            return this;
        }

        public Builder moTTInfo(String moTTInfo) {
            this.moTTInfo = moTTInfo;
            return this;
        }


        public Builder eventTime(String eventTime){
            try {
                this.eventTime = formatter.parse(eventTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return this;
        }


        public AlarmBuilder build() {
            if(notificationIdentifier.isEmpty()){
                throw new IllegalStateException("Notification Identifier cannot be empty");
            }
            if(acknowledgeState.isEmpty()){
                throw new IllegalStateException("Acknowledge State cannot be empty");
            }
            if(eventTime.toString().isEmpty()){
                throw new IllegalStateException("Event Time cannot be empty");
            }

            AlarmBuilder alarm = new AlarmBuilder();
            alarm.notificationIdentifier = this.notificationIdentifier;
            alarm.acknowledgeState= this.acknowledgeState;
            alarm.acknowledgeUserID = this.acknowledgeUserID;
            alarm.alertCount = this.alertCount;
            alarm.moTTInfo = this.moTTInfo;
            alarm.eventTime = this.eventTime;
            return alarm;
        }
    }
}