package thread.control.join.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {
    public static void main(String[] args) {

    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;


        @Override
        public void run() {
            while (runFlag){
                log("작업중");
                sleep(3000);
            }
            log("자원 정리");
            log("자원 종료");
        }
    }
}
