public class Main {
    public static void main(String[] args) {
        HDFCAccount ram=new HDFCAccount("Ram","25Ram",2000.0);
        System.out.println(ram); //toString method of HDFCAccount class will be called.

        //fetch the balance
        System.out.println(ram.fetchBalance("ram"));   //wrong password
        System.out.println(ram.fetchBalance("25Ram")); //correct password

        //add money
        System.out.println(ram.addMoney(100000));
        System.out.println(ram.fetchBalance("25Ram"));

        //withdraw money
        System.out.println(ram.withdrawMoney(200000,"25Ram"));//withdraw more money than available balance
        System.out.println(ram.withdrawMoney(2000,"27Ram"));//wrong password
        System.out.println(ram.withdrawMoney(2000,"25Ram"));//correct password

        //chage password
        System.out.println(ram.changePassword("25Ram","26ram"));
        System.out.println(ram.fetchBalance("26ram")); //trying new password to see balance

        //calculate interest
        System.out.println("Interset for 5 years is: "+ram.calculateInterest(5));
        System.out.println();


        //SBI:-
        SBIAccount hitesh=new SBIAccount("Hitesh","1580@hitesh",3000);
        System.out.println(hitesh);

        //fetch balance
        System.out.println(hitesh.fetchBalance("hitesh"));//wrong password
        System.out.println(hitesh.fetchBalance("1580@hitesh"));//correct password

        //add money
        System.out.println(hitesh.addMoney(1000));
        System.out.println(hitesh.fetchBalance("1580@hitesh"));

        //withdraw money
        System.out.println(hitesh.withdrawMoney(4000,"1580@hitesh"));//withdraw more money than available balance
        System.out.println(hitesh.withdrawMoney(1000,"1580@hitesh"));
        System.out.println(hitesh.withdrawMoney(1,"1580@hitesh"));
    }
}