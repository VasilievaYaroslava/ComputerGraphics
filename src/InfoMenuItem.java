import java.util.ArrayList;


public class InfoMenuItem 
{
	private String name;
	private ArrayList<InfoMenuItem> children;
	private MenuListener listener;
	private String picture;
	
	
	public InfoMenuItem()
	{
		children = new ArrayList<InfoMenuItem>();
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public MenuListener getListener() 
	{
		return listener;
	}

	public void setListener(MenuListener listener) 
	{
		this.listener = listener;
	}
	
	public void addChild(InfoMenuItem newChild)
	{
		children.add(newChild);
	}

	public ArrayList<InfoMenuItem> getChildren() 
	{
		return children;
	}

	public String getPicture() 
	{
		return picture;
	}

	public void setPicture(String picture) 
	{
		this.picture = picture;
	}

	public String getName()
	{
		return name;
	}
}
