public class Jumble extends Seq{
  protected int [] values;

  public Jumble(int [] values){
    this.values = new int[values.length];
    System.arraycopy(values, 0, this.values, 0, values.length);
    for(int i = 0; i < values.length; i++){
      this.values[i] = values[i];
  }
}

public String toString(){
  String temp = ("{ " + this.values.length + " :");
  for(int i: this.values)
    temp += " " + i;
  return temp + " }";
  }
}

