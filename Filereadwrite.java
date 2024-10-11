package Cycle2;
import java.io.*;
import java.io.IOException;
import java.util.*;
public class Filereadwrite 
{

	public static void main(String[] args) 
	{
		String inputFilePath="sample.txt";
		String outputFilePath="test.txt";
		try(Scanner sc=new Scanner(new FileReader(inputFilePath));
		FileWriter writer=new FileWriter(outputFilePath))
		{
			int charCount=0;
			int wordCount=0;
			int lineCount=0;
			while(sc.hasNextLine())
			{
				String line=sc.nextLine();
				charCount+=line.length();
				String[] words=line.split("\\s+");
				wordCount+=words.length;
				lineCount++;
			}
			String output="Character count: "+charCount+ "\nWord count:"+wordCount+ "\nLine count:"+lineCount;
			writer.write(output);
			System.out.println("File handling completed.Output written to "+outputFilePath);
		}
		catch(IOException e)
		{
			System.out.println("An error occured");
		}
				
	}

}
