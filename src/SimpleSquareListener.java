import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public class SimpleSquareListener implements MenuListener
{
	private MenuController controller;

	/*
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		controller.drawSimpleSquare();
	}
	*/

	@Override
	public void setMenuController(MenuController controller) 
	{
		this.controller = controller;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		controller.drawSimpleSquare();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
