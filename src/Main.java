public class Main
{
  public static void main(String[] args){
    Counter counter = new Counter(1,200);

    CounterIncrementer i1 = new CounterIncrementer(counter, 200);
    CounterIncrementer i2 = new CounterIncrementer(counter, 200);
    CounterDecrementer d1 = new CounterDecrementer(counter, 200);
    CounterDecrementer d2 = new CounterDecrementer(counter, 200);

    Thread t1 = new Thread(i1);
    Thread t2 = new Thread(i2);
    Thread t3 = new Thread(d1);
    Thread t4 = new Thread(d2);
    Thread t5 = new Thread();

    /*new Thread(() -> {
      System.out.println("Thread started");
    }).start(); */

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();

    System.out.println("Thread Ended");
  }
}
