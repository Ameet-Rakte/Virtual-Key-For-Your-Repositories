package Project_VirtualKeys;
import java.util.*;


import Project_VirtualKeys.Service_Directory;
import Project_VirtualKeys.Service_screen;




public class WelcomeScreen implements Screen 
{

    private String welcomeText = "	Project : Virtual Key for Your Repositories";
    private String developerText = "	         Developer: Amit Rakte";

    private ArrayList<String> options = new ArrayList<>();


    public WelcomeScreen() 
    {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    
    public void introWS() 
    {
    	System.out.println("***************************************************************");
    	System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("***************************************************************");
        Show();
    }
    
    
    

    public void Show() 
    {   
    	System.out.println("Main Menu");
        for (String s : options)  
        {
            System.out.println(s);
        }
    }
    private void Quit() 
    {
    	System.out.println("Thank you ! Have a nice day ahead..!!");
	}

    public void GetUserInput() 
    {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 4) 
        {
            this.NavigateOption(selectedOption);
        }
    }

    public void NavigateOption(int option) 
    {
        switch(option) 
        {
            case 1: // Show Files in Directory
                this.ShowFiles();
  	    	  System.out.println("------------------------------------");
                this.Show();
                System.out.println("=======================");
                break;
                
            case 2: // Show File Options menu
            	Service_screen.setCurrentScreen(Service_screen.FileOptionsScreen);
            	Service_screen.getCurrentScreen().Show();
            	Service_screen.getCurrentScreen().GetUserInput();
            	 System.out.println("=======================");
                this.Show();   
                break;
                
            case 3://Quit Program
            	this.Quit();
                break;
                
            default:
                System.out.println("Please enter valid selection-");
                break;
        }        
    }
 

	public void ShowFiles() 
	{
        System.out.println("List of Files: ");
    	Service_Directory.PrintFiles();
    }
    
    private int getOption() 
    {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try 
        {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) 
        {

        }
        return returnOption;
    }
}