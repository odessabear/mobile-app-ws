package com.amikhailov.springstudying.mobileappws.ui.controller;

import com.amikhailov.springstudying.mobileappws.ui.model.UserRest;
import com.amikhailov.springstudying.mobileappws.ui.model.request.UserDetailsRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("users")
public class UserController {

    Map<String, UserRest> users;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get user was called with page = " + page + " and with limit = " + limit + " and sort = " + sort;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

//        UserRest returnValue = new UserRest();
//
//        returnValue.setFirstName("Alex");
//        returnValue.setLastName("Mikhailov");
//        returnValue.setEmail("myEmail@test.com");

        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();

        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }


    @PutMapping
    public String updateUser() {
        return "update user was called";
    }


    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
