package Project_VirtualKeys;

import Project_VirtualKeys.Options;
import Project_VirtualKeys.Screen;
import Project_VirtualKeys.WelcomeScreen;
import Project_VirtualKeys.Directories;


public class Service_screen {
	
	static Directories dir = new Directories();
	
	
	
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
    public static Options FileOptionsScreen = new Options();
    
    

    public static Screen CurrentScreen = WelcomeScreen;

    
    public static Screen getCurrentScreen() {
        return CurrentScreen;
    }

    
    public static void setCurrentScreen(Screen currentScreen) {
        CurrentScreen = currentScreen;
    }
    
    
    
}
