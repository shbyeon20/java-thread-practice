package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV1 {
    public static void main(String[] args) {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        new Thread(task1,"thread-1").start();
        new Thread(task2,"thread-2").start();

        log("task1.result = "+task1.result);
        log("task2.result = "+task2.result);

        int sumAll = task1.result + task2.result;
        log("task1+task2="+sumAll);

        log("End");

    }

    static class SumTask implements Runnable {

        int strValue;
        int endValue;
        int result;

        public SumTask(int strValue, int endValue) {
            this.strValue = strValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업시작");
            sleep(2000);
            int sum =0;

            for (int i = strValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업완료 result= " + result);
        }
    }
}
