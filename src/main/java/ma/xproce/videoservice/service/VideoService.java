package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dao.entities.Video;

import java.util.List;

public interface VideoService {
    List<Video> findAll();
    Video findById(Long id);
    Video save(Video video);
    Video update(Long id, Video video);
    void delete(Long id);
}

