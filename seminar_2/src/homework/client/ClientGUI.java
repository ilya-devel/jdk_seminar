package homework.client;

import homework.server.Server;
import homework.server.ServerWindow;

import javax.swing.*;
import java.awt.*;

public class ClientGUI extends JFrame implements View {
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

    private Server server;
    private Client client;

    public ClientGUI(ServerWindow server) {
        this.server = server.getServer();


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
            if (this.server.isServerStatus()) {
                panelTop.setVisible(false);
                this.client = new Client(getUsername(), this, this.server);
                server.connectClient(this.client);
                openConnect();
            } else {
                log.append("Error connect\n");
            }
        });

        btnSend.addActionListener(e -> {
            server.getMessage(tfLogin.getText(), tfMessage.getText());
            tfMessage.setText("");
        });

        setAlwaysOnTop(true);
        setVisible(true);
    }

    public String getUsername() {
        return tfLogin.getText();
    }

    @Override
    public void closeConnect() {
        panelTop.setVisible(true);
        log.append("\nClose connect\n");
    }

    @Override
    public void receiveMessage(String message) {
        log.append(message);
    }

    @Override
    public void openConnect() {
        log.append("\nConnect is successful\n");
    }

    @Override
    public String getName() {
        return tfLogin.getText();
    }
}
