package components;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileChooser extends JFrame {

	private static final long serialVersionUID = 1L;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileChooser frame = new FileChooser();
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
	public FileChooser() {
	}

	public static File showImageChooser(JFileChooser fileChooser, JLabel lblImg, File selectedFile, JFrame view) {
		// Thiết lập bộ lọc chỉ hiển thị file ảnh
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
			@Override
			public boolean accept(File f) {
				String name = f.getName().toLowerCase();
				return f.isDirectory() || name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")
						|| name.endsWith(".gif");
			}

			@Override
			public String getDescription() {
				return "Image Files (*.jpg, *.jpeg, *.png, *.gif)";
			}
		});
		int result = fileChooser.showOpenDialog(view);/// Hiển thị hộp thoại lên giữa cửa sổ
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			String imagePath = selectedFile.getAbsolutePath(); // Lưu đường dẫn

			// Hiển thị ảnh
			ImageIcon icon = new ImageIcon(imagePath);
			Image img = icon.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
			lblImg.setIcon(new ImageIcon(img));
			return selectedFile;
		}
		return null;
	}

}
