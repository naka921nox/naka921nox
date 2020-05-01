package jp.flyweight;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("ARGS ERORR");
            System.exit(0);
        }
        BigString bs = new BigString(args[0]);
        bs.print();
    }
}