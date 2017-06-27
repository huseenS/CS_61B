package Homework1;

/* OpenCommercial.java */

import java.net.*;
import java.io.*;
/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

	String inputLine;
    try (BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {
    	
	    System.out.print("Please enter the name of a company (without spaces): ");
	    System.out.flush();        /* Make sure the line is printed immediately. */
	    inputLine = keyboard.readLine();
	    
	    
	    URL url = new URL("http://www." + inputLine + ".com");
	    System.out.println("url is " + url.toString());
	    
	    BufferedReader readSite = new BufferedReader
	    		(new InputStreamReader(url.openStream()));
	    
	    
	    StringBuilder sb = new StringBuilder();
	    String siteText;
	    int counter = 4;
	    while((siteText = readSite.readLine()) != null && counter > 0 ) {
	    	sb.append(siteText).reverse().append("\n");
	    	counter--;
	    }
	    System.out.println(sb);
    } catch(MalformedURLException ex) {
    	ex.printStackTrace();
    	System.out.println("Can't find website");
    } 

  }
}