package project.webshop.unit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import project.webshop.domain.User;
import project.webshop.repository.UserRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager entityManager;

    // test find all
    @Test
    public void check_todo_count() {
        assertEquals(3, userRepository.count());
    }

    // test
    @Test
    public void findOne() {
        Optional<User> user = userRepository.findById(101L);
        assertEquals("Todo Desc 1", user.get().getDescription());
    }
    // user exist
    @Test
    public void exists() {
        assertFalse(todoRepository.existsById(105L));
        assertTrue(todoRepository.existsById(101L));
    }

    // delete user by id
    @Test
    public void delete() {
        todoRepository.deleteById(101L);
        assertEquals(2,todoRepository.count());
    }



    // delete all user
    @Test
    public void deleteAll() {
        todoRepository.deleteAll();
        assertEquals(0,todoRepository.count());
    }


    // create new user
    @Autowired
    TestEntityManager entityManager;
    @Test
    public void save() {
        Todo todo = todoRepository.findById(101L).get();
        todo.setDescription("Todo Desc Updated");
        todoRepository.save(todo);
        entityManager.flush();
        Todo updatedTodo = todoRepository.findById(101L).get();
        assertEquals("Todo Desc Updated",updatedTodo.getDescription());
    }

    // for PagingAndSortingRepository
    @Test
    public void testing_sort_stuff() {
        Sort sort = new Sort(Sort.Direction.DESC, "name")
                .and(new Sort(Sort.Direction.ASC, "userid"));
        Iterable<User> users = userRepository.findAll(sort);
        for (User user : users) {
            System.out.println(user);
        }
    }
    // pageable
    @Test
    public void using_pageable_stuff() {
        PageRequest pageable = new PageRequest(0, 2);
        Page<User> userPage = userRepository.findAll(pageable);
        System.out.println(userPage);
        System.out.println(userPage.getContent());
    }
}
