public class ResizeArray{
	static int array[];
	public static int [] resize(int size){
		int temp[]= new int[size];
		for(int i =0; i<array.length;i++){
			temp[i]=array[i];
		}
		temp[size-1]=8;
		array=temp;
		return array;
	}
	public static void main(String[] args){
		array=new int[5];
		array[0]=3;
		array[1]=2;
		array[2]=4;
		array[3]=5;
		array[4]=6;
		int newArray[]= resize(6);
		for(int i=0;i < newArray.length;i++){
			System.out.print(newArray[i]+" ");
		}

	}
}