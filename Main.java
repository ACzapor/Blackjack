package BlackJack;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
public static void main(String[] args) {
		
		try {
			
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			 
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       
	    }
	    catch (ClassNotFoundException e) {
	       
	    }
	    catch (InstantiationException e) {
	       
	    }
	    catch (IllegalAccessException e) {
	       
	    }
		
		new GameFrame();
	}
}
