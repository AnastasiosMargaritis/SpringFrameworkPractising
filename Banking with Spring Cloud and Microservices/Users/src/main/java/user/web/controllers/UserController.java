package user.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import user.services.UserService;
import user.web.model.UserDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;

    @GetMapping
    @RequestMapping("new")
    public ResponseEntity<UserDto> createNewUser(@RequestBody @Validated UserDto userDto, @RequestParam String countryCode){
        return new ResponseEntity<>(userService.createNewUser(userDto, countryCode), HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping("delete")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        return ResponseEntity.accepted().body("Successfully deleted.");
    }
}
