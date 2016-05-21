
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame implements ActionListener {

    private JButton sendButton;
    private JButton receiveButton;

    public Main() throws IOException {
        // frames attributes
        setBackground(new Color(170, 111, 236));
        setTitle("LAN File Transfer");
        setSize(350, 250);

        setVisible(true);
        getContentPane().setBackground(new Color(170, 111, 236));
        setLayout(null); // no layout is set(instead bound is used)
        setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 175,
                (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Files.createDirectories(Paths.get(System.getProperty("user.home") + "\\Documents\\LAN File Transfer\\"));

        // declarations
        sendButton = new JButton("Send");
        receiveButton = new JButton("Receive");
        (new JLabel("Select File and Start Server")).setForeground(Color.WHITE);

        add(sendButton);
        add(receiveButton);

        sendButton.setBounds(115, 50, 100, 50);
        receiveButton.setBounds(115, 135, 100, 50);
        setFont(new Font("Times new roman", Font.PLAIN, 20), sendButton,
                receiveButton);

        // defining actionlistener
        sendButton.addActionListener(this);
        receiveButton.addActionListener(this);

    }// constructor closed

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            new Server().setVisible(true);
            dispose();
        } else if (e.getSource() == receiveButton) {
            new Client().setVisible(true);
            dispose();
        }
    }

    private void setFont(Font f, JComponent... c) {
        for (JComponent C : c) {
            C.setFont(f);
        }
    }

    public static void main(String args[]) throws IOException {
        new Main().setVisible(true);
    }
}// class closed

