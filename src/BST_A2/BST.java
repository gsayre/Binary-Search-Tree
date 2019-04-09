package BST_A2;

public class BST implements BST_Interface {
	  public BST_Node root;
	  int size;
	  
	  public BST(){ 
		  size=0; 
		  root=null; 
		  }
	  
	  @Override
	  //used for testing, please leave as is
	  public BST_Node getRoot(){
		  return root; 
		  }

	  @Override
	  public boolean insert(String s) {
		  if (getRoot() == null) {
			  root = new BST_Node(s);
			  size++;
			  return true;
		  } else {
			  if(root.insertNode(s)) {
				  size++;
				  return true;
			  } else {
				  return false;
			  }
		  }
	  }

	@Override
	public boolean remove(String s) {
		if (size == 0) {
			return false;
		} else if (size == 1){
			root = null;
			size--;
			return true;
		} else {
		size--;
		return root.removeNode(s, root);
		}
	}

	@Override
	public String findMin() {
		if (getRoot() == null) {
			return null;
		} else {
		return root.findMin().getData();
		}
	}

	@Override
	public String findMax() {
		if (getRoot() == null) {
			return null;
		} else {
		return root.findMax().getData();
		}
	}

	@Override
	public boolean empty() {
		return size == 0;
	}


	@Override
	public boolean contains(String s) {
		if (size == 0) {
			return false;
		} else {
		return root.containsNode(s);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		if (size == 0) {
			return -1;
		}
		return root.getHeight();
	}

	}
