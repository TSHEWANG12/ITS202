public class Runner{
	public static void main(String[] args){
		Stack num =new Stack();
		num.push(5);
		num.push(6);
		System.out.println(num.peek());
		num.push(8);
		num.push(9);
		System.out.println("the size is"+num.size());
		System.out.println("empty" +num.isEmpty());
		//num.pop();
		//System.out.println(num.pop());
		num.show();
	}
}