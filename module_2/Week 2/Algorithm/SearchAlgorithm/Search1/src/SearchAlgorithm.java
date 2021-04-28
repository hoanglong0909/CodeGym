public class SearchAlgorithm {
    public static void main(String[] args) {
//        int[] arr = new int[10] ;
//        for(int i = 0 ;i<arr.length ; i++){
//            arr[i] = (int) Math.round(Math.random()*100);
//        }
        int[] arr = {8,9,3,2,5,6,5,7};
        SearchAlgorithm algorithm = new SearchAlgorithm();
        algorithm.display(arr);
        System.out.println("\n***********************");
        System.out.println(algorithm.SearchLastindex(arr,5));
        algorithm.display(arr);
        System.out.println("\n***********************");
        System.out.println("Số lần xuất hiện" + algorithm.countValue(arr,5));
        algorithm.display(arr);
        System.out.println("\n***********************");
        algorithm.Selection(arr);
        System.out.println("giá trị nhỏ thứ 2: ");

    }


    public void BubbleSort(int[] arr){
        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = 0; j < arr.length - 1 - i ; j++) {
                if(arr[j] > arr[j +1 ]){
                    int temp = arr[j];
                    arr[j] = arr[j +1];
                    arr[j+ 1] = temp ;
                }
            }
        }
    }
    public void Selection(int arr[]){
        for (int i = 0; i < arr.length - 1 ; i++) {
            int mindex = i ;
            for (int j = i+ 1; j < arr.length ; j++) {
                if(arr[j] < arr[mindex]){
                    mindex = j ;
                }
            }
            if(mindex != i){
                int temp = arr[i];
                arr[i] = arr[mindex];
                arr[mindex] = temp;
            }
        }
    }



    public void insert(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            int key = arr[i];
            int j = i -1 ;
            while (j >= 0 && arr[j] >key){
                arr[j+1]  = arr[i];
                j = i -1;
            }
            arr[j+1] = key;
        }
    }
    public int linearSearch(int[] arr, int value)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }
    public int countValue(int[] arr, int value){
        int count = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(value == arr[i]){
                count++ ;
            }
        }return count;

    }


    public int SearchLastindex(int[] arr, int value){
        int holderindex = -1 ;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == value)
                holderindex = i;
        }return holderindex;
    }






    public int binarySearch(int[] arr, int value){
        int low =0 ;
        int high = arr.length -1 ;
        int mid =  (high + low)/ 2;
        while(high >= low){
            if (value < arr[mid]){
                high = mid -1;
            }else if(value >arr[mid]){
                low = mid +1 ;
            }else {
              return mid ;
            }
        }return -1 ;
    }




//    public int binary(int[] arr, int low, int high,int value) {
//        if (low > high) {
//            return -1;
//        }
//        if (high >= low) {
//            int mid = low + (low + high) / 2;
//            if (value == arr[mid]) {
//                return mid;
//            }
//            if (value < arr[mid]) {
//                return binary(arr, low, mid - 1, value);
//
//                return binary(arr, mid + 1, mid - 1, value);
//        }
//    }


    public int binarySearchRecursive(int[] arr,int low,int high, int value){
        if(high >= low){
            int mid = low+ (low - high ) /2 ;
            if(value < arr[mid]){
                return binarySearchRecursive(arr,low,mid-1,value);
            }else
                if(value> arr[mid]){
                return binarySearchRecursive(arr,mid+1,high,value);
                } else {
                    return mid;
                }
        }
        return -1;
    }
    public int binarySearchRecursive(int[] arr, int value){
       return binarySearchRecursive(arr,0,arr.length-1,value);
    }
    public void display(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
