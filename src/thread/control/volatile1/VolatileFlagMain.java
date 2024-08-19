package thread.control.volatile1;

public class VolatileFlagMain {
    public static void main(String[] args) {
        Mytask mytask = new Mytask();
        Thread t1 = new Thread(mytask);





    }

    private static class Mytask implements Runnable {

        boolean runFlag = true;


        @Override
        public void run() {
            log("task 시작")
            while (runFlag) {

            }

        }
    }
}
