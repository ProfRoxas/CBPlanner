package hu.elte.CbPlanner.security;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.elte.CbPlanner.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}