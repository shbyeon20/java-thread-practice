package thread.start.test;

import static util.MyLogger.log;

public class StartTestMain2 {
    public static void main(String[] args) {
        new Thread(new Runnable()
        {
            @Override
            public void run() {
                for (int i = 1; i < 6; i++) {
                    log("value : "+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        },"counter").start();


    }

    static class CounterRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 6; i++) {
                log("value : "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
