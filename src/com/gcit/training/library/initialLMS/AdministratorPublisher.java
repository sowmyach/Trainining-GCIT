package com.gcit.training.library.initialLMS;


import java.util.Scanner;


public class AdministratorPublisher {

	public void adminPublisher() {	
		System.out.println("Enter options to make changes to publisher");
		System.out.println("1.Add Details of Publisher");
		System.out.println("2.Update Details of Publisher");
		System.out.println("3.Delete Details of a Publisher");
		 Scanner obj=new Scanner(System.in);
			int input=obj.nextInt();
		while(input!=1&&input!=2&&input!=3){
			System.out.println("Enter Correct Input");
			input=obj.nextInt();
			}
		if (input==1){
		  AdminPublisherAdd admPubadd=new AdminPublisherAdd();
		  admPubadd.adminPublisherAdd();
		}
		if(input==2){
			AdminPublisherUpdate admpubupdate=new AdminPublisherUpdate();
			admpubupdate.adminPublisherUpdate();
		}
		if(input==3){
			AdminPublisherDelete adminPubdel=new AdminPublisherDelete();
			adminPubdel.adminPublisherdelete();
			
			
		}
		

		
	}

}
