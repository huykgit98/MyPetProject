package maks.core.repo;

import maks.core.GroupInvitation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupInvitationRepo extends CrudRepository<GroupInvitation, Long> {
}
