import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class GUIHelper {
	JFrame frame;
	JMenuBar menuBar;
	JMenu menu_Load;
	JMenuItem menuItem_items;
	JMenuItem menuItem_prices;
	JTextArea textArea;
	
	public static void main(String[] s){
		GUIHelper guiHelper = new GUIHelper();
		guiHelper.launchGUI();
	}// end main
	
	public void launchGUI(){
		frame = new JFrame("WShop | GUIHelper");
		menuBar = new JMenuBar();
		menu_Load = new JMenu("Load");
		menuItem_items = new JMenuItem("Load items");
		menuItem_prices = new JMenuItem("Load prices");
		textArea = new JTextArea("Text Area\n");
		
		textArea.append("TODO This is where the text will go.");
		textArea.setVisible(false);
		textArea.setSize(300, 200);
		
		menuItem_items.setToolTipText("Load the items file.");
		menuItem_prices.setToolTipText("Load the prices file.");
		
		menu_Load.add(menuItem_items);
		menu_Load.add(menuItem_prices);
		
		menuBar.add(menu_Load);
		
		frame.add(textArea);
		frame.setJMenuBar(menuBar);
		frame.setSize(600, 400);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame.setVisible(true);
	}// end launchGUI
	
	public void actionPerformed(ActionEvent e){
		
	}
}// end GUIHelper
