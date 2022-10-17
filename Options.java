package Project_VirtualKeys;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Project_VirtualKeys.Directories;
import Project_VirtualKeys.Service_screen;


public class Options implements Screen {
	
	private Directories dir = new Directories();
	
	private ArrayList<String> options = new ArrayList<>();

    public Options() {
    	
    	options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");
        
    }
    
    
    public void Show() {
    	System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        
    	switch(option) {

            case 1: // Add File            	
                this.AddFile();
                this.Show();
                break;
                
            case 2: // Delete File
                this.DeleteFile();                
                this.Show();
                break;
                
            case 3: // Search File
                this.SearchFile();
                this.Show();
                break;
            
               
            case 4: // Return to Menu
            	
            	Service_screen.setCurrentScreen(Service_screen.WelcomeScreen);
            	Service_screen.getCurrentScreen().Show();
            	Service_screen.getCurrentScreen().GetUserInput();
                
                break;
                
            default:
                System.out.println("Please make sure that you've entered the right Option");
                break;
                
                
        }

    }
    
    //To Add the file:

    public void AddFile() {
        System.out.println("Please Enter the Filename:");
        
        String fileName = this.getInputString();
       
        System.out.println("You are adding a file named: " + fileName);
        
		try {
			Path path = FileSystems.getDefault().getPath(Directories.name + fileName).toAbsolutePath();
			File file = new File(dir.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("File created: " + file.getName());
		    	  dir.getFiles().add(file);
		    	  System.out.println("File Workspace :"+Directories.name+file);
		    	  System.out.println("----------------------------------------------------------------");

		    	  
		      } else {
		        System.out.println("This File Already Exits, no need to add another");
		    	System.out.println("----------------------------------------------------------------");

		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    
    public void DeleteFile() {
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);
        
        
	    //To Delete the file:
        
		Path path = FileSystems.getDefault().getPath(Directories.name + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("Deleted File: " + file.getName());
	    	  dir.getFiles().remove(file);
	    	  System.out.println("File Workspace :"+Directories.name+file);

	    	  System.out.println("----------------------------------------------------------------");
	      } else {
	        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
	    	System.out.println("----------------------------------------------------------------");

	      }
    }
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);
        
        //TODO Fix it so ArrayList obtains files
        //Finished TODO
        
        ArrayList<File> files = dir.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
		    	  System.out.println("File Workspace :"+Directories.name+fileName);

		    	System.out.println("----------------------------------------------------------------");

			}
        }
        if (found == false) {
        	System.out.println("File not found");
	    	System.out.println("----------------------------------------------------------------");

        }
    }
    
    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("Invalid input");
        }
        return returnOption;

    }

}
