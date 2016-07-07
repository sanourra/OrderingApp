import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUIMenu
{
	private JFrame frame;
	public static void main (String[] args)
	{
		GUIMenu gui = new GUIMenu();
		gui.start();
	}
	public void start()
	{
		frame = new JFrame("GUI Menus");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		
		makeMenus();
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	private void makeMenus()
	{
		JMenuBar menuBar;
		JMenu fileMenu;
		JMenu editMenu;
		JMenu aboutMenu;
		
		
		JMenuItem menuItem;
		
		menuBar = new JMenuBar();

		
		//set up the file Menu
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F); //adds hotkey shortcut to File menu
        
       
        	//add file menu items below
        	menuItem = new JMenuItem("New"); //tells program that File has a new item, "New"
        	menuItem.setMnemonic(KeyEvent.VK_N); //tells program that Alt + N will activate New menu item
        	menuItem.addActionListener(new newListener());//adds action listener and tells it which class to reference
        	menuItem.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK)); //sets keyboard shortcut to use CTRL + O to use the New option 
        	fileMenu.add(menuItem); //adds "New" to the options in the File menu
        
        	menuItem = new JMenuItem("Open");
        	menuItem.setMnemonic(KeyEvent.VK_O);
        	menuItem.addActionListener(new openListener());
        	menuItem.setAccelerator(
        			KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
        	fileMenu.add(menuItem);

        	menuItem = new JMenuItem("Save");
        	menuItem.setMnemonic(KeyEvent.VK_S);
        	menuItem.addActionListener(new saveListener());
        	menuItem.setAccelerator(
        			KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        	fileMenu.add(menuItem);

        	menuItem = new JMenuItem("Save As");
        	menuItem.setMnemonic(KeyEvent.VK_A);
        	menuItem.setDisplayedMnemonicIndex(5);
        	menuItem.addActionListener(new saveAsListener());
        	fileMenu.add(menuItem);

        	fileMenu.addSeparator();

        	menuItem = new JMenuItem("Exit");
        	menuItem.setMnemonic(KeyEvent.VK_X);
        	menuItem.addActionListener(new exitListener());
        	menuItem.setAccelerator(
        			KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
        	fileMenu.add(menuItem);
        menuBar.add(fileMenu);//adds file menu to menu bar
		
        
        //set up the Edit Menu
        editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E); //adds Alt + E keyboard shortcut for Edit menu
                
	        //add Edit menu items below edit menu setup
	        //add Cut and keyboard shortcuts to the Edit menu
	        menuItem = new JMenuItem("Cut");
	        menuItem.setMnemonic(KeyEvent.VK_U); //sets Alt + U as the shortcut for CUT
	        menuItem.addActionListener(new cutListener());
	        menuItem.setAccelerator(
	        		KeyStroke.getKeyStroke(
	        				KeyEvent.VK_X, Event.CTRL_MASK)); //sets CTRL + x as Cut keyboard shortcut
	        editMenu.add(menuItem);
	        //add Copy and its keyboard shortcuts to the Edit menu
	        menuItem = new JMenuItem("Copy");
	        menuItem.setMnemonic(KeyEvent.VK_C); //adds shortcut ALT +C
	        menuItem.addActionListener(new copyListener());
	        menuItem.setAccelerator(
	        		KeyStroke.getKeyStroke(KeyEvent.VK_C, 
	        				Event.CTRL_MASK)); //sets CTRL + C as shortcut
	        editMenu.add(menuItem);
	        //add Paste and shortcuts to Edit menu
	        menuItem = new JMenuItem("Paste");
	        menuItem.setMnemonic(KeyEvent.VK_V);  //sets Alt + V as shortcut
	        menuItem.addActionListener(new pasteListener());
	        menuItem.setAccelerator(
	        		KeyStroke.getKeyStroke(KeyEvent.VK_V,
	        				Event.CTRL_MASK));
	        editMenu.add(menuItem);
	        menuBar.add(editMenu);
	    
	    //create new menu for About
	    aboutMenu = new JMenu("About");
	    aboutMenu.setMnemonic(KeyEvent.VK_B); //sets Alt + B as About keyboard shortcut
	   
	    
		    //adding items to the About selection below
		    menuItem = new JMenuItem("Info");
		    menuItem.setMnemonic(KeyEvent.VK_N);
		    menuItem.addActionListener(new infoListener());
		    menuItem.setAccelerator(
		    		KeyStroke.getKeyStroke(
		    				KeyEvent.VK_N, Event.CTRL_MASK));
		    aboutMenu.add(menuItem);
		    //adding Support item to the Help menu
	        
   	        menuItem = new JMenuItem("Support Info");
		    menuItem.setMnemonic(KeyEvent.VK_P);
		    menuItem.addActionListener(new supportListener());
		    menuItem.setAccelerator(
		    		KeyStroke.getKeyStroke(
		    				KeyEvent.VK_P, Event.CTRL_MASK));
            aboutMenu.add(menuItem);

	    menuBar.add(aboutMenu); //adds About as a menu item to the menu bar
		frame.setJMenuBar(menuBar);
	}
	
	
	
	private class newListener implements ActionListener //program listens for click on New menu option
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, 
				"The File > New menu option was clicked.",
				"Menu Item Click",
				JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private class openListener implements ActionListener //program listens for click on Open menu option
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame,
					"The File > Open menu option was clicked.",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
		
	private class saveListener implements ActionListener //program listens for click on Save menu option
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, 
					"The File > Save menu option was clicked",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private class saveAsListener implements ActionListener //program listens for click on Save As menu option
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, 
					"The File > Save As menu option was clicked",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private class exitListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0); //does not return with dialog box, but exits program
		}
	}
	//class below sets up the cutListener (referenced in the edit menu) to return a dialog message when activated
	private class cutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame,
					"The Edit > Cut menu option was clicked",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private class copyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame,
					"The Edit > Copy menu option was selected",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private class pasteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame,
					"The Edit > Paste menu option was selected",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private class infoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame,
					"The About > Info menu option was selected",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private class supportListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame,
					"The About > Support menu option was selected",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}