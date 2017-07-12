//part 1
public class Sequence extends Element{
    //public Element element;
    //public Sequence node;
    private Element element;
    private Sequence node;
    
    public Sequence(){
        element = null;
        node = null;
    }// constructor
    
    public Element GetElement(){
        return this.element;
    }//GetElement
    
    public void SetElement(Element elm){
        this.element = elm;
    }//SetElement
    
    public Sequence GetNode(){
        return this.node;
    }//GetNode
    
    public void SetNode(Sequence node2){
        this.node = node2;
    }//SetNode
    
    //Part 2
    public void Print(){
        System.out.print("[ ");
        Sequence temp = this;
        while(temp.node != null){
            temp.GetElement().Print();
            System.out.print(" ");
            temp = temp.node;
        }
        System.out.print("]");
    }//print
    
    public Element first(){
        return this.GetElement();
    }// first element of a sequence
    
    public Sequence rest(){
        return this.GetNode();
    }// rest of the elements of a Sequence
    
    public int length(){
        int num = 0;
        Sequence temp = this;
        if(this.element == null){
            return 0;
        }
        while(temp.node != null){
            num++;
            temp = temp.node;
        }
        return num;
    }// length of the sequence
    
    
    /*public void add(Element elm, int pos){
        Sequence current = this;
        if(pos > length() || pos < 0){
            System.err.println("out of bounds");
            System.exit(1);
        }
        for(int i = 0; i < pos; i++){
            current = current.node;
        }
            
        Sequence new_node = new Sequence();
        new_node.element = current.element;
        new_node.node = current.node;
        current.element = elm;
        current.node = new_node;
        
    }//Add*/
    
    public void add(Element elm, int pos){//change, don't think I need the if statements
        Sequence current = this;
        Sequence new_node = new Sequence();

        if (pos > length() || pos < 0){ // bound checking
			System.err.println("out of bound"); 
			System.exit(1);
		}
		
	    if(pos == length() || pos > length())
	    { 
			for(int i = 0; i < pos; i++){
            current = current.node;
            }
        new_node.element = current.element;
        new_node.node = current.node;
        current.element = elm;
        current.node = new_node;
		}
		
		else
		{
			for(int i = 0; i < pos; i++){
            current = current.node;
            }
        new_node.element = current.element;
        new_node.node = current.node;
        current.element = elm;
        current.node = new_node;
		}
    }//Add
    
    public void delete(int pos){
        if(pos == 0){
            Sequence curr_node = this;
            Sequence temp_node = curr_node.node;
            curr_node.node = curr_node.node.node;
            curr_node.element = temp_node.element;
        }
        else{
            Sequence curr_node = this;
            for(int i = 1; i < pos; i++){
                curr_node = curr_node.node;
            }
            curr_node.node = curr_node.node.node;
        }
    }//delete
    
    //Part 3
    public Element index(int pos){
        if(pos >=this.length() || pos < 0){
            System.err.println("out of bounds");
            System.exit(1);
        }
        Sequence curr_node = this;
        for(int i = 0; i < pos; i++){
            curr_node = curr_node.node;
        }
        return curr_node.element;
    }
    
    /*public Sequence flatten(){
        Sequence new_seq = new Sequence();
        Sequence curr_node = this;
        int count = 0;
        while(curr_node != null){
            if(curr_node.element instanceof Sequence){
                Sequence temp_node = ((Sequence)curr_node.element).flatten();
                while(temp_node != null){
                    new_seq.add(temp_node.element, count);
                    temp_node = temp_node.node;
                    count++;
                }
            }
            else if(curr_node.element instanceof MyChar || curr_node.element instanceof MyInteger){
                new_seq.add(curr_node.element, count);
                count++;
            }
         
            curr_node = curr_node.node;
        }
        return new_seq;
    }*/
    
    /*public Sequence copy(){
		
		Sequence new_seq = new Sequence();
		Sequence curr_node = this;
		int count = 0; //serve as pos
		while(curr_node != null){
			// making newE is to make the code look better, 
			// so no need to have add() calling statements in 3 below cases  
			Element newE = null; 
			if (curr_node.element instanceof Sequence){
				newE = ((Sequence)curr_node.element).copy();
			}else if(curr_node.element instanceof MyChar){
				MyChar myChar = new MyChar(); 
				myChar.Set(((MyChar)curr_node.element).Get());
				newE = myChar;
			}else if(curr_node.element instanceof MyInteger){
				MyInteger myInteger = new MyInteger();
				myInteger.Set(((MyInteger)curr_node.element).Get());
				newE = myInteger;
			}
			new_seq.add(newE, count);
			count++;
			curr_node = curr_node.node;
		}
		return new_seq;

	}*/
	

	public Sequence flatten(){
	    Sequence new_seq = new Sequence();
	    Sequence curr_node = this;
	    while(curr_node.node != null){
	        if(curr_node.element instanceof Sequence){
	  
	            Sequence temp_node = ((Sequence)curr_node.element).flatten();
	            Sequence temp_node2 = temp_node;
                int count = 0;
	            while(count < temp_node2.length()){
	                new_seq.add(temp_node.element, new_seq.length());
	                temp_node = temp_node.node;
	                count++;
	            }
	        }
	            
	        else if(curr_node.element instanceof MyChar || curr_node.element instanceof MyInteger){
	            new_seq.add(curr_node.element, new_seq.length());
	        }
	        curr_node = curr_node.rest();
	    }
	    return new_seq;
	}

    public Sequence copy(){
	    Sequence deep_copy = new Sequence();
	    Sequence curr_node = this;
	    while(curr_node.node != null){
	        if(curr_node.element instanceof Sequence){
	            deep_copy.add(((Sequence)curr_node.element).copy(), deep_copy.length());
	        }
	        else if(curr_node.element instanceof MyChar){
	            MyChar myChar = new MyChar();
	            myChar.Set(((MyChar)curr_node.element).Get());
	            deep_copy.add(myChar, deep_copy.length());
	        }
	        else if(curr_node.element instanceof MyInteger){
	            MyInteger myInt = new MyInteger();
	            myInt.Set(((MyInteger)curr_node.element).Get());
	            deep_copy.add(myInt, deep_copy.length());
	        }
	        
	        curr_node = curr_node.node;
	    }
	    return deep_copy;
    }
    
    //Part 4
    public SequenceIterator begin(){
		SequenceIterator seq_it = new SequenceIterator(this);
		return seq_it;
	}
	
	public SequenceIterator end(){
	    SequenceIterator end = new SequenceIterator(this);
	    Sequence end_node = this;
	    while(end_node.node != null){
	        end_node = end_node.node;
	    }
	    end.current = new Sequence();
        return end;
	}

 

}//Sequence class