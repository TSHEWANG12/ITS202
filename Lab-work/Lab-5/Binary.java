public class Binary
{
    public static void binarysearch(int arr[], int first, int last, int key)
    {
		int mid =(first + last)/2;
		while(first <= last){
            if(arr[mid] < key)
            {
				first = mid+1;
			}
			else if (arr[mid] == key){
				System.out.println("Element is found at index: " + mid);
				break;
			}
			else{
				last = mid - 1;
			}
			mid =(first + last)/2;
			
		}
		if (first>last){
			System.out.println("Element is not found!");
		}
	}
    
    public static void main(String[] args) 
    {
		int arr[] = {9,4,5,3,2,34,6,5,4};
		SelectionSort.Sort(arr);
        for (int i=0;i<arr.length ;i++ ) 
        {
			System.out.print(" "+arr[i]);
			
		}
		System.out.println(" ");
		int key = 5;
		int last=arr.length-1;
		binarysearch(arr,0,last,key); 
	}
}