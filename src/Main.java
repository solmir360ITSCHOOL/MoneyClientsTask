public class Main {
    public static void main(String[] args) {
        Bank b = new Bank(100);
        Client ca = new Client(b, 100);
        Client cb = new Client(b, 200);
        ca.start();
        cb.start();
    }
}