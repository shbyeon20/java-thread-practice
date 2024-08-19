package thread.control.yield;

public class YieldMain {
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }

    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
