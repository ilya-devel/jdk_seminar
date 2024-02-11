package homework;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;

public class ServerWindow extends JFrame {
    //    Window size and position
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    //    Main elements on window
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();
    public boolean isServerWorking;
    private String FILE_LOG = "Log.txt";

    private LinkedList<ClientGUI> clients = new LinkedList<>();


    ServerWindow() {
        isServerWorking = false;

        btnStop.addActionListener(e -> {
            if (isServerWorking) {
                isServerWorking = false;
                log.append("Server stopped\n");
                for (ClientGUI client: clients) {
                    client.closeConnect();
                }
                clients.clear();
            } else {
                log.append("Server is not running\n");
            }
        });

        btnStart.addActionListener(e -> {
            if (!isServerWorking) {
                isServerWorking = true;
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

    public String connectClient(ClientGUI client) {
        log.append(client.getUsername() + " connected\n");
        clients.add(client);
        String logMsg = readLog();
        if (!logMsg.isEmpty()) {
            return logMsg;
        } else return "";

    }

    public void getMessage(String login, String msg) {
        String getMsg = login + ": " + msg + "\n";
        log.append(getMsg);
        writeLog(getMsg);
        for (ClientGUI client: clients) {
            client.receiveNewMessage(getMsg);
        }
    }

    private void writeLog(String msg) {
        try (FileWriter fileWriter = new FileWriter(FILE_LOG, true)){
            fileWriter.write(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readLog() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(FILE_LOG))) {
            StringBuilder messages = new StringBuilder();
            String row;
            while ((row = fileReader.readLine()) != null) {
                messages.append(row + "\n");
            }
            return messages.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
