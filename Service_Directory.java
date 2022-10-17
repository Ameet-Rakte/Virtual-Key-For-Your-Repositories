package Project_VirtualKeys;

import java.io.File;

import Project_VirtualKeys.Directories;


public class Service_Directory {

    private static Directories fileDirectory = new Directories();
    
    public static void PrintFiles() {
    	
    	fileDirectory.fillFiles();

        for (File file : Service_Directory.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static Directories getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(Directories fileDirectory) {
    	Service_Directory.fileDirectory = fileDirectory;
    }


}