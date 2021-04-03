import java.util.Arrays;

public class arrAggregation {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr1={5,4,3,2,1};
        int[] result = new int[arr.length + arr1.length];

        int index = 0;
        for(int value:arr){
            result[index++] = value;
        }
        for(int value:arr1){
            result[index++] = value;
        }
        System.out.println("in mangr mowi"+ (Arrays.toString(result)) );
    }
}
