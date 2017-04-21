package maks.core.repo;

import maks.core.Clothes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepo extends CrudRepository<Clothes, Long> {
}
