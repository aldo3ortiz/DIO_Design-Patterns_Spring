package ca.andre.service;

import ca.andre.model.Client;

public interface ClientService {

    Iterable<Client> findAll();
    Client findByID(int id);

    void insert(Client client);
    void update(int id, Client client);
    void delete(int id);


}
