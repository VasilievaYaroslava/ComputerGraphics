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
	private JLabel label;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StandartGraphWindow(String title, ArrayList<InfoMenuItem> menuItems)
	{
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension size = new Dimension(800, 600);
		setPreferredSize(size);
		setMinimumSize(size);
		setVisible(true);
		
		
		panel = new JPanel();
		label = new JLabel();
		setLayout(new BorderLayout());
		
		toolBar = new JToolBar("");
		add(toolBar, BorderLayout.BEFORE_FIRST_LINE);
	        toolBar.setFloatable(false); // запрещаем двигать панель

	        // установить ориентацию панели
	        //toolBar.setOrientation(SwingConstants.HORIZONTAL);
	        //toolBar.setOrientation(SwingConstants.VERTICAL);
	        
	        //toolBar.addSeparator();
	        //toolBar.setBackground(Color.BLACK);
		
		JMenuBar menuBar = new JMenuBar();
		
		for(int i = 0; i < menuItems.size(); ++i)
		{
			menuBar.add(createMenuItem(menuItems.get(i)));
		}
		
		toolBar.setBorderPainted(true);
		//toolBar.pai
		menuBar.setBorderPainted(true);
		//menuBar.set
		//add(menuBar);
		
		setJMenuBar(menuBar);
		//add(toolBar);
		
		Canvas canvas = new Canvas();
		
		canvas.setBackground(Color.BLUE);
		
		//add(canvas);
		
		//panel.setIcon(new ImageIcon(getClass().getResource("AboutProgram.png")));
		//panel.setBackground(Color.CYAN);
		add(panel, BorderLayout.CENTER);
		
		pack();
	}

	 
	public void viewAbout()
	{
		viewMessage("О программе", 
				"Данное приложение разработано в качестве лабораторной работы\n" +
				"по курсу \"Компьютерная графика\" студенткой третьего курса\n" +
				"Факультета Информационных Технологий\n" +
				"Новосибирского Государственного университета\n" +
				"Васильевой Ярославой Олеговной.");
	}
	
	public Dimension getImageSize()
	{
		return label.getSize();
	}
	
	public void setDrawable(DrawableBufferedImage picture)
	{
		System.out.println("Set drawable!");
		////label.paint(picture.getBufferedImage().getGraphics());
		
		BufferedImage g = new BufferedImage(300, 300, ColorSpace.TYPE_RGB);
		
		panel.removeAll();
		////label = new JLabel(new ImageIcon(getClass().getResource("Close.png")));
		label = new JLabel(new ImageIcon(picture.getBufferedImage()));
		panel.add(label, BorderLayout.CENTER);
		pack();
		////panel.setBackground(Color.CYAN);
		////add(panel);
		////panel.getGraphics().drawImage(picture.getBufferedImage(), 60, 60, Graphics);
		////panel.getGraphics().drawImage
	}
	
	public static void initialisationFail() 
	{
		viewMessage("Ошибка", "Произошла ошибка при инициализации программы. Повреждены вспомогательные файлы приложения.");
	}
	
	private static void viewMessage(String title, String text)
	{
		JOptionPane.showMessageDialog(new JFrame(), text, title, JOptionPane.ERROR_MESSAGE);
	}
	
	private JMenu createMenuItem(InfoMenuItem item) 
	{
		JMenu newItem = new JMenu(item.getName());
		
		if (item.getChildren().isEmpty())
		{
			JButton button = new JButton();
			//button.addActionListener(item.getListener());
			button.addMouseListener(item.getListener());
			System.out.println(item.getPicture());
			ImageIcon image = new ImageIcon(getClass().getResource(item.getPicture()));
			
			button.setIcon(new ImageIcon(image.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));;
			toolBar.add(button);
			//newItem.addActionListener(item.getListener());
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
