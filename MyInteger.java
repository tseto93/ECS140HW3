//part 1
public class MyInteger extends Element{
    private int intVal;
    
    //constructor
    public MyInteger(){
        intVal = 0;
    }
    
    //Get()
    public int Get(){
        return intVal;
    }
    
    //Set();
    public void Set(int intVal){
        this.intVal = intVal;
    }
    
    //Print()
    public void Print(){
        System.out.print(this.intVal);
    }
}