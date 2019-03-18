package fileoperator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVFile {	
	
	public void writeCSV(String values,String path) {
		
		try (PrintWriter writer = new PrintWriter(
				new FileWriter(path, true))) {
			StringBuilder sb = new StringBuilder();
			sb.append(values);
			sb.append('\n');

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void readCSV() {
		String line = "";
		String cvsSplitBy = ",";
		String csvFile = "C:/Users/Shalika Ashan/Documents/SLIIT/3rd Year/SA/test.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);

				System.out.println("Country [code= " + country[0] + " , name=" + country[1] + "]");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void removeLine() throws IOException {

		String csvFile = "C:/Users/Shalika Ashan/Documents/SLIIT/3rd Year/SA/test.csv";

		String temp = "C:/Users/Shalika Ashan/Documents/SLIIT/3rd Year/SA/temp.csv";

		File inputFile = new File(csvFile);
		File tempFile = new File(temp);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = "32";
		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			String trimmedLine = currentLine.trim();
			if (trimmedLine.startsWith(lineToRemove))
				continue;
			writer.write(currentLine);
			writer.newLine(); // Writes a line separator.
		}

		writer.close();
		boolean successful = tempFile.renameTo(inputFile);
		readCSV();
	}
}