package com.gcit.training.library.initialLMS;
import java.util.Scanner;


public class AdminstratorBookAuthor {

	public void adminBookAuthor() {
		System.out.println("Select Book or Author fields from below");
		System.out.println("1.Give the input for the changes to book");
		System.out.println("2.Give the input for the changes to author");
		Scanner obj=new Scanner(System.in);
		int input=obj.nextInt();
		while(input!=1&&input!=2){
			System.out.println("Enter Correct Input");
			input=obj.nextInt();
		}
		
		if(input==1){
			{
				System.out.println("||BOOK||");
		System.out.println("1.Add Book");
		System.out.println("2.Update Book");
		System.out.println("3.Delete Book");
		input=obj.nextInt();
		while(input!=1&&input!=2&&input!=3){
			System.out.println("Enter Correct Input");
			input=obj.nextInt();
		}
		if(input==1){
			AdminAddBook aabook=new AdminAddBook();
			aabook.adminAddBook();
				}
		if(input==2){
			AdminUpdateBook auBook=new AdminUpdateBook();
			auBook.adminUpdateBook();
				}
		if(input==2){
			AdminDeleteBook adBook=new AdminDeleteBook();
			adBook.adminDeleteBook();
				}
		}
		}
		if(input==2){ {
			System.out.println("||Author||");
			System.out.println("1.Add Author");
			System.out.println("2.Update Author");
			System.out.println("3.Delete Author");
			input=obj.nextInt();
			while(input!=1&&input!=2&&input!=3){
				System.out.println("Enter Correct Input");
				input=obj.nextInt();
			}
			if(input==1){
			AdminAddAuthor addAuth=new AdminAddAuthor();
			addAuth.adminAddAuthor();
			}
			if(input==2){
				AdminUpdateAuthor auAuth=new AdminUpdateAuthor();
				auAuth.adminUpdateAuthor();
					}
			if(input==2){
				AdminDeleteAuthor adAuth=new AdminDeleteAuthor();
				adAuth.adminDeleteAuthor();
					}
			
		}
		
	}
	}
}

	


