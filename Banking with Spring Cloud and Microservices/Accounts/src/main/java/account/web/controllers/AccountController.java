package account.web.controllers;

import account.domain.Account;
import account.domain.User;
import account.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account/")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @RequestMapping("new")
    public ResponseEntity<Account> createNewAccount(@RequestBody @Validated User userDto){
        return new ResponseEntity<>(accountService.generateNewAccount(userDto), HttpStatus.CREATED);
    }
}
