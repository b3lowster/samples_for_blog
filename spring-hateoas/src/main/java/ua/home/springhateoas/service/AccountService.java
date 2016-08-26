package ua.home.springhateoas.service;

import org.springframework.stereotype.Service;
import ua.home.springhateoas.dto.Account;

import java.util.Arrays;
import java.util.List;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@Service
public class AccountService {

    public Account getAccountById(String id) {
        switch (id) {
            case "1":
                return new Account("1", "Social", "260098");
            case "2":
                return new Account("2", "Current", "260090");
            case "3":
                return new Account("3", "Retirement", "261092");
            default:
                return null;
        }
    }

    public List<Account> getAccounts() {
        return Arrays.asList(new Account("1", "Social", "260098"), new Account("2", "Current", "260090"),
                new Account("3", "Retirement", "261092"));
    }
}
