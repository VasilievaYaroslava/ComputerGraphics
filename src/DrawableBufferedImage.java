import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;


public class DrawableBufferedImage implements Drawable
{
	private BufferedImage image;
	private int rgb = 0;
	
	public DrawableBufferedImage(int width, int height)
	{
		System.out.println(width + "^^^^^^^^^" + height);
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics h = image.createGraphics();
		
		//Graphics h = image.getGraphics();
		h.setColor(Color.LIGHT_GRAY);
		h.fillRect(0, 0, width, height);
		
		h.dispose();
	}

	@Override
	public void setPixel(int x, int y) 
	{
		image.setRGB(x, y, rgb);
	}

	@Override
	public void setColor(Color color) 
	{
		rgb = color.getRGB();
	}
	
	public BufferedImage getBufferedImage()
	{
		image.flush();
		return image;
	}
	
}
