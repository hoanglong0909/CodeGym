import java.util.Scanner;
public class More_Array {
    public static void main(String[] args) {
        int[][] arr = new int[0][];
        int size;
        int size1;
        Scanner scanner= new Scanner(System.in);
        System.out.println("mời nhập size");
        size = scanner.nextInt();
        System.out.println("mời nhâp size 2");
        size1 = scanner.nextInt();
        int[][] arr1 = new int[size][size1];
        System.out.println("mảng hai chiều ");
        for (int i = 0 ; i< arr.length;i++){
            for(int j = 0 ; j<arr.length;j++){
                arr[i][j]=(int)Math.round(Math.random()*10 + 1);
                System.out.print( "aaaaaA" + arr1[i][j] +"\t");
            }

        }
                int max = arr[0][0];
        int index= 0 ;
        for (int i = 0 ; i< arr.length;i++){
            for (int j = 0 ; j<arr.length;j++){
                if(max < arr[i][j]){
                    arr[i][j] = max ;
                   index = i ;
                   index = j ;
            }

        }
    }
        System.out.println("giá trị lớn nhất "+ max + "vị trí"+ index);


    }
}



