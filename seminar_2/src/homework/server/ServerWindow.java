package homework.server;

import homework.client.Client;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame implements View {
    //    Window size and position
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    //    Main elements on window
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();

    // Server
    private Server server;

    public ServerWindow() {
        server = new Server(this);

        btnStop.addActionListener(e -> {
            if (server.isServerStatus()) {
                server.setServerStatus(false);
                log.append("Server stopped\n");
                server.clearLstClients();
            } else {
                log.append("Server is not running\n");
            }
        });

        btnStart.addActionListener(e -> {
            if (!server.isServerStatus()) {
                server.setServerStatus(true);
                log.append("Server is running\n");
            } else {
                log.append("Server is not stopping\n");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);

        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        btnPanel.add(btnStart);
        btnPanel.add(btnStop);
        add(log);
        add(btnPanel, BorderLayout.SOUTH);

        setAlwaysOnTop(true);
        setVisible(true);
    }

    @Override
    public void connectClient(Client client) {
        this.server.addClient(client);
        log.append(client.getName() + " connected\n");
    }

    @Override
    public void getMessage(String login, String message) {
        String msg = server.transitMessage(login, message);
        log.append(msg);
    }

    public Server getServer() {
        return server;
    }
}

