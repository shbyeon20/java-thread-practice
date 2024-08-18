package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV0 {

    public static void main(String[] args) {
        log("Start");
        new Thread(new Job(),"Thread-1").start();
        new Thread(new Job(),"Thread-2").start();


        log("End");
    }


    static class Job implements Runnable {

        @Override
        public void run() {
            log("작업시작");
            sleep(2000);
            log("작업종료");
        }
    }
}
