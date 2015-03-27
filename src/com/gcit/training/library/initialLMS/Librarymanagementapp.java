package com.gcit.training.library.initialLMS;
import java.util.Scanner;


public class Librarymanagementapp {
	public static void main(String[] args) {
		
		Librarymanagementapp obj = new Librarymanagementapp();
		obj.manage();
	}
	
public void manage() {
		
		System.out.println("Welcome to the GCIT Library Management System. Which category of a user are you? ");
		Scanner obj=new Scanner(System.in);
		System.out.println("1.Librarian ");
		System.out.println("2. Administrator ");
		System.out.println("3. Borrower ");
		int input=obj.nextInt();
		while( input!=1 && input!=2 && input!=3){
			System.out.println("Please enter correct input");
			input=obj.nextInt();
		}
		if(input==1){
			Librarian lib = new Librarian();
			lib.librarianmenu();	
		}
		if(input==2){
			Administrator admin=new Administrator();
			admin.adminMenu();
			
			
		}
		if(input==3){
			Borrower bowr=new Borrower();
		bowr.Borrowermenu();}	
	
	
		
	}
	}

	
	
	





