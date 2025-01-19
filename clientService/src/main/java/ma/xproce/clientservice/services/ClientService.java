package ma.xproce.clientservice.services;

import ma.xproce.clientservice.models.Client;
import ma.xproce.clientservice.repositories.Clientrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private Clientrepository clientRepository;

    public List<Client> getAllClients() {
        return (List<Client>)clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
