package com.gcit.training.library.initialLMS;
import java.util.Scanner;


public class AdministratorBorrower {

	

	public void adminBorrower() {
		System.out.println("Enter options to make changes to Borrower");
		System.out.println("1.Add Details of Borrower");
		System.out.println("2.Update Details of Borrower");
		System.out.println("3.Delete Details of a Borrower");
		 Scanner obj=new Scanner(System.in);
			int input=obj.nextInt();
		while(input!=1&&input!=2&&input!=3){
			System.out.println("Enter Correct Input");
			input=obj.nextInt();
			}
		if (input==1){
		  AdminBorrowerAdd admborroadd=new AdminBorrowerAdd();
		  admborroadd.adminBorrowerAdd();
		}
		if(input==2){
			AdminBorrowerUpdate admborroupdate=new AdminBorrowerUpdate();
			admborroupdate.adminBorrowerUpdate();
		}
		if(input==3){
			AdminBorrowerDelete adminborrodel=new AdminBorrowerDelete();
			adminborrodel.adminBorrowerDelete();
			
			
		}
		

		
	}


		
	}

