import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public class AboutProgramMenuListener implements MenuListener 
{
	private MenuController controller;

	/*
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		controller.aboutProgram();
	}
	*/

	@Override
	public void setMenuController(MenuController contr) 
	{
		controller = contr;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		controller.aboutProgram();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
