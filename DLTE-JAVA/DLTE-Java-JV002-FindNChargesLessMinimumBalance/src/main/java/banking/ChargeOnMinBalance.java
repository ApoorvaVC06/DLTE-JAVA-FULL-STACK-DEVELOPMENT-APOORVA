package banking;

import java.util.*;

public class ChargeOnMinBalance {
    public static void main(String[] args) {
        Double[] balance= new Double[20];
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the account balance of 20 cutomers");
        for(int index=0;index<balance.length;index++){
            balance[index]=scanner.nextDouble();
        }

//object creation to access the members of Balance class
        Balance balance1 = new Balance();
        balance1.updatedBalance(balance);
    }
}
//class contains a method that updates the balance based on conditions: 3%deduction for bal:5000-9000 and 5% for bal:1000-4999
class Balance{
    public void updatedBalance(Double[] newBalance){
        for(int index=0;index<newBalance.length; index++){
            if(newBalance[index]>=5000 && newBalance[index]<=9999)
                newBalance[index] -= 0.03*newBalance[index];
            else if(newBalance[index]>=1000 && newBalance[index]<=4999)
                newBalance[index] -= 0.05*newBalance[index];
        }
        //display/print the updated Balance array in the form of Sting using toString Method in Arrays classs
        System.out.println("The updated Balance array : "+ Arrays.toString(newBalance) );
    }
}
