//part 1
public class MyChar extends Element{
    private char charVal;
    
    //constructor
    public MyChar(){
        charVal = '0';
    }
    
    //Get()
    public char Get(){
        return charVal;
    }
    
    //Set()
    public void Set(char charValue){
        this.charVal = charValue;
    }
    
    //Print()
    public void Print(){
        System.out.print("'"+this.charVal+"'");
    }
}//MyChar class