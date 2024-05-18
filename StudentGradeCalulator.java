import java.util.Scanner;
public class StudentGradeCalulator {
    public static void main(String args[]){
        System.out.println("\n \n_______******* STUDENT GRADE CALCULATOR *******_______");
        GradeCal gc = new GradeCal();
        total tc = new total();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Tamil   : ");
        int tam = sc.nextInt();
        System.out.print("English : ");
        int eng = sc.nextInt();
        System.out.print("Maths   : ");
        int mat = sc.nextInt();
        System.out.print("Science : ");
        int sci = sc.nextInt();
        System.out.print("Social  : ");
        int soc = sc.nextInt();
        int s = tc.sum(tam,eng,mat,sci,soc);
        System.out.println("\nTotal          : "+ s+"/500");
        int avg = s/5;
        System.out.println("\nAverage_Score  : "+ avg+"%");
        gc.calc(s);
        System.out.println("\n");


    }
    
}
class total{
    int sum(int a,int b,int c,int d,int e){
        int add = a+b+c+d+e;
        return add;
    }
}
class GradeCal{
    void calc(int n){
        if((n <= 500 ) &&(n >= 450)){
             System.out.println("\nGRADE       : O grade");
        }
        else if((n <450 ) && (n >= 400)){
            System.out.println("\nGRADE        : A+ grade");
        }
        else if((n < 400 ) && (n >= 350)){
             System.out.println("\nGRADE       :A grade");

        }
        else if((n < 350 ) && (n >= 300)){
             System.out.println("\nGRADE       : B grade");
        }
        else if((n < 300 ) && (n >= 250)){
         System.out.println("\nGRADE           : C grade");
        }
        else{
             System.out.println("\n Fail");
        }
        System.out.println("__________________________________________________________");
    }
}
