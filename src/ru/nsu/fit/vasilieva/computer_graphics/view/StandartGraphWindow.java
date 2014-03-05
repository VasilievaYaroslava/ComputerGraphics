package ru.nsu.fit.vasilieva.computer_graphics.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class StandartGraphWindow extends JFrame
{
	private JPanel panel;
	private BufferedImage bufferedImage;

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a {@link StandartGraphWindow}.
	 * 
	 * @param title - the {@link String}, which is the name of this window.
	 * @param menuItems - the {@link ArrayList} of first-range nested {@link InfoMenuItem}.
	 */
	public StandartGraphWindow(String title, AbstractBarsCreator creator)
	{
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension size = new Dimension(800, 600);
		setPreferredSize(size);
		setMinimumSize(size);
		setVisible(true);
		
		panel = new JPanel() 
			{
				private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g) 
				{
					g.drawImage(bufferedImage, 0, 0, null);
				}
			};
		

		setLayout(new BorderLayout());
		add(creator.createToolBar(), BorderLayout.BEFORE_FIRST_LINE);
		setJMenuBar(creator.createMenuBar());
		add(panel, BorderLayout.CENTER);
	
		pack();
	}

	/**
	 * Views text message about this program. 
	 */
	public void viewAbout()
	{
		viewMessage("О программе", 
				"Данное приложение разработано в качестве лабораторной работы\n" +
				"по курсу \"Компьютерная графика\" студенткой третьего курса\n" +
				"Факультета Информационных Технологий\n" +
				"Новосибирского Государственного университета\n" +
				"Васильевой Ярославой Олеговной.");
	}
	
	/**
	 * Gets a maximal size of image, which possibly to be set to this window.
	 * 
	 * @return the {@link Dimension}, which contains size.
	 */
	public Dimension getImageSize()
	{
		return panel.getSize();
	}
	
	/**
	 * Sets picture to this window.
	 * 
	 * @param picture - the {@link DrawableBufferedImage}, which enables to get image for setting.
	 */
	public void setDrawable(DrawableBufferedImage picture)
	{
		bufferedImage = picture.getBufferedImage();
		repaint();
	}
	
	/**
	 * Views text message about fail of program initialisation.
	 */
	public static void initialisationFail() 
	{
		viewMessage("Ошибка", "Произошла ошибка при инициализации программы. Повреждены вспомогательные файлы приложения.");
	}
	
	/**
	 * Views text message in individual window.
	 * 
	 * @param title - the {@link String}, which is title of new window.
	 * @param text - the {@link String}, which is text of message.
	 */
	private static void viewMessage(String title, String text)
	{
		JOptionPane.showMessageDialog(new JFrame(), text, title, JOptionPane.ERROR_MESSAGE);
	}
	
}
