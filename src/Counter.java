public class Counter
{
  private long value;
  private long max;
  private long min;

  public Counter(long min, long max){
    this.value = 0;
    this.max = max;
    this.min = min;
  }

  public synchronized void increment(){
    if(getValue() >= max){
      try
      {
        wait();
      }
      catch(InterruptedException e){
        e.printStackTrace();
      }
      value++;
      notifyAll();
      System.out.println(value + ": " + Thread.currentThread().getName());
    }
  }

  public synchronized void decrement(){
    if(getValue() <= min){
      try
      {
        wait();
      }
      catch(InterruptedException e){
        e.printStackTrace();
      }
      value--;
      notifyAll();
      System.out.println(value + ": " + Thread.currentThread().getName());
    }
  }

  public long getValue(){
    synchronized(this)
    {
      return value;
    }
  }
}
