import java.util.ArrayList;


public class InfoMenuItem 
{
	private String name;
	private ArrayList<InfoMenuItem> children;
	private MenuListener listener;
	private String picture;
	
	/**
	 * Constructs a {@link InfoMenuItem}, which represents item of menu structure. 
	 */
	public InfoMenuItem()
	{
		children = new ArrayList<InfoMenuItem>();
	}
	
	/**
	 * Sets the name of menu item.
	 * 
	 * @param name - the {@link String} for new name of menu item.
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * Gets the {@link MenuListener}, which you can use for processing mouse clicks on this menu item.
	 * 
	 * @return the {@link MenuListener} of this menu item.
	 */
	public MenuListener getListener() 
	{
		return listener;
	}

	/**
	 * Sets the {@link MenuListener}, which is designed for processing mouse clicks on this menu item.
	 * 
	 * @param listener - the {@link MenuListener}, which is designed for processing mouse clicks on this menu item.
	 */
	public void setListener(MenuListener listener) 
	{
		this.listener = listener;
	}
	
	/**
	 * Adds the {@link InfoMenuItem} to array of inserted menu items.
	 * 
	 * @param newChild - the {@link InfoMenuItem} for inserting.
	 */
	public void addChild(InfoMenuItem newChild)
	{
		children.add(newChild);
	}

	/**
	 * Gets array of inserted menu items.
	 * 
	 * @return the {@link ArrayList} of {@link InfoMenuItem}, which are inserted for this menu item.
	 */
	public ArrayList<InfoMenuItem> getChildren() 
	{
		return children;
	}

	/**
	 * Gets the name of file, which contains picture for icon of button for this menu item.
	 * 
	 * @return {@link String} - name of file, which contains picture.
	 */
	public String getPicture() 
	{
		return picture;
	}

	/**
	 * Sets the name of file, which contains picture for icon of button for this menu item.
	 * 
	 * @param picture - the {@link String}, which is name of file.
	 */
	public void setPicture(String picture) 
	{
		this.picture = picture;
	}

	/**
	 * Gets the name of this menu item.
	 * 
	 * @return name of this menu item.
	 */
	public String getName()
	{
		return name;
	}
}
