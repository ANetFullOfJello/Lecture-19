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
    //boolean to see if something is lower case
    static boolean lowcase;
    //boolean to see if something is upper case
    static boolean upcase;
    //boolean to see if something has a digit
    static boolean digit;
    //boolean to see if something has a special character
    static boolean special;
    //boolean to see if something is initially long enough
    static boolean passSize;
    //initialize main function
    public static void main(String [] args) throws FileNotFoundException
    {
	ArrayList<String> passwords = new ArrayList<String>();
	File inFile = new File("Passwords.txt");
	Scanner inputPass = new Scanner(inFile);
	String line  ="";

		//random number for upper and lower case stuff
		Random rng = new Random();
	while (inputPass.hasNext())
	    {
		line = inputPass.nextLine();
		passwords.add(line);
	    }
	inputPass.close();
	for (int i = 0; i<passwords.size();i++)
	    {
		StringBuilder sPass = new StringBuilder(passwords.get(i));
		char[] char_pass;

		char_pass = sPass.toString().toCharArray();
		 if (sPass.toString().toUpperCase().contains("ITSTINKS"))
		    {
			//buffer string
			String newPass = sPass.toString();
			newPass = newPass.toUpperCase();
			newPass = newPass.replaceAll("ITSTINKS","myITstaffRULES");
			System.out.println("Password on "+(i+1)+" contains the bad phrase ITSTINKS in any case combination");
			System.out.println("Password on "+ (i+1)+ " has been updated to: "+newPass);
			passwords.set(i,newPass);
			sPass = new StringBuilder(passwords.get(i));
		    }
		 char_pass = sPass.toString().toCharArray();
		 charChecker(char_pass);
		 if (lowcase == false)
		     {
			 System.out.println("Password on "+(i+1)+" contains no lowercase letters");
			 sPass.insert((sPass.length()/2),((char)(rng.nextInt(26)+'a')));
			 System.out.println("Password on "+(i+1)+" has been updated to: "+sPass.toString());
			 passwords.set(i,sPass.toString());
		     }
		 if (upcase == false)
		     {
			  System.out.println("Password on "+(i+1)+" contains no uppercase letters");
			  sPass.insert((sPass.length()/2),((char)(rng.nextInt(26)+'A')));
			  System.out.println("Password on "+(i+1)+" has been updated to: "+sPass.toString());
			  passwords.set(i,sPass.toString());
		     }
		 if (digit == false)
		     {
			 System.out.println("Password on "+(i+1)+" contains no numbers: ");
			 sPass.insert((sPass.length()/2),(rng.nextInt(10)));
			 System.out.println("Password on "+(i+1)+" has been updated to: "+sPass.toString());
			 passwords.set(i,sPass.toString());
		     }
		 if (special == false)
		     {
			 System.out.println("Password on "+(i+1)+" contains no symbols: ");
			 sPass.insert((sPass.length()/2),((char)(rng.nextInt(5)+';')));
			 System.out.println("Password on "+(i+1)+" has been updated to: "+sPass.toString());
			 passwords.set(i,sPass.toString());
		     }
		 if (passSize == false)
		     {
			 System.out.println("Password on "+(i+1)+" is less than 8 characters, therefore being too short: ");
			 while (sPass.toString().length()<8)
			     {
			 sPass.insert((sPass.length()),((char)(rng.nextInt(32)+'g')));
			     }
			 System.out.println("Password on "+(i+1)+" has been updated to: "+sPass.toString());
			 passwords.set(i,sPass.toString()); 
		     }
		 if (lowcase==true && upcase==true && digit==true && special==true && passSize == true)
		     {
			 System.out.println("Password on "+(i+1)+" is a valid password");	 
		     }
	    } //for loop for the arraylist
    }//main method
    public static void charChecker(char[] test)
    {
	//reset booleans
	lowcase = false;
	upcase = false;
	digit = false;
	special = false;
	passSize = false;
	//checks password for cases, digits,and special chars
		for (int j = 0; j<test.length;j++)
		    {
			if (Character.isLowerCase(test[j]))
			    {
				lowcase = true;
			    }
			if (Character.isUpperCase(test[j]))
			    {
				upcase = true;
			    }
			if (Character.isDigit(test[j]))
			    {
				digit = true;
			    }
			if (!(Character.isDigit(test[j]) || Character.isLetter(test[j])))
			    {
				special = true;
			    }
			if (test.length>=8)
			    {
				passSize = true;
			    }
		    }
    }
}//class
