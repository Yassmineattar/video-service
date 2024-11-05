package ma.xproce.videoservice.web;

import ma.xproce.videoservice.dao.entities.Video;
import ma.xproce.videoservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping
    public String listVideos(Model model) {
        List<Video> videos = videoService.findAll();
        model.addAttribute("videos", videos);
        return "video/list"; // Assurez-vous d'avoir cette vue
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("video", new Video());
        return "video/add"; // Assurez-vous d'avoir cette vue
    }

    @PostMapping
    public String addVideo(@ModelAttribute Video video) {
        videoService.save(video);
        return "redirect:/videos"; // Redirige vers la liste des vidéos
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Video video = videoService.findById(id);
        model.addAttribute("video", video);
        return "video/edit"; // Assurez-vous d'avoir cette vue
    }

    @PostMapping("/edit/{id}")
    public String updateVideo(@PathVariable Long id, @ModelAttribute Video video) {
        videoService.update(id, video);
        return "redirect:/videos"; // Redirige vers la liste des vidéos
    }

    @GetMapping("/delete/{id}")
    public String deleteVideo(@PathVariable Long id) {
        videoService.delete(id);
        return "redirect:/videos"; // Redirige vers la liste des vidéos
    }
}
