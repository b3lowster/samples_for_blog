package ua.home.springhateoas.service;

import org.springframework.stereotype.Service;
import ua.home.springhateoas.dto.Client;

import java.util.Arrays;
import java.util.List;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@Service
public class ClientService {

    private static final List<Client> CLIENT_RESOURCEs = Arrays.asList(new Client("1", "Jhon", "Doe", "1", "1"),
            new Client("2", "Larry", "King", "2", "2")
            , new Client("3", "Jhon", "Snow", "3", "3"));

    public List<Client> getClients(){
        return CLIENT_RESOURCEs;
    }
    public Client getClient(String id){
        return CLIENT_RESOURCEs.stream().filter(client -> client.getId().equals(id)).findFirst().get();
    }
}
