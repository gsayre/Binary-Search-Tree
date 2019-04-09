package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  
  BST_Node(String data){
	  this.data=data; 
	  }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ 
	  return data; 
	  }
  public BST_Node getLeft(){ 
	  return left; 
	  }
  public BST_Node getRight(){ 
	  return right; 
	  }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

 
  public boolean containsNode(String s){
	  if (s.compareTo(this.getData()) > 0) {
		  if (this.right == null) {
			  return false;
		  } else {
			  return right.containsNode(s); 
		  }
	  }
	  if (s.compareTo(this.getData()) < 0) {
		  if (this.left == null) {
			  return false;
		  } else {
			  return left.containsNode(s);
		  }
	  }
	  return true; 
  }
  
  public boolean insertNode(String s){
	  if (this.getData().compareTo(s) == 0) {
		  return false;
	  } else if (this.getData().compareTo(s) > 0) {
		  if (this.left == null) {
			  this.left = new BST_Node(s);
			  return true;
		  } else {
			  return this.left.insertNode(s);
		  }
		  
	  } else {
		  if (this.right == null) {
			  this.right = new BST_Node(s);
			  return true;
		} else {
			return this.right.insertNode(s);
		}
	  }
  }
  
  public boolean removeNode(String s,BST_Node node){
	  int comp = this.getData().compareTo(s);

	  if (comp == 0) {
		  if (this.left == null && this.right == null) {
			  if (node.right == this ) {
				  node.right = null;
				  return true;
			  }
			  if (node.left == this) {
				  node.left = null;
				  return true;
			  }
		  }
		  
		  if (this.left == null && this.right != null) {
			  if (node.right == this ) {
				  node.right = this.right;
				  return true;
			  }
			  if (node.left == this) {
				  node.left = this.right;
				  return true;
			  }
		  }
		  
		  if (this.left != null && this.right == null) {
			  if (node.right == this ) {
				  node.right = this.left;
				  return true;
			  }
			  if (node.left == this) {
				  node.left = this.left;
				  return true;
			  }
		  }
		  
		  if (this.left != null && this.right != null) {
			  BST_Node rightmin = this.right.findMin();
			  BST_Node rightmax = this.right.findMax();
			  boolean leftside;
			  
			 while (true) {
				 if (node.getData().compareTo(rightmin.getData()) < 0) {
					 if (node.right.getData().compareTo(rightmin.getData()) == 0) {
						 leftside = false;
						 break;
					 } else {
						 node = node.right;
					 }
				 }
				if (node.getData().compareTo(rightmin.getData()) > 0) {
					if (node.left.getData().compareTo(rightmin.getData()) == 0) {
						leftside = true;
						break;
					} else {
						node = node.left;
					}
				}
			 }
			 
			 this.data = rightmin.getData();
			 
			 if (leftside) {
				 if (rightmin.right != null) {
					 node.left = rightmin.right;
					 return true;
				 } else {
					 node.left = null;
				 }
			 } else {
				 node.right = rightmin.right;
				 return true;
			 }
			 if (rightmin.left != null) {
				 node.left = null;
				 return true;
			 } else {
				 return true;

			 }
		  }


		  
	  } else if (comp < 0) {
		  if (right == null) {
			  return false;
		  }
		  System.out.println(node);
		  return right.removeNode(s, this);
	  } else {
		  if (left == null) {
			  return false;
		  }
		  return left.removeNode(s, this);
	  }
	return false;
  }
  
  public BST_Node findMin(){
	  if (this.left == null) {
		  return this;
	  } else {
		  return this.left.findMin();
	  }
  }
  
  public BST_Node findMax(){
	  if (this.right == null) {
		  return this;
	  } else {
		  return this.right.findMax();
	  }
  }

  public int getHeight(){
	  if (this.left == null && this.right == null) {
		return 0;
	  } else if (this.left == null && this.right != null) {
		 return right.getHeight() + 1;
	  } else if (this.left != null && this.right == null) {
		 return left.getHeight() + 1; 
	  }else {
		  return Math.max(right.getHeight(), left.getHeight()) + 1;
		 } 
	  }


  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}
