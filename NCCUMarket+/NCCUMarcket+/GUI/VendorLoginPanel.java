import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VendorLoginPanel extends JPanel {
    public VendorLoginPanel(MainFrame frame) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("攤販登入介面", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel idLabel = new JLabel("攤位編號：");
        JTextField idField = new JTextField();
        JLabel passwordLabel = new JLabel("攤位密碼：");
        JPasswordField passwordField = new JPasswordField();

        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        JButton loginBtn = new JButton("登入");
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                
                if (id.trim().isEmpty() || password.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(VendorLoginPanel.this, "請輸入完整的編號與密碼！");
                } else {
                    frame.switchTo("VendorEdit");
                }
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(loginBtn);

        add(title, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}

