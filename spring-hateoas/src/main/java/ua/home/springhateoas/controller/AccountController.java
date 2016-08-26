package ua.home.springhateoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.home.springhateoas.dto.Account;
import ua.home.springhateoas.service.AccountService;

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
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "account/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Resource<Account>> getAccountById(@PathVariable("id") String id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(new Resource<>(account,
                linkTo(methodOn(AccountController.class).getAccounts()).withSelfRel()));
    }

    @RequestMapping(value = "accounts", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Resources<Resource<String>>> getAccounts() {
        List<Resource<String>> accounts = accountService.getAccounts().stream().map(account ->
                new Resource<>(account.getNumber(), linkTo(methodOn(AccountController.class).getAccountById(account.getId())).withSelfRel()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new Resources<>(accounts, linkTo(methodOn(AccountController.class).getAccounts()).withSelfRel()));
    }
}
