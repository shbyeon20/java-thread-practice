package thread.bounded;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV2 implements BoundedQueue {

  private final Queue<String> queue = new ArrayDeque<>();
  private final int max;

  public BoundedQueueV2(int max) {
    this.max = max;
  }

  @Override
  public synchronized void put(String data) {
    while (queue.size() == max) {
      log("[put] 큐가 가득참, 대기 ");
      sleep(1000);
    }

    queue.offer(data);
  }

  @Override
  public synchronized String take() {
    if (queue.isEmpty()) {
      log("[take] 큐에 데이터 없음, 대기 ");
      sleep(1000);
    }

    return queue.poll();
  }

  @Override
  public String toString(){
    return queue.toString();
  }
}
