import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Loader 
{
	private static final String fileMenu = "menu.txt";
	private ArrayList<InfoMenuItem> info;
	
	public Loader(MenuController controller) throws FileNotFoundException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
System.out.println("Start loader()");
		
		info = new ArrayList<InfoMenuItem>();
System.out.println("Scanner");

		Scanner scanner = new Scanner(getClass().getResourceAsStream(fileMenu));
System.out.println("Scanner");
		
		int c = scanner.nextInt();
		scanner.nextLine();
		System.out.println(c);
		for (int i = 0; i < c; ++i)
		{
System.out.println("FOR loader()");
			info.add(fillItem(scanner, controller));
		}
System.out.println("Finish loader()");		
	}
	
	public ArrayList<InfoMenuItem> getInfoItems()
	{
		return info;
	}
	
	private InfoMenuItem fillItem(Scanner scanner, MenuController controller) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
System.out.println("Start fillItem");
System.out.flush();
		int counter = 0;
		InfoMenuItem newItem = new InfoMenuItem();
		newItem.setName(scanner.nextLine());
		System.out.println("NAME" + newItem.getName());
		String line = scanner.nextLine();
		
		try
		{
			counter = new Integer(line);
System.out.println("Normal counter");
		}
		catch (NumberFormatException e)
		{
System.out.println("Bad counter");
			newItem.setListener(createMenuListener(line, controller));
			newItem.setPicture(scanner.nextLine());
System.out.println("End bad counter");
		}
		
		for(int i = 0; i < counter; ++i)
		{
System.out.println("For fillItem");
			newItem.addChild(fillItem(scanner, controller));
		}
		
System.out.println("Finish fillItem");
		return newItem;
	}
	
	private MenuListener createMenuListener(String type, MenuController controller) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
System.out.println("Start create listener " + type);
		MenuListener newListener;
		newListener = (MenuListener) Class.forName(type).newInstance();
System.out.println("Create listener");
		newListener.setMenuController(controller);
System.out.println("Finish create listener");
		return newListener;
	}
}
