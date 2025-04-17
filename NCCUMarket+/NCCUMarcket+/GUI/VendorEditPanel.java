import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VendorEditPanel extends JPanel {
    public VendorEditPanel(MainFrame frame) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("攤販資料建⽴/更新", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));

        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        JTextField stallIdField = new JTextField("87");
        JTextField nameField = new JTextField("⾼也椰薑餅屋");

        JCheckBox eatTag = new JCheckBox("好吃", true);
        JCheckBox drinkTag = new JCheckBox("好喝", true);
        JCheckBox cultureTag = new JCheckBox("⽂創");
        JCheckBox fashionTag = new JCheckBox("穿搭時尚");
        JCheckBox otherTag = new JCheckBox("其他");

        JTextArea promoArea = new JTextArea("歡迎來⾼爺爺的攤位買薑餅⼈!\nhttp://.com");
        JTextField contactField = new JTextField("0912345678");
        JCheckBox mobilePay = new JCheckBox("是否⽀援⾏動⽀付", true);

        formPanel.add(new JLabel("攤位編號："));
        formPanel.add(stallIdField);
        formPanel.add(new JLabel("名稱："));
        formPanel.add(nameField);
        formPanel.add(new JLabel("攤販標籤："));

        JPanel tagPanel = new JPanel(new FlowLayout());
        tagPanel.add(eatTag);
        tagPanel.add(drinkTag);
        tagPanel.add(cultureTag);
        tagPanel.add(fashionTag);
        tagPanel.add(otherTag);
        formPanel.add(tagPanel);

        formPanel.add(new JLabel("⽂宣內容/連結："));
        formPanel.add(new JScrollPane(promoArea));
        formPanel.add(new JLabel("聯絡⽅式："));
        formPanel.add(contactField);
        formPanel.add(new JLabel("付款⽅式："));
        formPanel.add(mobilePay);

        JButton submitBtn = new JButton("建⽴/更新");
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(VendorEditPanel.this, "資料已更新 (實際儲存功能尚未實作)");
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(submitBtn);

        add(title, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
