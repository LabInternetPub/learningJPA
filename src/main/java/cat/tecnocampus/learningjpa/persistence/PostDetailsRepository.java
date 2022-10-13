package cat.tecnocampus.learningjpa.persistence;

import cat.tecnocampus.learningjpa.domainEtities.PostDetails;
import cat.tecnocampus.learningjpa.domainEtities.dtos.PostDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostDetailsRepository extends JpaRepository<PostDetails, Long> {

    List<PostDetailsDTO> findByIdGreaterThanEqual(Long id);
}
