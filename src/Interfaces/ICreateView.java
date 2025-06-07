package Interfaces;

public interface ICreateView<M> {
    void setTaoListener(java.awt.event.ActionListener listener);
    javax.swing.JFrame getFrame();

    M buildModel(); // Trả về đối tượng M (Actor, Category...)
    boolean validateInput(); // Để gọi InputValidate
}

