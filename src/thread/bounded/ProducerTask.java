package thread.bounded;

import static util.MyLogger.log;

import java.util.concurrent.BlockingQueue;

public class ProducerTask implements Runnable {

  private BoundedQueue queue;
  private String request;

  public ProducerTask(BoundedQueue queue, String request) {
    this.queue = queue;
    this.request = request;
  }

  @Override
  public void run() {
    log("[생산시도] " + request + " -> " + queue);
    queue.put(request);
    log("[생산완료] " + request + " -> " + queue);

  }
}
