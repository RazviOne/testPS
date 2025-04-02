package ro.tuc.ds2020.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ro.tuc.ds2020.Ds2020TestConfig;
import ro.tuc.ds2020.dtos.PostDTO;
import ro.tuc.ds2020.dtos.PostDetailsDTO;

import static org.springframework.test.util.AssertionErrors.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/create.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/delete.sql")
public class PostServiceIntegrationTests extends Ds2020TestConfig {

    @Autowired
    private PostService postService;

    @Test
    public void testGetCorrect() {
        List<PostDTO> postDTOList = postService.findPosts();
        assertEquals("Test get all posts", 1, postDTOList.size());
    }

    @Test
    public void testInsertCorrectWithGetById() {
        PostDetailsDTO post = new PostDetailsDTO(
                null,
                1,  // idPerson (asociere)
                "Test Title",
                "Test content",
                LocalDateTime.now(),
                "draft",
                null,
                3,
                false
        );
        Integer insertedId = postService.insert(post);

        PostDetailsDTO expected = new PostDetailsDTO(
                insertedId,
                post.getIdPerson(),
                post.getTitle(),
                post.getText(),
                post.getDateCreated(),
                post.getStatus(),
                post.getImage(),
                post.getTotalVotes(),
                post.getNoMoreComments()
        );

        PostDetailsDTO actual = postService.findPostById(insertedId);

        assertEquals("Test post inserted and fetched by ID", expected, actual);
    }

    @Test
    public void testInsertCorrectWithGetAll() {
        PostDetailsDTO post = new PostDetailsDTO(
                null,
                1,
                "Another Title",
                "More content",
                LocalDateTime.now(),
                "published",
                null,
                7,
                true
        );

        postService.insert(post);

        List<PostDTO> postDTOList = postService.findPosts();
        assertEquals("Test post list size after insert", 2, postDTOList.size());
    }
}
