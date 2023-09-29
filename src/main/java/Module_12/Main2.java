package Module_12;
import java.util.Scanner;

public class Main2 {
    private int counter = 1;

    private int value;

    public Main2(int value) {
        this.value = value;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение: ");
        int value = scanner.nextInt();

        Main2 main = new Main2(value);

        Thread fizzThread = new Thread(() -> {
            try {
                main.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread buzzThread = new Thread(() -> {
            try {
                main.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread fizzBuzzThread = new Thread(() -> {
            try {
                main.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread numberThread = new Thread(() -> {
            try {
                main.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();

        fizzThread.join();
        buzzThread.join();
        fizzBuzzThread.join();
        numberThread.join();
    }

    public synchronized void fizz() throws InterruptedException {
        while (counter <= value) {
            if (counter % 3 == 0 && counter % 5 != 0) {
                System.out.println("fizz");
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (counter <= value) {
            if (counter % 5 == 0 && counter % 3 != 0) {
                System.out.println("buzz");
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (counter <= value) {
            if ((counter % 3 == 0) && (counter % 5 == 0)) {
                System.out.println("fizzbuzz");
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (counter <= value) {
            if ((counter % 3 != 0) && (counter % 5 != 0)) {
                System.out.println(counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
