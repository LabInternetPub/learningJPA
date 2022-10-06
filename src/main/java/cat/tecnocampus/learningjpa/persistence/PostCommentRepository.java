package cat.tecnocampus.learningjpa.persistence;

import cat.tecnocampus.learningjpa.domainEtities.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
