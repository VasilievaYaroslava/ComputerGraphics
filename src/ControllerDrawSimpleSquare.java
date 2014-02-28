import java.awt.Color;


public class ControllerDrawSimpleSquare 
{
	/**
	 * 
	 * @param picture
	 * @param width
	 * @param height
	 */
	public void paintSimpleSquare(Drawable picture, int width, int height)
	{
		picture.setColor(Color.CYAN);
		for(int i = width / 2 - 100; i <= width / 2 + 100; ++i)
		{
			for(int j = height / 2 - 100; j <= height / 2 + 100; ++j)
			{
				picture.setPixel(i, j);
			}
		}
	}
}
