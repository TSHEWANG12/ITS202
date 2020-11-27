import java.util.*;
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BST() {

    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size()==0){
            return true;
        }
        else{
            return false;
        }
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
      return  size(root);
       
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if(x==null){
            return 0;
        }
        else{
            return 1+size(x.left)+size(x.right);
        }
       
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
     public boolean contains(Key key) {
       if(key==null){
           throw new IllegalArgumentException("Arguments to contain() with a key null");
       }
       return get(key)!=null;
     }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        return get(root,key);
        
    }

    private Value get(Node x, Key key) {
        while(x!=null){
            int cmp = key.compareTo(x.key);
            if(cmp < 0) x= x.left;
            else if(cmp > 0) x=x.right;
            else return x.val;
        }
        
        return null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        root=put(root,key,val);
    }

     private Node put(Node x, Key key, Value val) {
        if(x==null) return new Node(key,val,1);
        int cmp=key.compareTo(x.key);
        if(cmp<0)
        x.left=put(x.left,key,val);
        else if(cmp>0)
        x.right=put(x.right,key,val);
        else if(cmp==0)
        x.val=val;
        return x;
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
       return min(root).key;
    } 

    private Node min(Node x) { 
         if(x.left==null) return x;
         return min(x.left);
    } 

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if(key==null){
            throw new IllegalArgumentException("arguments to floor()is null ");
        }
        if(isEmpty()){
            throw new NoSuchElementException("arguments to floor() is empty in symbol table");
        }
        Node x = floor(root,key);
        if(x == null){
            throw new IllegalArgumentException("arguments to floor() is too small");
        }
        else{
            return x.key;
        }
    } 

    private Node floor(Node x, Key key) {
        if(x == null){
            return x;
           }
           else{
            int cmp = key.compareTo(x.key);
            if(cmp < 0){
                return floor(x.left,key);
            }
            else{
                Node floor1 = floor(x.right,key);
                if(floor1 != null){
                    return floor1;
                }
                else{
                    return x;
                }
            }
           }
       } 

    
    

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if (k < 0 || k >= size())  return null;
		Node x = select(root, k);
		return x.key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        if (x == null) return null; 
		int t = size(x.left); 
		if      (t > k) return select(x.left,  k); 
		else if (t < k) return select(x.right, k-t-1); 
		else            return x; 
         
    } 

    

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    // public Iterable<Key> keys(Key lo, Key hi) {
    //     return keys(min(), max());
    // } 

    // private void keys(Node x,Queue<Key> queue, Key lo, Key hi) { 
    //     Queue<Key> queue = new LinkedList<Key>();
	// 	keys(root, queue, lo, hi);
	// 	return queue;
    // } 
    public void deleteMin() {
		if (isEmpty()) throw new RuntimeException("Symbol table underflow");
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void deleteMax() {
		if (isEmpty()) throw new RuntimeException("Symbol table underflow");
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null) return x.left;
		x.right = deleteMax(x.right);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) {
        BST<String,Integer> obj = new BST<String,Integer>();
        obj.put("ABDUL",1);
        System.out.println(obj.get("ABDUL"));
        obj.put("HRITHIK",2);
        assert(obj.contains("HRITHIK") == true);
        assert(obj.contains("HAHA") == false);
        
        obj.put("SAI",3);
        obj.put("SAMAL",6);
        System.out.println(obj.get("SAI"));  
        obj.put("TASHI",4);
        System.out.println(obj.size());
        assert(obj.size() == 5);
        System.out.println(obj.min());
        System.out.println(obj.floor("HRITHIK"));
        System.out.println(obj.floor("HAHA"));
        assert(obj.isEmpty() == false);
        
        //theTree.select();
        obj.put("CHIMI",5);
        obj.put("SAMAL",4);
        obj.deleteMin();
        System.out.println(obj.get("SAMAL"));
        obj.put("NIMA",7);
        System.out.println(obj.size());
        System.out.println(obj.get("CHIMI"));
        System.out.println(obj.floor("CHIMI"));
        obj.put("SONAM",8);
        assert(obj.size() == 8);
        assert(obj.min() == "ABDUL");
        System.out.println("All are Tested Correct");

        
        
    }     
}