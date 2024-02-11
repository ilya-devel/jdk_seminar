package homework;

import javax.swing.*;
import java.awt.*;

public class ClientGUI extends JFrame {
    //    Window size and position
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    //    Main elements on window
    private final JTextArea log = new JTextArea();


    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("Anonymous");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");


    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private ServerWindow serverWindow;
    private boolean statusConnect;

    ClientGUI(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        btnLogin.addActionListener(e -> {
            if (serverWindow.isServerWorking) {
                String lastMessages = serverWindow.connectClient(this);
                panelTop.setVisible(false);
                log.append("Connect is successful\n");
                log.append(lastMessages);
            } else {
                log.append("Error connect\n");
            }
        });

        btnSend.addActionListener(e -> {
//            String msg = serverWindow.getMessage(tfLogin.getText(), tfMessage.getText());
            serverWindow.getMessage(tfLogin.getText(), tfMessage.getText());
            tfMessage.setText("");
        });

        setAlwaysOnTop(true);
        setVisible(true);
    }

    public String getUsername() {
        return tfLogin.getText();
    }

    public void closeConnect() {
        panelTop.setVisible(true);
        log.append("Close connect\n");
    }
    public void receiveNewMessage (String msg) {
        log.append(msg);
    }
}
