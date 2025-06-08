package views.Panels.Admin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import Interfaces.IDashBoard;

public class Dashboard extends JPanel implements IDashBoard {

	private static final long serialVersionUID = 1L;
	private JFreeChart barChart;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JFrame frame = new JFrame("Dashboard");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setBounds(100, 100, 949, 604);
				frame.setLocationRelativeTo(null);

				Dashboard dashboardPanel = new Dashboard();
				frame.setContentPane(dashboardPanel);

				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Dashboard() {
		setBounds(100, 100, 696, 604);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("DashBoard");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Source Code Pro", Font.BOLD, 20));
		lblNewLabel.setBounds(277, 22, 170, 32);
		add(lblNewLabel);
	}

	public void createChart(DefaultCategoryDataset dataset) {
		// Tạo biểu đồ cột
		barChart = ChartFactory.createBarChart("Thống kê doanh thu theo tháng", "Tháng", "Số tiền (VND)", dataset);

		// Tạo ChartPanel để hiển thị biểu đồ
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setBounds(10, 190, 429, 350); // set kích thước và vị trí
		add(chartPanel);
	}
}
