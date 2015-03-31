package com.gcit.training.library.initialLMS;


import java.util.Scanner;


public class Administrator {

	public void adminMenu() {
		System.out.println("Select Options in the below list");
		System.out.println("1.Add or Update or Delete Book & Add or Update or Delete  Author ");
		 System.out.println("2.Add or Update or Delete Publishers");
		 System.out.println("3.Add or Update or Delete LibraryBranches");
		 System.out.println("4.Add or Update or Delete Borrowers");
		 Scanner obj=new Scanner(System.in);
			int input=obj.nextInt();
			while(input!=1&&input!=2&&input!=3&&input!=4){
				System.out.println("Enter Correct Input");

		input=obj.nextInt();
			}
			if(input==1){
				AdminstratorBookAuthor adBookAuthor=new AdminstratorBookAuthor();
				adBookAuthor.adminBookAuthor();
			}		
		if(input==2){
			AdministratorPublisher adminPub=new AdministratorPublisher();
			adminPub.adminPublisher();						
		}
		if(input==3){
			AdministratorLibraryBranches adminLibBranch=new AdministratorLibraryBranches();
			adminLibBranch.adminLibraryBranches();	
			
			
			
		}
		if(input==4){
			AdministratorBorrower adminborro=new AdministratorBorrower();
			adminborro.adminBorrower();
			
		
	
}
	}}

