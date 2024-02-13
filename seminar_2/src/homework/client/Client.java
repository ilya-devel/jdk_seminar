package homework.client;

import homework.server.Server;

public class Client {
    private String name;
    private Server server;

    private ClientGUI gui;

    public Client(String name, ClientGUI gui, Server server) {
        this.name = name;
        this.server = server;
        this.gui = gui;
    }

    public void closeConnect() {
        gui.closeConnect();
    }

    public String getName() {
        return this.name;
    }

    public void receiveNewMessage(String s) {
        gui.receiveMessage(s);
    }
}
