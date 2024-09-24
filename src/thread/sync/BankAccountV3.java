package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV3 implements BankAccount {

    private int balance;

    public BankAccountV3(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래시작 " + getClass().getSimpleName());
        // 잔고가 출금액보다 적으면, 진행불가

        synchronized (this) {
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
        }
        log("거래종료 ");
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
