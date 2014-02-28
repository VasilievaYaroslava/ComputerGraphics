import java.awt.event.MouseEvent;


public class AboutProgramMenuListener implements MenuListener 
{
	private MenuController controller;
	
	@Override
	public void setMenuController(MenuController contr) 
	{
		controller = contr;
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		controller.aboutProgram();
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
	}

}
