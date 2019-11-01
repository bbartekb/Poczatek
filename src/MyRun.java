public class MyRun extends Thread {



    @Override
    public void run() {
        for(int i=0;i<=20;i++) {
            System.out.println("Watek ");
            try {
                //usypiamy wątek na 100 milisekund
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}