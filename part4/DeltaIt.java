public class DeltaIt implements SeqIt{
  private int index, initial, delta, val;

  DeltaIt(Delta s) {
    this.index = s.num;
    this.initial = s.initial;
    this.delta = s.delta;
    }
  public boolean hasNext(){
    if(index != 0)
      return true;
    else
      return false;
  }

  public int next() throws UsingIteratorPastEndException{
    if(index == 0){
      //System.err.println("DeltaIt called past end");
      //System.exit(1);
      throw new UsingIteratorPastEndException();
    }


  index--;
  val = initial;
  initial += delta;
  return val;
  }
}

