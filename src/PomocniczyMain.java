import com.sun.deploy.util.Waiter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PomocniczyMain {

    public static void main(String arg[]) throws IOException, JAXBException, InterruptedException {


        File mojPlik = new File("C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe2.xml");
        long lastUpdate = mojPlik.lastModified();

        System.out.println("Stworzony: "+lastUpdate);


        JAXBContext context = JAXBContext.newInstance(AlarmsXML.class);

        Unmarshaller um = context.createUnmarshaller();
        AlarmsXML alarms = (AlarmsXML) um.unmarshal(new FileReader("C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe.xml"));
        Marshaller jaxbMarshaller = context.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

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






        List<AlarmXML> list = new ArrayList<>();

        for (int i=0; i<=10; i++){
            List<AlarmAttribute> l1 = new ArrayList<>();

            AlarmAttribute alarmAtt1=new AlarmAttribute();
            alarmAtt1.setName("Notification Identifier");
            alarmAtt1.setValue("Test" + i);

            AlarmAttribute alarmAtt2=new AlarmAttribute();
            alarmAtt2.setName("Acknowledge State");
            alarmAtt2.setValue("T");

            AlarmAttribute alarmAtt3=new AlarmAttribute();
            alarmAtt3.setName("Acknowledge User ID");
            alarmAtt3.setValue("bb1");

            AlarmAttribute alarmAtt4=new AlarmAttribute();
            alarmAtt4.setName("Alert Count");
            alarmAtt4.setValue("22");

            AlarmAttribute alarmAtt5=new AlarmAttribute();
            alarmAtt5.setName("MO TT Info");
            alarmAtt5.setValue("");

            AlarmAttribute alarmAtt6=new AlarmAttribute();
            alarmAtt6.setName("Event Time");
            alarmAtt6.setValue("22");

            l1.add(alarmAtt1);
            l1.add(alarmAtt2);
            l1.add(alarmAtt3);
            l1.add(alarmAtt4);
            l1.add(alarmAtt5);
            l1.add(alarmAtt6);


            AlarmXML al = new AlarmXML();
            al.setRecord(l1);
            alarms.addAlarm(al);
      //  Thread.sleep(100);
     //   System.out.println("wykonal się watek :" +i);
        }




        //WYŚWIETLENIE NA OUT
       jaxbMarshaller.marshal(alarms, System.out);

        //ZAPIS DO PLIKU
        jaxbMarshaller.marshal(alarms, new File("C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe2.xml"));



        class ChceckUpdate extends Thread{

            private File file;
            private long lastUpdate;

            public ChceckUpdate(File file, long lastUpdate){
                this.file=file;
                this.lastUpdate=lastUpdate;
            }

            @Override
            public void run() {
                for(int i=0; i<=40;i++){
                    if(lastUpdate!=file.lastModified()) {
                        System.out.println("Zmiana2");


                        AlarmsXML alarms2 = null;
                        try {
                            alarms2 = (AlarmsXML) um.unmarshal(new FileReader("C:\\Dysk_D\\pliki_do_projektu\\alarmy_gotowe2.xml"));
                        } catch (JAXBException e) {
                            e.printStackTrace();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        List<List<String>> listXML =new ArrayList<>();
                        for (AlarmXML alarm : alarms2.getAlarms()) {
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
                    else{
                       // System.out.println("Bez zmiany");
                    }
                    lastUpdate=file.lastModified();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


            public int Modified(){
                /*   TODO wywaołanie czegos*/
                return 0;
            }

        }

















        lastUpdate = mojPlik.lastModified();
        ChceckUpdate aaavvv = new ChceckUpdate(mojPlik,lastUpdate);
        aaavvv.start();
        MyRun aaavvv2=new MyRun();
        aaavvv2.start();
    }
}
