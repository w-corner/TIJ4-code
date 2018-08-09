package concurrency;

public class ThreadX extends Thread {


    private String name;

    public ThreadX(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                int rand = (int) (Math.random() * 100);
                sleep(rand);
                System.out.println(name + "运行 " + rand + " :  " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ThreadX t1 = new ThreadX("A");
        ThreadX t2 = new ThreadX("B");
        t1.start();
        t2.start();
    }
}
