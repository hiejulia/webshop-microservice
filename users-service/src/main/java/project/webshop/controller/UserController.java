package project.webshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.webshop.config.exception.NotFoundException;
import project.webshop.domain.User;
import project.webshop.service.UserService;


import java.util.List;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/{id}")
    public User findOne(@PathVariable Long id) {
        return userService.findOne(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        user.setId(null);
        return userService.save(user);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, User user) {
        userService.save(user);
    }

    // admin
    @DeleteMapping(path = "/{id}/admin")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}