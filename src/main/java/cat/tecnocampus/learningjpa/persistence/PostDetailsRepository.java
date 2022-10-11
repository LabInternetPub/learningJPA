package cat.tecnocampus.learningjpa.persistence;

import cat.tecnocampus.learningjpa.domainEtities.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDetailsRepository extends JpaRepository<PostDetails, Long> {
}
