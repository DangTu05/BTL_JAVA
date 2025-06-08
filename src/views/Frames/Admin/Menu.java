package views.Frames.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interfaces.IMenuView;
import components.SideBarMenu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;


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
