package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dao.entities.Creator;
import ma.xproce.videoservice.dao.repositories.CreatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorManager implements CreatorService {
    private final CreatorRepository creatorRepository;

    public CreatorManager(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }

    @Override
    public List<Creator> findAll() {
        return creatorRepository.findAll();
    }

    @Override
    public Creator findById(Long id) {
        return creatorRepository.findById(id).orElse(null);
    }

    @Override
    public Creator save(Creator creator) {
        return creatorRepository.save(creator);
    }

    @Override
    public Creator update(Long id, Creator creator) {
        creator.setId(id);
        return creatorRepository.save(creator);
    }

    @Override
    public void delete(Long id) {
        creatorRepository.deleteById(id);
    }
}
