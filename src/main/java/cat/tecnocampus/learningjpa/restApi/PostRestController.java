package cat.tecnocampus.learningjpa.restApi;

import cat.tecnocampus.learningjpa.domainEtities.Post;
import cat.tecnocampus.learningjpa.domainEtities.PostComment;
import cat.tecnocampus.learningjpa.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostRestController {
    private ApplicationService applicationService;

    public PostRestController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return applicationService.getPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        return applicationService.getPostById(id);
    }

    @GetMapping("/posts/{id}/string")
    public String getPostByIdString(@PathVariable Long id) {
        return applicationService.getPostById(id).toString();
    }

    @GetMapping("/posts/{id}/postComments/{cid}")
    public PostComment getPostByIdComment(@PathVariable Long id, @PathVariable Long cid) {
        return applicationService.getPostById(id).getPostComments().get(cid.intValue());
    }

    @GetMapping("/posts/{id}/postComments2/{cid}")
    public PostComment getPostByIdComment2(@PathVariable Long id, @PathVariable Long cid) {
        Post post = applicationService.getPostById(id);
        System.out.println("Going to look for PostComment");
        return post.getPostComments().get(cid.intValue());
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        applicationService.deletePost(id);
    }

    @DeleteMapping("/posts/{pid}/postComments/{cid}")
    public void deletePostComment(@PathVariable Long pid, @PathVariable Long cid) {
        applicationService.deletePostComment(pid, cid);
    }

    @GetMapping("/postComments")
    public List<PostComment> getPostComments() {
        return applicationService.getPostComments();
    }

    @PutMapping("/posts/{id}/postComments")
    public void addSomePostCommentsToPost(@PathVariable Long id) {
        applicationService.addSomePostsCommentsToPost(id);
    }
}
