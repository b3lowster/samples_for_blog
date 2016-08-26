package ua.home.springhateoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.home.springhateoas.dto.Client;
import ua.home.springhateoas.service.ClientService;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@RestController
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "clients", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Resources<Resource<String>>> getClients() {
        List<Resource<String>> clients = clientService.getClients().stream().map(client ->
                new Resource<>(client.getFirstName(), linkTo(methodOn(ClientController.class).getClientById(client.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(new Resources<>(clients, linkTo(methodOn(ClientController.class).getClients()).withSelfRel()));
    }

    @RequestMapping(value = "client/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Resource<Client>> getClientById(@PathVariable("id") String id) {
        Client client = clientService.getClient(id);
        return ResponseEntity.ok(new Resource<>(client,
                linkTo(methodOn(AddressController.class).getAddressById(client.getAddressId())).withSelfRel(),
                linkTo(methodOn(AccountController.class).getAccountById(client.getAccountId())).withSelfRel()));
    }
}
