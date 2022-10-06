package cat.tecnocampus.learningjpa.persistence;

import cat.tecnocampus.learningjpa.domainEtities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleContainsIgnoreCase(String title);

    List<Post> findByCreationDateLessThanEqual(LocalDateTime creationDate);

    List<Post> findByPostComments_ReviewContainsIgnoreCase(String review);

    List<Post> findDistinctByPostComments_ReviewContainsIgnoreCase(String review);

    @Query("""
            select p from Post p inner join p.postComments postComments
            where upper(p.title) like upper(concat('%', ?1, '%')) and upper(postComments.review) like upper(concat('%', ?2, '%'))""")
    List<Post> findByTitleAndReview(String title, String review);


}