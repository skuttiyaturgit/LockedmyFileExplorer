package com.lockedme.fileexplorer;

import java.util.Scanner;

public class FileExplorerApplication {

	public static void main(String[] args) {
		displayMenu();
	}

	private static void displayMenu() {
		FileExplorerOperations lockedmeOperations = new FileExplorerOperations();
		while (true) {
			showOptions();
			int mainMenu = getInputFromUser();
			switch (mainMenu) {
			case (1):
				lockedmeOperations.printfileNames();
				break;

			case (2):
				boolean isSubmenu = true;
				while (isSubmenu) {
					int subMenu = getSubmenuInputFromUser();
					switch (subMenu) {
					case (1):
						lockedmeOperations.createNewFile(getFileNameFromUser());
						break;
					case (2):
						lockedmeOperations.deleteFile(getFileNameFromUser());
						break;
					case (3):
						lockedmeOperations.searchFile(getFileNameFromUser());
						break;
					case (4):
						isSubmenu = false;
						break;
					default:
						break;
					}
				}
				break;
			case (3):
				System.exit(0);

			default:
				System.out.println("\nInvalid Option");

			}
		}

	}

	private static void showOptions() {
		System.out.println("\nMain Menu");
		System.out.println("===========");
		System.out.println("\n[1] List files");
		System.out.println("[2] File Operations");
		System.out.println("\t[1] Create new Files");
		System.out.println("\t[2] Delete File");
		System.out.println("\t[3] Search File");
		System.out.println("\t[4] Return to Main Menu");
		System.out.println("[3] Exit Application");
	}

	private static int getInputFromUser() {
		System.out.print("\nEnter your option : ");
		return new Scanner(System.in).nextInt();
	}

	private static int getSubmenuInputFromUser() {
		System.out.print("\nEnter your submenu Option : ");
		return new Scanner(System.in).nextInt();
	}

	private static String getFileNameFromUser() {
		System.out.print("\nEnter file name : ");
		return new Scanner(System.in).next();
	}

}
