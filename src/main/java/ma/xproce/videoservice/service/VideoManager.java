package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dao.entities.Video;
import ma.xproce.videoservice.dao.repositories.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoManager implements VideoService {
    //or i can simply do @autowired to generate automattically an instance of videorepository
    private final VideoRepository videoRepository;

    public VideoManager(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Video findById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video update(Long id, Video video) {
        video.setId(id);
        return videoRepository.save(video);
    }

    @Override
    public void delete(Long id) {
        videoRepository.deleteById(id);
    }
}
