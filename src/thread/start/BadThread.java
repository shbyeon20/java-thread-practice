package thread.start;

public class BadThread {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+": main() start");
        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName()+": start() 호출전");
        helloThread.run();
        System.out.println(Thread.currentThread().getName()+": start() 호출후");

        System.out.println(Thread.currentThread().getName()+": main() end");
    }
}
