package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountV5 implements BankAccount {

  private int balance;
  private final Lock lock = new ReentrantLock();

  public BankAccountV5(int initialBalance) {
    this.balance = initialBalance;
  }

  @Override
  public boolean withdraw(int amount) {
    log("거래시작 " + getClass().getSimpleName());
    // 잔고가 출금액보다 적으면, 진행불가

    if(lock.tryLock()){ // trylock을 이용하여 lock을 걸기
      log("진입실패, 이미 처리중인 작업이 있습니다");
      return false;
    };

    try {
      log("[검증 시작] 출금액 :" + amount + ", 잔액 : " + balance);
      if (balance < amount) {
        log("[검증 실패] 출금액 :" + amount + ", 잔액 : " + balance);
        return false;
      }

      // 잔고가 출금액보다 많으면 진행
      log("[검증 성공] 출금액 :" + amount + ", 잔액 : " + balance);
      sleep(1000);
      balance -= amount;
      log("[출금 완료] 출금액 :" + amount + ", 잔액 : " + balance);
    } finally {
      lock.unlock(); // ReentrantLock을 이용하여 unlock
    }
    log("거래종료 ");
    return true;
  }

  @Override
  public synchronized int getBalance() {
    lock.lock(); // ReentrantLock을 이용하여 lock을 걸기
    try {
      return balance;
    } finally {
      lock.unlock();
    }
  }
}

