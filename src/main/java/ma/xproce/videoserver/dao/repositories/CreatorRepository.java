package ma.xproce.videoserver.dao.repositories;

import ma.xproce.videoserver.dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator,Long> {
}
