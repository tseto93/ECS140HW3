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

public int min(){
  int min = 0;
  if (values.length == 0)
return 0;
  else if (values.length > 0){
for (int i = 0; i < values.length; i++){
  if (i == 0)
      min = values[i];
  else if (values[i] < min)
      min = values[i];
      }
  }
  return min;
  }
}

