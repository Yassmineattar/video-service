package ma.xproce.videoserver.dao.repositories;

import ma.xproce.videoserver.dao.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Long> {
}
