package cat.tecnocampus.learningjpa.domainEtities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "PostDetails")
@Table(name = "post_details")
public class PostDetails {

    @Id
    //Not Generated
    private Long id;

    @Column(name = "valid_until")
    private LocalDate validUntil;

    @Column(name = "created_by")
    private String createdBy;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Post post;

    public PostDetails() {}

    public PostDetails(String createdBy) {
        validUntil = LocalDate.now().plusMonths(2);
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
