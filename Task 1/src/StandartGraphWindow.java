import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.BufferedInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


public class StandartGraphWindow extends JFrame
{
	private JToolBar toolBar;
	private JPanel panel;
	private BufferedImage bufferedImage;

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a {@link StandartGraphWindow}.
	 * 
	 * @param title - the {@link String}, which is the name of this window.
	 * @param menuItems - the {@link ArrayList} of first-range nested {@link InfoMenuItem}.
	 */
	public StandartGraphWindow(String title, ArrayList<InfoMenuItem> menuItems)
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
		toolBar = new JToolBar("");
		add(toolBar, BorderLayout.BEFORE_FIRST_LINE);
	    toolBar.setFloatable(false); 
		JMenuBar menuBar = new JMenuBar();
		
		for(int i = 0; i < menuItems.size(); ++i)
		{
			menuBar.add(createMenuItem(menuItems.get(i)));
		}
		
		toolBar.setBorderPainted(true);
		menuBar.setBorderPainted(true);		
		setJMenuBar(menuBar);
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
	
	/**
	 * Create button and item menu.
	 * 
	 * @param item - the {@link InfoMenuItem}, which contain all info about menu item.
	 * @return {@link JMenu} - menu item, which was created.
	 */
	private JMenu createMenuItem(InfoMenuItem item) 
	{
		JMenu newItem = new JMenu(item.getName());
		
		if (item.getChildren().isEmpty())
		{
			JButton button = new JButton();
			button.addMouseListener(item.getListener());
			System.out.println(item.getPicture());
			ImageIcon image = new ImageIcon(getClass().getResource(item.getPicture()));
			
			button.setIcon(new ImageIcon(image.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));;
			toolBar.add(button);
			newItem.addMouseListener(item.getListener());
			
		}
		else
		{
			for(int i = 0; i < item.getChildren().size(); ++i)
			{
				newItem.add(createMenuItem(item.getChildren().get(i)));
			}
		}
		
		return newItem;
	}
	
}
