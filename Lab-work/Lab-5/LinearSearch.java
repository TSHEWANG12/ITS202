public class LinearSearch
{
    public static void main(String[] args){
        int[] a1={1,3,4,5,6,55,7,10};
        int key=55;
        System.out.println(key+"is found at index:"+linearSearch(a1,key));
    }
    public static int linearSearch(int[] arr,int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
}