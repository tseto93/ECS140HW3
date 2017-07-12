public class JumbleIt implements SeqIt{
  private Jumble s;
  private int index, val;

  JumbleIt(Jumble s){
    this.s = s;
    int index = 0;
  }

  public boolean hasNext(){
    if(index != 0)
      return true;
    else
      return false;
  }

  public int next(){
    if(index >= s.values.length){
      System.err.println("JumbleIt called past end");
      System.exit(1);
    }

    val = s.values[index];
    index++;
    return val;
    }
}

