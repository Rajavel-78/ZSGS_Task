package stackandqueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class CopiedFirst {

	public static void main(String[] args) {
		CopiedFirst copiedFirst = new CopiedFirst();
		copiedFirst.operation();
	}

	public void operation() {
		
		PriorityQueue<Long> fileSize = new PriorityQueue<Long>();
		File file = new File("/home/rajavel/HTmL JS/quiz");
		File[] totalFile = file.listFiles();
		ArrayList<File> listOfFile = new ArrayList<File>(Arrays.asList(totalFile));

		for (int i = 0; i < totalFile.length; i++) {
			System.out.println(totalFile[i]);
			fileSize.add((totalFile[i].length()));
			System.out.println((totalFile[i].length()));
			System.out.println(totalFile[i].getName());
		}
		for (Long j : fileSize) {
			System.out.println(j);
		}

		while (!fileSize.isEmpty()) {
			for (int i = 0; i < listOfFile.size(); i++) {
				int size = (int) listOfFile.get(i).length();
				if (fileSize.element() == size) {
					File newFilePath = createFile(listOfFile.get(i));
					System.out.println(newFilePath + "   " + listOfFile.get(i).length());
					readWriteProcess(listOfFile.get(i), newFilePath);
					listOfFile.remove(i);
				}
			}
			fileSize.remove();
		}

	}

	public File createFile(File name) {
		String fileName = name.getName();
		int length = fileName.lastIndexOf('.');
		System.out.println(fileName.substring(0, length));
		File file = new File("/home/rajavel/HTmL JS/quiz2/" + fileName.substring(0, length) + "."
				+ fileName.substring(length + 1, fileName.length()) + "");
		try {
			file.createNewFile();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(file);
		return file;
	}
	public void readWriteProcess(File oldpath, File newPath)  {
		FileReader reader=null;
		BufferedReader read=null;
		FileWriter writer=null;
		BufferedWriter write = null;
		try {
			reader = new FileReader(oldpath);
			read = new BufferedReader(reader);
			writer = new FileWriter(newPath);
			write = new BufferedWriter(writer);
			String line = read.readLine();
			while (line != null) {
				write.write(line);
				write.write("\n");
				line = read.readLine();
			}
			write.flush();

		} catch (IOException e) {
			System.out.println("-----File not found---");
		} finally {
			
		}
	}
}