import java.util.Scanner;

public class findvalue {
    public static void main(String[] args) {
        String[] student = {"Long","Nam","thien","quang"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name student: ");
        String input_name = scanner.nextLine();

        boolean isExist = false ;
        for(int i = 0 ; i<student.length;i++){
            if(student[i].equals(input_name)){
                System.out.println("Position of the students in the list" + input_name+"is  "+(i+1));
                isExist = true;
                break;
            }

        } if(!isExist){
            System.out.println("not fount"+input_name+"in the list");
        }

    }
}
