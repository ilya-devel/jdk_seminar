package homework.server;

import homework.client.Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Server {
    private boolean serverStatus;
    private String FILE_LOG;
    private LinkedList<Client> lstClients;

    private View window;

    public Server(ServerWindow window) {
        this.window = window;
        this.serverStatus = false;
        FILE_LOG = "Log.txt";
        lstClients = new LinkedList<>();
    }

    public boolean isServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(boolean serverStatus) {
        this.serverStatus = serverStatus;
    }

    public void addClient(Client client) {
        lstClients.add(client);
        String logMsg = readLog();
        if (!logMsg.isEmpty()) {
            client.receiveNewMessage(logMsg);
        } else {
            client.receiveNewMessage("");
        }
    }
    public void clearLstClients() {
        for (Client client: lstClients) {
            client.closeConnect();
        }
        this.lstClients.clear();
    }
    public String transitMessage(String login, String message) {
        String msg = login + ": " + message + "\n";
        writeLog(msg);
        for (Client client: lstClients) {
            client.receiveNewMessage(msg);
        }
        return msg;
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
