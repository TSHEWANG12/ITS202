import java.util.Scanner;
public class InsertionSort {
	public static void main(String[] args) {
		InsertionSort obj = new InsertionSort();
		Scanner obj1 = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
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
		for(int i = 1; i < n; i++) {
			int concurrent = Arr[i];
			int j = i -1;
			while(j >= 0 && Arr[j] > concurrent) {
				Arr[j + 1] = Arr[j];
				j--;
			}
			Arr[j + 1] = concurrent;
		}
	}
	public void printSort(int [] Array) {
		int n = Array.length;
		for(int i : Array) {
			System.out.print(i + " ");
		}
	}
}