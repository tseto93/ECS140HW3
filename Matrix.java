public class Matrix extends Sequence{
    private int row_size;
    private int col_size;
    
    public Matrix(int row_size, int col_size){
        this.row_size = row_size;
        this.col_size = col_size;
        for(int i = 0; i < row_size * col_size; i++){
                MyInteger num = new MyInteger();
                this.add(num, i);
        }//for
    }//constructor
    
    public void Set(int row_size, int col_size, int value){
        ((MyInteger)this.index(row_size*this.col_size + col_size)).Set(value);
    }
    
    public int Get(int row_size, int col_size){
		int val = ((MyInteger)this.index(row_size*this.col_size + col_size)).Get();
		return val;
	}
	
	/*public Matrix Sum(Matrix mat){
		for (int i = 0; i < mat.row_size; i++){
			for (int j = 0; j < mat.col_size; j++){
				int sum = this.Get(i, j) + mat.Get(i, j);
				this.Set(i, j, sum);
			}//for
		}//for
		return this;
	}*/
	
	/*public Matrix Sum(Matrix mat){
	    Matrix new_mat = new Matrix(mat.row_size, mat.col_size);
	    for(int i = 0; i < mat.row_size; i++){
	        for(int j = 0; j < mat.col_size; j++){
	            int sum = this.Get(i, j) + mat.Get(i, j);
	            new_mat.Set(i, j, sum);
	        }
	    }
	    return new_mat;
	}//Sum of 2 matrices*/
	
	public Matrix Sum(Matrix mat){
	    Matrix new_mat = new Matrix(mat.row_size, mat.col_size);
	    for(int i = 0; i < mat.row_size; i++){
	        for(int j = 0; j < mat.col_size; j++){
	            int sum = this.Get(i, j) + mat.Get(i, j);
	            new_mat.Set(i, j, sum);
	        }
	    }
	    return new_mat;
	}//Sum of 2 matrices
	
	
	public Matrix Product(Matrix mat){
	    if(this.col_size != mat.row_size){
	        System.out.println("Matrix dimensions incompatible to compute product");
	        System.exit(1);
	    }
	    Matrix new_mat = new Matrix(this.row_size, mat.col_size);
	    for(int i = 0; i < this.row_size; i++){
	        for(int j = 0; j < this.col_size; j++){
	            for(int k = 0; k < new_mat.col_size; k++){
	                int product = this.Get(i, j) * mat.Get(j, k) + new_mat.Get(i, k);
	                new_mat.Set(i, k, product);
	            }
	        }
	    }
	    return new_mat;
	}
	
	public void Print(){
		for (int i = 0; i < row_size; i++){
			System.out.print("[ ");
			for (int j = 0; j < col_size; j++){
				System.out.print(Get(i, j));
				System.out.print(" ");
			}
			System.out.println("]");

		}
	}
	
	
}//Matrix class