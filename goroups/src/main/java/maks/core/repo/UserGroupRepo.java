package maks.core.repo;

import maks.core.UserGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepo extends CrudRepository<UserGroup, Long> {
}
