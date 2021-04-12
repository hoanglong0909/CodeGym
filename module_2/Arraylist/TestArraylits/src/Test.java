import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Double> arr = new ArrayList<Double>();
        arr.add(3.3);
        arr.add(4.2);
        arr.add(5.5);
        arr.add(3.1);
        double sum = 0 ;
        for (Double doubles : arr) {
            sum += doubles ;

        }
        System.out.println(sum);
        arr.remove(2) ;



    }
//    public static void main(String[] args) {
//        int[] arr = {2,3,1,4,14,5,2} ;
//        for(int i = 0 ; i< arr.length ;i++ ){
//            for(int j = i + 1; j <arr.length ; j++){
//                if(arr[i] > arr[j]){
//                    int temp = arr[i] ;
//                    arr[i] = arr[j] ;
//                    arr[j] = temp ;
//                }
//            }
//        } System.out.println(Arrays.toString(arr));
//    }

}
