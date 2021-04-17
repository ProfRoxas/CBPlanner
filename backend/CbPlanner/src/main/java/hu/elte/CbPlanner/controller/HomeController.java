package hu.elte.CbPlanner.controller;

import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.elte.CbPlanner.entities.User;
import hu.elte.CbPlanner.security.UserRepository;

@RestController
public class HomeController /* implements ErrorController */{

    private final UserRepository repository;

    // @RequestMapping("/error")
    // public String displayError() {
    //     return "kek";
    // }

    HomeController(UserRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/myself")
    public Principal currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if(principal == null) return null;
        return principal;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return repository.findAll();
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user with specified ID had been found.");
        }
        return user.get();
    }

    // @Override
    // public String getErrorPath() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }
}
