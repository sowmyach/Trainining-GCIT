package com.gcit.training.library.initialLMS;
import java.util.Scanner;
public class Librarian {

	public void librarianmenu() {
		System.out.println("select the options in Lib1");
		Scanner obj=new Scanner(System.in);
		System.out.println("1) Enter branch you manage ");
		System.out.println("2) Quit to previous ");
		int input=obj.nextInt();
		while(input!=1 && input!=2){
			System.out.println("Enter the correct input");
			input=obj.nextInt();
		}
		if(input==1){
			branchmenu br = new branchmenu();
			br.brmenu();
		
		}
		if(input==2){
			Librarymanagementapp lim=new Librarymanagementapp();
			lim.manage();
		}
		
	}
}





			





