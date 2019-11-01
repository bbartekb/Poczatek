import com.sun.xml.internal.bind.v2.TODO;

import java.io.File;

public class ChceckUpdate extends Thread{

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
                    System.out.println("Zmiana");
                    Modified();
                }
                else{
                    System.out.println("Bez zmiany");
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
