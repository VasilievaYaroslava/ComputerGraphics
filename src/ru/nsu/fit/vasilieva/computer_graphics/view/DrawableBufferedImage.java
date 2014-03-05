package ru.nsu.fit.vasilieva.computer_graphics.view;

import java.awt.Color;
import java.awt.image.BufferedImage;

import ru.nsu.fit.vasilieva.computer_graphics.action_controllers.Drawable;


public class DrawableBufferedImage implements Drawable
{
	private BufferedImage image;
	private int rgb = 0;
	
	/**
	 * Constructs a {@link DrawableBufferedImage} of one of the {@link Drawable} types.
	 * It used {@link BufferedImage} for storing image.
	 * 
	 * @param width - the width of created image.
	 * @param height - the height of created image
	 */
	public DrawableBufferedImage(int width, int height)
	{
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
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
	
	/**
	 * Gets {@link BufferedImage}, which contains image created by this {@link DrawableBufferedImage}.
	 * 
	 * @return {@link BufferedImage}, which contains image created by this {@link DrawableBufferedImage}.
	 */
	public BufferedImage getBufferedImage()
	{
		image.flush();
		return image;
	}
	
}
