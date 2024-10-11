package Cycle2;
import java.io.*;
import java.util.Scanner;
public class FileHandling 
{

	public static void main(String[] args)throws IOException 
	{
		Scanner sc=new Scanner(System.in);
		try 
		{
			FileOutputStream fout=new FileOutputStream("sample.txt");
			String str;
			char ch;
			System.out.println("Enter text");
			str=sc.nextLine();
			int i;
			for(i=0;i<str.length();i++) 
			{
				ch=str.charAt(i);
				fout.write(ch);
			}
			fout.close();
			System.out.println("Written on the file successfully...!");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch(IOException e)
		{
			System.out.println("An error occured");
		}
		try
		{
			FileInputStream fin=new FileInputStream("sample.txt");
			FileOutputStream fout=new FileOutputStream("test.txt");
			int i;
			while((i=fin.read())!=-1)
			{
				fout.write(i);
			}
			fin.close();
			fout.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}
		catch(IOException e)
		{
			System.out.println("An error occured");
		}
		finally
		{
			System.out.println("Written from the first file successfully");
		}
	}

}
