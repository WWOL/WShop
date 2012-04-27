import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class GUIHelper implements ActionListener {
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
		textArea.setVisible(true);
		textArea.setSize(300, 200);

		menuItem_items.setToolTipText("Load the items file.");
		menuItem_prices.setToolTipText("Load the prices file.");
		menuItem_items.addActionListener(this);
		menuItem_prices.addActionListener(this);

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

	public void actionPerformed(ActionEvent event) {
		BufferedReader bufferedReader = null;
		if (event.getSource().equals(menuItem_prices)){
			try {
				bufferedReader = new BufferedReader(new FileReader(new File(WShop.CONFIG + File.separator + "prices.txt")));
			} catch (Exception e){
				WShop.LOG.severe(WShop.SPRE + "GUIHelper: Failed loading prices file!");
				e.printStackTrace();
			}// end try
		} else if (event.getSource().equals(menuItem_items)){
			try {
				bufferedReader = new BufferedReader(new FileReader(new File(WShop.CONFIG + File.separator + "items.txt")));
			} catch (Exception e){
				WShop.LOG.severe(WShop.SPRE + "GUIHelper: Failed loading items file!");
				e.printStackTrace();
			}// end try
		}// end if
		String line;
		try {
			while ((line = bufferedReader.readLine()) != null){
				textArea.append(line);
				textArea.append("\n");
			}
		} catch (Exception e){
			WShop.LOG.severe(WShop.SPRE + "GUIHelper: Failed reading file!");
		}// end try
	}// end actionPerformed	
}// end GUIHelper
