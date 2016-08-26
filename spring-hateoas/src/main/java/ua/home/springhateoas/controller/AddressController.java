package ua.home.springhateoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.home.springhateoas.dto.Address;
import ua.home.springhateoas.service.AddressService;

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
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "address/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Resource<Address>> getAddressById(@PathVariable("id") String id) {
        Address address = addressService.getAddressById(id);
        return ResponseEntity.ok(new Resource<>(address,
                linkTo(methodOn(AddressController.class).getAddresses()).withSelfRel()));
    }

    @RequestMapping(value = "addresses", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Resources<Resource<String>>> getAddresses() {
        List<Resource<String>> addresses = addressService.getAddresses().stream().map(address ->
                new Resource<>(String.format("%s, %s", address.getStreet(), address.getApt()), linkTo(methodOn(AddressController.class).getAddressById(address.getId())).withSelfRel()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new Resources<>(addresses, linkTo(methodOn(AccountController.class).getAccounts()).withSelfRel()));
    }
}
