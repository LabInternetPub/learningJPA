package cat.tecnocampus.learningjpa.service;

import cat.tecnocampus.learningjpa.domainEtities.Post;
import cat.tecnocampus.learningjpa.domainEtities.PostComment;
import cat.tecnocampus.learningjpa.persistence.PostCommentRepository;
import cat.tecnocampus.learningjpa.persistence.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ApplicationService {
    private PostRepository postRepository;
    private PostCommentRepository postCommentRepository;

    public ApplicationService(PostRepository postRepository, PostCommentRepository postCommentRepository) {
        this.postRepository = postRepository;
        this.postCommentRepository = postCommentRepository;
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> {return new RuntimeException("Post " + id + " doesn't exist");});
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public List<PostComment> getPostComments() {
        return postCommentRepository.findAll();
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public void deletePostComment(Long id, Long cid) {
        postRepository.findById(id).orElseThrow(() -> {return new RuntimeException("Post " + id + " doesn't exist");})
                .getPostComments().remove(cid.intValue());
    }

    @Transactional
    public void addSomePostsCommentsToPost(Long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(() -> {return new RuntimeException("Post " + post_id + " doesn't exist");});
        post.getPostComments().add(new PostComment("One post comment"));
        post.getPostComments().add(new PostComment("Another post comment"));
    }
}
