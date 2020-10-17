import java.util.Scanner;
public class BubbleSort {
	public static void main(String[] args) {
		BubbleSort obj = new BubbleSort();
		Scanner obj1 = new Scanner(System.in);
		System.out.print("Enter the size of the array  : ");
		int length = obj1.nextInt();
		int Arr[] = new int[length];
		for(int i = 0; i < length; i++) {
			System.out.print("Enter the elements of the array : ");
			int element = obj1.nextInt();
			Arr[i] = element;
		}
		for(int j : Arr) {
			System.out.print(j + " ");
		}
		System.out.println();
		obj.Sort(Arr);
		obj.printSort(Arr);
	}
	public void Sort(int []Arr) {
		int n = Arr.length;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n; j++) {
				if(Arr[j] < Arr[j - 1]) {
					int temp = Arr[j];
					Arr[j] = Arr[j -1];
					Arr[j - 1] = temp;
				}
			}
		}
	}
	public void printSort(int [] Arr) {
		int n = Arr.length;
		for(int i : Arr) {
			System.out.print(i + " ");
		}
	}
}