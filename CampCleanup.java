import java.io.*;
import java.util.*;

public class CampCleanup
{
  //static String filename = "input-sample.txt"; //for testing purposes 
  static String filename = "input.txt"; //the original input 
    
  static String [] input;
 
  /**
   * solves part I
   */
   public static void getOverlaps() throws IOException
   {
       readInputIntoArray();
       int sum = 0; 
       for(int i=0; i<input.length;i++)
       {
           sum+= totalOverlap(i) ? 1 : 0; // converto boolean to int 
           
       }
       
       System.out.println("____________"); 
       System.out.println("Total overlaps "+sum); 
       sum = 0; 
       for(int i=0; i<input.length;i++)
       {
           sum+= partialOverlap(i) ? 1 : 0; // converto boolean to int 
           
       }
       
       System.out.println("____________"); 
       System.out.println("partial overlaps "+sum);        
    } 
    
    public static boolean partialOverlap(int number)
    {
        //input has the following format: a-b, c-d 
        String pairs[] = input[number].split(","); //splits the string into two cleaning sections 
        //splits the pair now into X = (a,b) and Y = (c,d)
        String x[] = pairs[0].split("-"); 
        String y[] = pairs[1].split("-"); 
        int a = Integer.parseInt(x[0]); //extract the numbers 
        int b = Integer.parseInt(x[1]);
        int c = Integer.parseInt(y[0]);
        int d = Integer.parseInt(y[1]); 
        
        if((b < c)||(d < a ))
        {
         return false; //no partial overlap   
        }
        return true; // partial overlap 
    }
    
    public static boolean totalOverlap(int number)
    {
        //input has the following format: a-b, c-d 
        String pairs[] = input[number].split(","); //splits the string into two cleaning sections 
        //splits the pair now into X = (a,b) and Y = (c,d)
        String x[] = pairs[0].split("-"); 
        String y[] = pairs[1].split("-"); 
        int a = Integer.parseInt(x[0]); //extract the numbers 
        int b = Integer.parseInt(x[1]);
        int c = Integer.parseInt(y[0]);
        int d = Integer.parseInt(y[1]); 
        
        if(((a <= c) && (d <= b))|| ((c <= a) && (b <= d)))
        {
         return true; //overlap   
        }
        return false; //no overlap 
    }
 
    /**
     * Die Methode liest den Input der Textdatei in ein Array ein. 
     */
    public static void readInputIntoArray() throws IOException
    {
    int arraySize =0; 
    try
    {
        arraySize = getInputLength(); 
    }
    catch (IOException e) 
    {
        System.out.println("Es ist ein Fehler beim Einlesen passiert!"); 
        System.exit(1); //Programm beenden
    }
    input = new String[arraySize]; //Erstelle leeres Array mit der Anzahl 
    
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);      
    String zeile = "";
    
    for(int i=0; i<arraySize;i++)
    {
         input[i] = br.readLine();
    }
      br.close();
      //array should be read correctly  
    }  
    
    /**
     * Methode bestimmt die Länge der Texteingabe 
     */
    public static int getInputLength() throws IOException
    {
     int size = 0;  
     FileReader fr = new FileReader(filename);
     BufferedReader br = new BufferedReader(fr);  
      //Bestimme die Anzahl der Werte! 
     String zeile = "";
     while( (zeile = br.readLine()) != null )
     {
        System.out.println(zeile);
        size++; 
      }
      br.close();
    return size; 
    }    


}
