import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MenuController 
{
	private StandartGraphWindow window;
	private Loader loader;

	
	private MenuController()
	{
		try 
		{
			loader = new Loader(this);
			window = new StandartGraphWindow("Лабораторная работа №1", loader.getInfoItems());
		} 
		catch (Exception e) 
		{
			StandartGraphWindow.initialisationFail();
			e.printStackTrace();
		}
	}
	
	/**
	 * Start function.
	 * 
	 * @param args - the array of {@link String}, which are the programs arguments.
	 */
	public static void main (String args[])
	{
		MenuController controller = new MenuController();
	}
	
	/**
	 * Views text message about this program.
	 */
	public void aboutProgram()
	{
		window.viewAbout();
	}
	
	/**
	 * Closes this program.
	 */
	public void closeProgram()
	{
		System.exit(0);
	}
	
	/**
	 * Draws square on main window of this program.
	 */
	public void drawSimpleSquare() 
	{
		System.out.println("drawSimpleSquare() ");
		ControllerDrawSimpleSquare contr = new ControllerDrawSimpleSquare();
		Dimension d = window.getSize();

		
		DrawableBufferedImage image = new DrawableBufferedImage(d.width, d.height);
		contr.paintSimpleSquare(image);
		window.setDrawable(image);
		

	}
}
