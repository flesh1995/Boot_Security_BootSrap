package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("select u from User u where u.email =:email")
//    Optional<User> findByUserEmail(String email);
    @Query("Select u from User u left join fetch u.roles where u.email=:email")
    User findByUserEmail(String email);
}
