import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Loader 
{
	private static final String fileMenu = "menu.txt";
	private ArrayList<InfoMenuItem> info;
	
	/**
	 * Constructs a {@link Loader} for loading menu structure from file.
	 * 
	 * @param controller - the {@link MenuController}, its functions will be used 
	 * 			inherited classes of {@link MenuListener}.
	 */
	public Loader(MenuController controller) throws FileNotFoundException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		info = new ArrayList<InfoMenuItem>();
		Scanner scanner = new Scanner(getClass().getResourceAsStream(fileMenu));
		
		int c = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < c; ++i)
		{
			info.add(fillItem(scanner, controller));
		}	
	}
	
	/**
	 * Gets all first-range nested menu items.
	 * 
	 * @return {@link ArrayList} of {@link InfoMenuItem}, which are first-range nested.
	 */
	public ArrayList<InfoMenuItem> getInfoItems()
	{
		return info;
	}
	
	/**
	 * Fill information one menu item.
	 * 
	 * @param scanner - the {@link Scanner} for reading from file, which contains menu structure.
	 * @param controller - the {@link MenuController}, its functions will be used 
	 * 			inherited classes of {@link MenuListener}.
	 * @return filled of information {@link InfoMenuItem}.
	 */
	private InfoMenuItem fillItem(Scanner scanner, MenuController controller) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		int counter = 0;
		InfoMenuItem newItem = new InfoMenuItem();
		newItem.setName(scanner.nextLine());
		String line = scanner.nextLine();
		
		try
		{
			counter = new Integer(line);
		}
		catch (NumberFormatException e)
		{
			newItem.setListener(createMenuListener(line, controller));
			newItem.setPicture(scanner.nextLine());
		}
		
		for(int i = 0; i < counter; ++i)
		{
			newItem.addChild(fillItem(scanner, controller));
		}
		
		return newItem;
	}
	
	/**
	 * Creates {@link MenuListener} for menu item.
	 * 
	 * @param type - the {@link String}, which contain name of class for derived class of {@link MenuListener}, 
	 * 				which will be created
	 * @param controller - the {@link MenuController}, its functions will be used 
	 * 			inherited classes of {@link MenuListener}.
	 * @return the {@link MenuListener} for menu item.
	 */
	private MenuListener createMenuListener(String type, MenuController controller) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		MenuListener newListener;
		newListener = (MenuListener) Class.forName(type).newInstance();
		newListener.setMenuController(controller);
		return newListener;
	}
}
