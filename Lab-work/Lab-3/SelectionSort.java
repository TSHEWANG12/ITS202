import java.util.Scanner;
public class SelectionSort {
	public static void main(String[] args) {
		SelectionSort obj = new SelectionSort();
		Scanner obj1 = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int length = obj1.nextInt();
		int Array[] = new int[length];
		for(int i = 0; i < length; i++) {
			System.out.print("Enter the elements of array : ");
			int element = obj1.nextInt();
			Array[i] = element;
		}
		for(int j : Array) {
			System.out.print(j + " ");
		}
		System.out.println();
		obj.Sort(Array);
		obj.printSort(Array);
	}
	public void Sort(int []Array) {
		int n = Array.length;
		for(int i = 0; i < n - 1; i++) {
			int Value = i;
			for(int j = i + 1; j < n; j++) {
				if(Array[j] < Array[Value]) {
					Value = j;
				}
			}
			int temp = Array[Value];
			Array[Value] = Array[i];
			Array[i] = temp;
		}
	}
	public void printSort(int [] Array) {
		int n = Array.length;
		for(int i : Array) {
			System.out.print(i + " ");
		}
	}
}