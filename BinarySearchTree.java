 package ds;

public class BinarySearchTree {
	public TreeNode root;
	
	public BinarySearchTree () {
		root = null;
	}
	
	public void inorder_tree_walk (TreeNode x) {
		if(x != null){
			inorder_tree_walk(x.left);
			 System.out.print(x.key + " ,");
			inorder_tree_walk(x.right);
		}
	}
	public void Preorder_tree_walk(TreeNode node){
   	 
   	 if(node == null){
   		 return;
   	 }
   	  Preorder_tree_walk(node.right);
   	   Preorder_tree_walk(node.left);
   	  System.out.print(node.key);
    }
	public void Postorder_tree_walk(TreeNode node){
   	 if(node == null){
   		 return;
   	 }
   	   Postorder_tree_walk(node.left);
   	   Postorder_tree_walk(node.right);
   	  System.out.print(node.key);
    }
	
	public TreeNode search (TreeNode x, int k) {
		if(x == null || k == x.key){
			return x;
		}
		if(k < x.key){
			return search(x.left,k);
		}
		else {
			return search(x.right,k);
		}
	}
	
	public TreeNode iterative_search (int k) {
		TreeNode t = new TreeNode(k); 
		  while(t != null && k != t.key){
			  if(k<t.key){
				  t = t.left;
			  }
			  else{
				  t = t.right;
			  }
		  }
		  return t;
	}
	
	public TreeNode minimum () {
		TreeNode t = new TreeNode();
		t = root;
		while(t.left != null){
			t = t.left;
		}
		return t;
	}
	
	public TreeNode maximum () {
		TreeNode t = new TreeNode();
		t = root;
		while(t.right != null){
			t = t.right;
		}
		return t;
	}
	
	public TreeNode successor (TreeNode x) {
		if(root.right != null){
			return   minimum();
		}
		 TreeNode y = root.p;
		while(y != null && x == y.right){
			root = y;
			y = root.p;
		}
		return y;
	}
	
	public void insert (int k) {
		TreeNode y = null;
		TreeNode x = root;
		TreeNode z = new TreeNode(k);
		while(x != null){
			y = x;
			System.out.print(x);
			if(z.key < x.key){
				x = x.left;
			}
			else{
				x = x.right;
			}
		}
		z.p = y;
	    if(y== null){
			 root = z;
			}
		else if(z.key < y.key){
				y.left = z;
			}
		else{
				y.right = z;
			}
	     
	     
	}
	
	 

	 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
		BinarySearchTree bst;
		TreeNode n;
		
		bst = new BinarySearchTree();
		for (int i = 0; i < array.length; i++)
			bst.insert(array[i]);
		
		System.out.println("Inorder_tree_walk starts ------------------");
		bst.inorder_tree_walk(bst.root);
		System.out.println("Inorder_tree_walk ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("Search starts ------------------");
		n = bst.search(bst.root, 13);
		System.out.print(n);
		System.out.println("found: " + n.key);
		System.out.println("Search ends ------------------");
		System.out.print("\n\n");

		System.out.println("Iterative search starts ------------------");
		n = bst.iterative_search(4);
		System.out.println("found: " + n.key);
		System.out.println("Iterative search ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("Minimum starts ------------------");
		n = bst.minimum();
		System.out.println("Minimum key is " + n.key);
		System.out.println("Minimum ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("Maximum starts ------------------");
		n = bst.maximum();
		System.out.println("Maximum key is " + n.key);
		System.out.println("Maximum ends ------------------");
		System.out.print("\n\n");

		System.out.println("Successor starts ------------------");
		n = bst.successor(bst.root.left.right.right);
		System.out.println("Successor key is " + n.key);
		System.out.println("Successor ends ------------------");
		System.out.print("\n\n");
	}

}

