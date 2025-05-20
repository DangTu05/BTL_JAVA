package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.HomeController;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuItem jMenuItem_Thoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		HomeController homeController=new HomeController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu jMenu_Option = new JMenu("Options");
		jMenu_Option.setBorder(new LineBorder(Color.BLACK, 1)); // Đặt viền 
		menuBar.add(jMenu_Option);
		
		JMenuItem jMenuItem_DangKi = new JMenuItem("Đăng Kí");
		jMenu_Option.add(jMenuItem_DangKi);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Đăng Nhập");
		jMenu_Option.add(mntmNewMenuItem);
		
		jMenuItem_Thoat = new JMenuItem("Thoát");
		jMenuItem_Thoat.addActionListener(homeController);
		menuBar.add(jMenuItem_Thoat);
		
	}
	public void thoatChuongTrinh() {
		int luachon=JOptionPane.showConfirmDialog(this,  "Bạn có muốn thoát khỏi chương trình?",
		        "Exit",JOptionPane.YES_NO_OPTION);
		if(luachon==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void setThoatListener(ActionListener listener) {
	}

}
