package cat.tecnocampus.learningjpa.domainEtities.dtos;

import java.util.List;

public interface PostDTO {
    Long getId();

    String getTitle();

    List<PostCommentDTO> getPostComments();

    List<TagDTO> getTags();
}
