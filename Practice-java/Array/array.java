public class array{
    static int[] array1;
    public static int[] resize(int length){
        int[] a=new int[length];
        for(int i=0; i<array1.length;i++){
            a[i]=array1[i];
        }
        a[length-1]=4;
        array1=a;
        return array1;
    }
    public static void main(String[] args){
        array1=new int[3];
        array1[0]=1;
        array1[1]=2;
        array1[2]=3;
        int[] array2=resize(4);
        for(int i=0; i<array2.length;i++){
            System.out.println(array2[i]);
        }

    }
}