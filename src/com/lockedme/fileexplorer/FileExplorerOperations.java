package com.lockedme.fileexplorer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileExplorerOperations {

	private static final String FILE_REPOSITORY = "/home/skuttiyaturecom/eclipse-workspace/LockedmeFileExplorer/src/FileRepository";

	public void printfileNames() {
		System.out.println("\nPrinting File Names in ascending order");
		List<String> fileNameList = getFilenames();
		Collections.sort(fileNameList);
		for (String fileName : fileNameList) {
			System.out.println(fileName);
		}

	}

	private List<String> getFilenames() {
		List<String> fileNameList = new ArrayList<String>();

		File[] files = new File(FILE_REPOSITORY).listFiles();

		for (File file : files) {
			if (file.isFile()) {
				fileNameList.add(file.getName());
			}
		}
		return fileNameList;
	}

	public void createNewFile(String fileName) {
		File file = getFileFromFilename(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("\nFile " + fileName + ".txt" + " created successfully");
			} catch (IOException e) {
				System.out.println("\nError Creating File.");
			}
		} else {
			System.out.println("\nFile already exists.");
		}
	}

	public void deleteFile(String fileName) {
		File file = getFileFromFilename(fileName);
		try {
			boolean isFileDeleted = Files.deleteIfExists(file.toPath());
			if (isFileDeleted) {
				System.out.println("\nFile " + fileName + ".txt" + " deleted successfully");
			} else {
				System.out.println("\nFile " + fileName + ".txt" + "doesnt exist");
			}
		} catch (IOException e) {
			System.out.println("Error deleting File.");
		}
	}

	public void searchFile(String fileName) {
		if (isFileExistInFolder(fileName)) {
			System.out.println("\nFile " + fileName + ".txt" + " found");
		} else {
			System.out.println("\nFile " + fileName + ".txt" + " doesnt exist");
		}

	}

	private boolean isFileExistInFolder(String fileName) {
		List<String> filenames = getFilenames();
		return filenames.contains(fileName);
	}

	private File getFileFromFilename(String fileName) {
		return new File(FILE_REPOSITORY + "/" + fileName + ".txt");
	}
}
