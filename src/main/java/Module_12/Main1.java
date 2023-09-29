package Module_12;

import java.util.concurrent.TimeUnit;

class Main1 {

    public static void main(String[] args) throws InterruptedException {
        int timeCounter = 0;
        Demo demo = new Demo();
        demo.start();
        while (true) {
            System.out.println("timeCounter = " + timeCounter);
            timeCounter++;
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
class Demo extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Минуло 5 секунд");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

