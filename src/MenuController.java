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
	
	public static void main (String args[])
	{
		MenuController controller = new MenuController();
	}
	
	public void aboutProgram()
	{
		window.viewAbout();
	}
	
	public void closeProgram()
	{
		System.exit(0);
	}
	
	public void drawSimpleSquare() 
	{
		ControllerDrawSimpleSquare contr = new ControllerDrawSimpleSquare();
		Dimension d = window.getSize();
		DrawableBufferedImage image = new DrawableBufferedImage(d.width, d.height);
		contr.paintSimpleSquare(image, d.width, d.height);
		window.setDrawable(image);
		
		window.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
            	System.out.println("Component RESIZED");
            	//drawSimpleSquare();
            	ControllerDrawSimpleSquare contr = new ControllerDrawSimpleSquare();
        		Dimension d = window.getSize();
        		DrawableBufferedImage image = new DrawableBufferedImage(d.width, d.height);
        		contr.paintSimpleSquare(image, d.width, d.height);
        		window.setDrawable(image);
            }
        });
		/*
		window.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent arg0) {
				System.out.println("Component RESIZED");
				drawSimpleSquare();
				
			}
			
			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
	}
}
