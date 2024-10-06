package thread.bounded;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV3 implements BoundedQueue {

  private final Queue<String> queue = new ArrayDeque<>();
  private final int max;

  public BoundedQueueV3(int max) {
    this.max = max;
  }

  @Override
  public synchronized void put(String data) {
    while (queue.size() == max) {
      log("[put] 큐가 가득참, 대기 ");
      try {
        this.wait();
        log("[put] 생산자 깨어남");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    queue.offer(data);
    log("[put] 생산자 데이터 저장, notify() 호출");
    this.notify();
  }

  @Override
  public synchronized String take() {
    while (queue.isEmpty()) {
      log("[take] 큐에 데이터 없음, 대기 ");
      try {
        wait();
        log("[take] 소비자 깨어남");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    String data = queue.poll();
    log("[take] 소비자 데이터 획득, notify() 호출");
    notify(); // 대기 스레드, WAIT -> BLOCKED

    return data;
  }



  @Override
  public String toString() {
    return queue.toString();
  }
}
