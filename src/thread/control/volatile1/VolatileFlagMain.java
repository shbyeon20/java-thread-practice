package thread.control.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {
    public static void main(String[] args) {
        Mytask task = new Mytask();
        Thread thread = new Thread(task);
        log("runflag = "+task.runFlag);
        thread.start();

        sleep(1000);
        task.runFlag = false;
        log("runflag = "+task.runFlag);
        log("main 종료");
    }

    private static class Mytask implements Runnable {

        boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                //run flag가 false가 되면 탈출
                System.out.println("hello");
                sleep(1000);
            }
            log("task 종료");
        }
    }
}
