package ControlFlowProject;


public class AsciiChars 
{
  public static void printNumbers()
  {
	  for (int i=0; i < 10; i++) {
		  System.out.print(i + " ");
	  }
	  System.out.println();
  }

  public static void printLowerCase()
  {
	  for(char ch='a'; ch < 'z'; ch++) {
		  System.out.print(ch + " ");
	  }
	  System.out.println();
    
  }

  public static void printUpperCase()
  {
	  for(char ch='A'; ch < 'Z'; ch++) {
		  
		  System.out.print(ch + " ");
	  }
	  System.out.println();
  }
}
