package maks.core.repo;


import maks.core.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    Set<User> findAll();
}
