import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * @author Christian Hansen
 * @author Brock Irvine
 * @author Tim Dusek
 * @author Ben Delzer
 * @author Moses Ilunga
 */

public class words
{
    public static void main(String [] args) throws FileNotFoundException
    {
	ArrayList<String> passwords = new ArrayList<String>();
	File inFile = new File("Passwords.txt");
	Scanner inputPass = new Scanner(inFile);
	String line  ="";
	while (inputPass.hasNext())
	    {
		line = inputPass.nextLine();
		
	    }
	inputPass.close();
	for (int i = 0; i<passwords.size();i++)
	    {
		StringBuilder sPass = new StringBuilder(passwords.get(i));
		char[] char_pass;
		if (sPass.toString().toUpperCase().contains("ITSTINKS"))
		    {
			System.out.println("Password on "+(i+1)+" contains the bad phrase ITSTINKS in any case combination");
			sPass.toString().replaceAll("ITSTINKS","myITstaffRULES");
			System.out.println("Password on "+ (i+1)+ " has been updated to: "+sPass.toString());
			passwords.set(i,sPass.toString());
		    }
		char_pass = sPass.toString().toCharArray();
		for (int j = 0; j<char_pass.length();j++)
		    {
			if (Character.isLowerCase(char_pass[j]))
			    {
				break;
			    }
			
		    }
	    }
    }
}
