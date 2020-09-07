package account.web.controllers;

import account.services.AccountService;
import account.web.model.AccountDto;
import account.web.model.UserDto;
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
    public ResponseEntity<AccountDto> createNewAccount(@RequestBody @Validated UserDto userDto){
        return new ResponseEntity<>(accountService.generateNewAccount(userDto), HttpStatus.CREATED);
    }
}
