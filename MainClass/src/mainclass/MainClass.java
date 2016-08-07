/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;
import java.util.Scanner;
class Account
{
	public static double Bal;
	public static String accName;
	Account(String name)
	{
		this.Bal=500;
		this.accName=name;
	}
	public static void deposit(double bal)
	{
		Bal+=bal;
		System.out.println(accName+" has deposited "+bal);
	}
	public static double withdraw(double bal) throws LessBalanceException
	{
		if((Bal-bal)<500)
			throw new LessBalanceException(bal);
		else
		{
		Bal-=bal;
		System.out.println(accName+" has withdrawn "+bal);
		return bal;
		}
		//return -1;
	}
}
class LessBalanceException extends Exception
{
	LessBalanceException(double bal)
	{
		super("withdraw amount "+bal+" Rs is not valid");
	}
}
public class MainClass
{
	public static void main(String[] args) throws LessBalanceException
	{
		Scanner in=new Scanner(System.in);
		Account obj=new Account("account1");
		Account obj2=new Account("account2");
		System.out.println("Enter amount to deposit:");
		obj.deposit(in.nextDouble());
		System.out.println("Enter amount to withdraw:");
		obj2.withdraw(in.nextDouble());
	}
}
