package cat.tecnocampus.learningjpa.domainEtities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "post",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostComment> postComments = new ArrayList<>();

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PostDetails details;

    public Post() {
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<PostComment> postComments) {
        this.postComments = postComments;
    }

    public void addPostComment(PostComment comment) {
        this.postComments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(PostComment comment) {
        this.postComments.remove(comment);
        comment.setPost(null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
        tag.addPost(this);
    }

    public void setDetails(PostDetails details) {
        if (details == null) {
            if (this.details != null) {
                this.details.setPost(null);
            }
        }
        else {
            details.setPost(this);
        }
        this.details = details;
    }

    //with bidirectional postDetails are selected even getPostDetails doesn't exist
    public PostDetails getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Post))
            return false;

        Post other = (Post) o;

        return id != null &&
                id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}