public class ConstantIt implements SeqIt{
  private int val, index;

  ConstantIt(Constant s){
    this.index = s.num;
    this.val = s.value;
    }

  public boolean hasNext(){
    if(index != 0)
      return true;
    else
      return false;
  }

  public int next(){
    if(index != 0)
      index--;
    else{
      System.err.println("ConstantIt called past end");
      System.exit(1);
    }
    return val;
  }
}

