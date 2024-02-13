package homework.server;

import homework.client.Client;

public interface View {
    void connectClient(Client client);

    void getMessage(String login, String message);
}
