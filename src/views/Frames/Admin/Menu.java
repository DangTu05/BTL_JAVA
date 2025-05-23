package views.Frames.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interfaces.IHomeNavigableView;
import Interfaces.IMenuView;
import components.SideBarMenu;
import controllers.admin.MenuController;
import utils.UrlUtil;

import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;

public class Menu extends JFrame implements IMenuView {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private SideBarMenu sidebar;
	private CardLayout cardLayout;
	private JPanel mainContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 604);
		setSize(970, 604);  // Cửa sổ to hơn
		setLocationRelativeTo(null);  // Ở giữa màn hình
		cardLayout = new CardLayout();
		mainContent = new JPanel(cardLayout);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// Tạo sidebar
		sidebar = new SideBarMenu();
		sidebar.getBtnLogout().setSize(255, 53);
		sidebar.getBtnLogout().setLocation(0, 503);
		contentPane.add(sidebar, BorderLayout.WEST);
		contentPane.add(mainContent, BorderLayout.CENTER);

	}

	public SideBarMenu getSideBar() {
		return sidebar;
	}

	public JPanel getMainContentJpanel() {
		return mainContent;
	}

	public JFrame getFrame() {
		return this;
	}
}
