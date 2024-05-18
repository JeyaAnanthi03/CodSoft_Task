
import java.sql.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class sample {
    public static void main(String args[]){
        update u = new update();
        Scanner sc = new Scanner(System.in);
        System.out.print("______________________________WELCOME______________________________");
        System.out.print("\nAcount Number :");
        int ac = sc.nextInt();
        System.out.print("\nPassword      :");
        int ps = sc.nextInt();
        System.out.print("\n___________________________________________________________________");
         final String DB_URL ="jdbc:mysql://localhost:3306/atm";

        final String USER= "root";

        final String PASS ="Ananthi";
     try{
       Connection conn =DriverManager.getConnection(DB_URL, USER, PASS);
    
       Statement stmt = conn.createStatement();
    
        ResultSet rs = stmt.executeQuery("select * from details");
        String name=null;
        int nbalance = 0;
        int k =0;
    
       while (rs.next()) {
        
        if(rs.getInt(2)== ac){
            if(rs.getInt(3)==ps){
               nbalance = rs.getInt(4);
               name = rs.getString(1);
                k++;
                break;
            }
        }
    }
    if(k==0){
        System.out.println("Incorrect userId or password");
    }
       if(nbalance != 0){
          System.out.print("\n1.Withdraw\n2.Deposite\n3.Balance\n4.Exit\n\nEnter your choice:");
                    int ch = sc.nextInt();
                    System.out.print("\n___________________________________________________________________");
                    switch(ch){
                        case 1:{
                           System.out.print("\n\nAmount to be Withdraw:");
                           int n = sc.nextInt();
                           int newBalance = nbalance -n;
                           u.updateBalance  (newBalance,ac);
                           System.out.println("\n\nTAKE YOUR AMOUNT....");
                           System.out.print("\n___________________________________________________________________");
                           u.check(newBalance);
                           System.out.println("\n\n\n************RECEIPT************");
                           u.Receipt(name, ac, n,0, "WITHDRAWED AMOUNT","DEPOSITED AMOUNT",newBalance);
                           break;
                        }
                           case 2:{
                           System.out.print("\nAmount to be Deposit:");
                            int n = sc.nextInt();
                          int  newBalance = nbalance +n;
                          u.updateBalance(newBalance,ac);
                           System.out.println("\nDEPOSITED SUCCESSFULLY....");
                           System.out.print("\n___________________________________________________________________");
                           u.check(newBalance);
                           System.out.println("\n\n\n************RECEIPT************");
                           u.Receipt(name, ac, 0,n, "WITHDRAWED AMOUNT","DEPOSITED AMOUNT",newBalance);
                           break;
                        }
                           case 3:{
                           System.out.println("Balance = "+nbalance);
                           System.out.println("\n\t\t\tTAKE YOUR CARD...");

                           System.out.println("\n\n____________________________THANK YOU___________________________");
                           
                           System.out.println("\n\n\n************RECEIPT************");
                           u.Receipt(name, ac, 0,0, "WITHDRAWED AMOUNT","DEPOSITED AMOUNT",nbalance);
                           break;
                           }
                           default:{
                               System.out.println("Invalid Input");
                               System.out.println("\n\n____________________________THANK YOU___________________________");
                           }
                        
    }
}
        conn.close();
    }
    
        catch(SQLException e){
    
    e.printStackTrace();
    
        }
    }
}
class update{
    void updateBalance(int a,int b){
        final String DB_URL ="jdbc:mysql://localhost:3306/atm";

        final String USER= "root";

        final String PASS ="Ananthi";
     try{
       Connection connection =DriverManager.getConnection(DB_URL, USER, PASS);
    
        String q = "UPDATE details SET balance=?  WHERE userId = ?;";
        PreparedStatement p = connection.prepareStatement(q);
        p.setInt(1, a);
        p.setInt(2,b);
        p.executeUpdate();
    }
    catch(SQLException e){
        e.printStackTrace();
    }
}
void check(int n){
    Scanner s = new Scanner(System.in);
    System.out.print("\nAre you Like to check Your Balance?\n1.Yes\n2.No\n\nEnter your choice:");
                          int  a= s.nextInt();
                          System.out.print("\n___________________________________________________________________");
                           if(a==1){
                            System.out.println("\n\nBALANCE  ="+n);
                            System.out.println("\n\t\t\tTAKE YOUR CARD...");
                            System.out.println("____________________________THANK YOU___________________________");
                           }
                           else{
                            System.out.println("\n\t\t\tTAKE YOUR CARD...");
                            System.out.println("____________________________THANK YOU___________________________");
                           }
}
void Receipt(String a,int b,int amt1,int amt2,String action1,String action2,int bal){
    SimpleDateFormat st = new SimpleDateFormat("dd-MM-yyyy");
    System.out.println("NAME       :"+a);
    System.out.println("ACC. NO.   :"+b);
    System.out.println(action1   +":"+ amt1);
    System.out.println(action2   +":"+ amt2);
    System.out.println("BALANCE    :"+bal);
    System.out.println("DATE       :"+ st.format(new Date()));
    System.out.println("\n**********************************");

}
}
