public class Practice1 {
    static int[] list = {1,2,3,4,5,6,7,8,9};

    static int binarySearch(int[] list, int key ){
        int low = 0 ;
        int hight = list.length -1 ;
        while (low <= hight){
            int mid = ( hight+ low )/2 ;
            if(key < list[mid]){
                hight = mid -1 ;
            }
            else if(key == list[mid]){
                return mid;
            }else {
                low = mid +1 ;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list,1));
        System.out.println(binarySearch(list,4));
        System.out.println(binarySearch(list,12));
        System.out.println(binarySearch(list,2));
        System.out.println(binarySearch(list,24));
    }
}
