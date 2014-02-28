import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public interface MenuListener extends MouseListener
{
	/**
	 * Sets the MenuController. Its methods will be called after mouse clicked.
	 * @param
	 * contr - the MenuController to be set
	 */
	public void setMenuController(MenuController controller);
}
