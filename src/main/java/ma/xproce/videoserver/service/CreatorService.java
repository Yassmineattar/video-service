package ma.xproce.videoserver.service;

import ma.xproce.videoserver.dao.entities.Creator;

import java.util.List;

public interface CreatorService {
    List<Creator> findAll();
    Creator findById(Long id);
    Creator save(Creator creator);
    Creator update(Long id, Creator creator);
    void delete(Long id);
}
