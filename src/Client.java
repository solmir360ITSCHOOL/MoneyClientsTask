public class Client extends Thread {
    private Bank b;
    private int needMoney;

    Client(Bank b, int nm) {
        this.b = b;
        this.needMoney = nm;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (b) {
                System.out.println("Operation started");
                if (b.money > needMoney) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.exit(0);
                    }
                    b.money -= needMoney;
                    System.out.println("Operation successful");
                }
                else {
                    System.out.println("Operation failed");
                }
                if (b.money <= 0) {
                    System.out.println("No money");
                    System.exit(0);
                }
            }
        }
    }
}