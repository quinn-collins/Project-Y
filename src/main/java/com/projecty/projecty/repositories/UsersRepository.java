package com.projecty.projecty.repositories;

import com.projecty.projecty.entities.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {

    List<Users> findByLastName(String lastName);
}
