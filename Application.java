import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Application {
	Scanner sc = new Scanner(System.in);

	public void startApplication() {
		out: while (true) {
			System.out.println();
			System.out.println("FIS JAVA ASSIGNMENT");
			System.out.println("WORKING DIRECTORY - " + System.getProperty("user.dir"));
			System.out.println("Press 1 : View list of files");
			System.out.println("Press 2 : Perform Operations");
			System.out.println("Press 3 : Exit Application");
			byte choice = sc.nextByte();
			sc.nextLine();
			System.out.println();
			switch (choice) {
			case 1:
				listFiles();
				break;
			case 2:
				performOperations();
				break;
			case 3:
				break out;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}

	public void listFiles() {
		File folder = new File(System.getProperty("user.dir"));
		String[] files = folder.list();
		for (String file : files)
			System.out.println(file);
	}

	public void performOperations() {
		while (true) {
			System.out.println();
			System.out.println("Press 1 : Add a file");
			System.out.println("Press 2 : Delete a file");
			System.out.println("Press 3 : Search a file");
			System.out.println("Press 4 : Go to previous menu");
			byte choice = sc.nextByte();
			sc.nextLine();
			System.out.println();
			switch (choice) {
			case 1:
				addFile();
				break;
			case 2:
				deleteFile();
				break;
			case 3:
				searchFile();
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}

	public void addFile() {
		System.out.println("Enter name of file");
		String fileName = sc.nextLine();
		File file = new File(fileName);
		if (file.exists())
			System.out.println(fileName + " already exists in working directory");
		else {
			try {
				file.createNewFile();
				System.out.println("Successfully created " + fileName);
			} catch (IOException e) {
				System.out.println("File could not be created due to below exception");
				System.out.println(e);
			}
		}
	}

	public void deleteFile() {
		System.out.println("Enter name of file");
		String fileName = sc.nextLine();
		File file = new File(fileName);
		try {
			if (Files.deleteIfExists(file.toPath()))
				System.out.println("Successfully deleted " + fileName);
			else
				System.out.println(fileName + " does not exist in working directory");
		} catch (IOException e) {
			System.out.println("File could not be deleted due to below exception");
			System.out.println(e);
		}
	}

	public void searchFile() {
		System.out.println("Enter name of file");
		String fileName = sc.nextLine();
		File file = new File(fileName);
		if (file.exists())
			System.out.println(fileName + " found in working directory");
		else
			System.out.println(fileName + " not found in working directory");
	}
}