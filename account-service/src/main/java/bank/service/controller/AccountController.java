package bank.service.controller;

import bank.service.exception.AccountNotFoundException;
import bank.service.model.Account;
import bank.service.service.IAccountService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/accounts")
@Api(value = "Account API")
@AllArgsConstructor
public class AccountController {

    /*@Autowired
    IAccountResquestService iAccountRequestService;*/
    @Autowired
    IAccountService iAccountService;

/*    @PostMapping("/fillOutAccountReuqest")
    @ResponseStatus(HttpStatus.OK)
    public void fillOutAccountReuqest(@RequestBody AccountRequest accountRequest){
        iAccountRequestService.fillOutAccountReuqest(accountRequest);
    }

    @PostMapping("/approveAccountRequest")
    void approveAccountRequest(@RequestBody CustomerAccount customerAccount) {
        iAccountRequestService.approveAccountRequest(customerAccount);
    }*/


    @GetMapping(value = "/getAccount/{id}")
    public ResponseEntity getAccount(@PathVariable Long id) {
        Optional<Account> account = iAccountService.getAccountById(id);
        if(!account.isPresent())
            return ResponseEntity.badRequest().body("Account doesn't exist");
        return ResponseEntity.status(HttpStatus.OK).body(account.get());
    }

    @GetMapping(value = "/listAccounts")
    public ResponseEntity listAccounts() {
        List<Account> accounts = new ArrayList<>();
        try {
            accounts = iAccountService.getAllAccounts();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(accounts);
    }

    @PostMapping(value = "/addAccount" , produces = "application/json; charset=utf-8")
    public ResponseEntity addAccount(@RequestBody Account account) {
        Account accountPostSave = null;
        try {
            accountPostSave = iAccountService.addAccount(account);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(accountPostSave);
    }

    @PutMapping(value = "/updateAccount/{id}")
    public ResponseEntity updateAccount(@RequestBody Account account, @PathVariable Long id) {
        Account accountPostSave = null;
        try {
            accountPostSave = iAccountService.updateAccount(account, id);
        } catch (Exception | AccountNotFoundException ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountPostSave);
    }

    @DeleteMapping(value = "/deleteAccount/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        try {
            iAccountService.deleteAccount(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Account deleted");
    }

}
