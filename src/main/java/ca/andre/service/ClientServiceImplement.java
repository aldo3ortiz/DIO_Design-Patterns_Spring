package ca.andre.service;

import ca.andre.model.Address;
import ca.andre.model.AddressRepository;
import ca.andre.model.Client;
import ca.andre.model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClientServiceImplement implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ZipService zipService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findByID(int id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
      saveClientZipcode(client);
    }

    @Override
    public void update(int id, Client client) {
        Optional<Client> clientDB = clientRepository.findById(id);
        if(clientDB.isPresent()){
           saveClientZipcode(client);
        }
    }

    @Override
    public void delete(int id) {
        clientRepository.deleteById(id);
    }

    private void saveClientZipcode(Client client){
        String zip = client.getAddress().getZip();
        Address address = addressRepository.findById(zip).orElseGet(() -> {
            Address newAddress = zipService.searchZip(zip);
            addressRepository.save(newAddress);
            return null;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
