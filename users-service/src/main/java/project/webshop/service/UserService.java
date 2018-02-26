package project.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.webshop.domain.User;
import project.webshop.repository.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;



    // get all users

    public List<User> findAll() {
        return userRepository.findAll();
    }

    // get one user by id
    @Cacheable("user")
    public Optional<User> findOne(Long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    // create new user
    public User save(User user) {
        return userRepository.save(user);
    }

    // detele one user / admin
    public void delete(Long id) {
        userRepository.delete(id);
    }


}
