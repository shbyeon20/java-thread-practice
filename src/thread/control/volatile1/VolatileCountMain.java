package thread.control.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(1000);

        task.flag = false;
        log("flag = "+ task.flag + ", count = " + task.count+" in main()");



    }

    static class MyTask implements Runnable {

        volatile boolean flag = true;
        volatile long count;

        //boolean flag  = true;
        //long count;


        @Override
        public void run() {
            while(flag){
                count++;
                //1억에 한번 출력
                if(count%100_000_000==0){
                    log("flag = "+ flag + ", count = " + count+" in while()");
                }
            }
            log("flag = "+ flag + ", count = " + count + " 종료");
        }

    }



}
