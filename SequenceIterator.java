//part 4
/*public class SequenceIterator{
	private Sequence current;
	
	public SequenceIterator(){
		current = null;
	}
	
	public void SetCur (Sequence current){
		this.current = current;
	}
	
	public SequenceIterator advance(){

		this.SetCur(current.GetNode());
	    //this.current = current.rest();

		return this; 
	}

	public Element get(){
		return current.GetElement();
	}
	
	public boolean equal(SequenceIterator num){
		return this.current == num.current;

	}
	
}*/

public class SequenceIterator extends Sequence{
    public Sequence current;
    public Sequence testNode;
    
    public SequenceIterator(Sequence node){
        //current = node;
        testNode = node;
        current = testNode;
    }
    
    public SequenceIterator advance(){
        //this.SetCur(current.GetNode());
        //return this;
        //this.current = current.rest();
        this.current = current.GetNode();
        return this;
    }
    
    public Element get(){
        return current.GetElement();
        //return (this.current).element;
    }
    
    public boolean equal(SequenceIterator num){
        //return this.current == num.current;
        if(this.current.GetElement() == num.current.GetElement())
            return true;
        return false;
    }
}

