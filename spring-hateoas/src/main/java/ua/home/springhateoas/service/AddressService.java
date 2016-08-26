package ua.home.springhateoas.service;

import org.springframework.stereotype.Service;
import ua.home.springhateoas.dto.Address;

import java.util.Arrays;
import java.util.List;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@Service
public class AddressService {

    public Address getAddressById(String id) {
        switch (id) {
            case "1":
                return new Address("1", "Broadway", "11");
            case "2":
                return new Address("2", "Red sq", "22");
            case "3":
                return new Address("3", "Mira", "33");
            default:
                return null;
        }
    }

    public List<Address> getAddresses() {
        return Arrays.asList(new Address("1", "Broadway", "11"), new Address("2", "Red sq", "22"), new Address("3", "Mira", "33"));
    }
}
