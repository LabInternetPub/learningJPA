package cat.tecnocampus.learningjpa.persistence;

import cat.tecnocampus.learningjpa.domainEtities.Post;
import cat.tecnocampus.learningjpa.domainEtities.dtos.PostDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    <T> List<T> findBy(Class<T> type);

    <T> Optional<T> findById(Long id, Class<T> type);

    <T> List<T> findByIdGreaterThanEqual(Long id, Class<T> type);

    List<Post> findByTitleContainsIgnoreCase(String title);

    List<Post> findByCreationDateLessThanEqual(LocalDateTime creationDate);

    List<Post> findByPostComments_ReviewContainsIgnoreCase(String review);

    List<Post> findDistinctByPostComments_ReviewContainsIgnoreCase(String review);

    @Query("""
            select p from Post p inner join p.postComments postComments
            where upper(p.title) like upper(concat('%', ?1, '%')) and upper(postComments.review) like upper(concat('%', ?2, '%'))""")
    List<Post> findByTitleAndReview(String title, String review);


}