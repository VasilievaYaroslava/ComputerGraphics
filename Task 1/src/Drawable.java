import java.awt.Color;


public interface Drawable 
{
	/**
	 * Sets a pixel in this {@link Drawable}
	 * 
	 * @param x - the X coordinate of the pixel to set
	 * @param y - the Y coordinate of the pixel to set
	 */
	public void setPixel(int x, int y);
	
	/**
	 * Sets a color, which will be used for setting pixel on this {@link Drawable}.
	 * 
	 * @param color - the {@link Color} for setting it as default color.
	 */
	public void setColor(Color color);
}
