/**
 * 
 * @author Brian McCarthy
 * Build: 10
 * 
 */

import java.io.File;
import java.util.logging.Logger;

public class WShop extends Plugin{
	
	final static Logger LOG = Logger.getLogger("Minecraft");
	final static String NAME = "WShop";
	final static String AUTHOR = "WWOL";
	final static String VER = "1.0";
	final static String SPRE = "[" + NAME + "] ";
	final static String PRE = Colors.Blue + SPRE + Colors.Gold;
	final static String CONFIG = "plugins" + File.separator + "config" + File.separator + NAME + File.separator;
	static PropertiesFile PROPS;
	
	private boolean useUpdatr;
	
	WShopListener WShopListener = new WShopListener();

	public void enable(){
		loadProps();
		loadUpdatr();
		etc.getLoader().addListener(PluginLoader.Hook.COMMAND, WShopListener, this, PluginListener.Priority.MEDIUM);
		etc.getLoader().addListener(PluginLoader.Hook.BLOCK_RIGHTCLICKED, WShopListener, this, PluginListener.Priority.MEDIUM);
		LOG.info(SPRE + NAME + " by " + AUTHOR + " Ver:" + VER + " enabled!");
	}// end enable

	public void disable(){
		LOG.info(SPRE + NAME + " by " + AUTHOR + " Ver:" + VER + " disabled!");
	}// end disable 

	public void loadProps(){
		File file = new File(CONFIG);
		if (!file.exists()){
			file.mkdirs();
		}// end if
		PROPS = new PropertiesFile(CONFIG + NAME + ".properties");

		useUpdatr = PROPS.getBoolean("useUpdatr", false);
	}// end loadProps

	/**
	 * Load Updatr only if the user wants it.
	 */
	public void loadUpdatr(){
		File updatrFolder = new File("Updatr");
		File updatrFile = new File("Updatr" + File.separator + NAME + ".updatr");
		if (useUpdatr){
			if (!updatrFolder.exists()){
				try{
					updatrFolder.mkdirs();
				} catch (Exception e){
					LOG.warning(SPRE + "Failed to create Updatr folder!");
				}// end try
			}// end if
			if (!updatrFile.exists()){
				try{
					updatrFile.createNewFile();
				} catch (Exception e){
					LOG.warning(SPRE + "Failed to create Updatr file!");
				}// end try
				PropertiesFile updatrProps = new PropertiesFile("Updatr" + File.separator + NAME + ".updatr");
				updatrProps.setString("version ", " " + VER);
				updatrProps.setString("file ", " ");
				updatrProps.setString("", "");
				updatrProps.setString("", "");
				//TODO Check Updatr lines.
			}// end if
		}// end if
	}// end loadUpdatr
}// end WShop
