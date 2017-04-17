package com.blog.api.post;

import com.blog.pojo.CommentRest;
import com.blog.pojo.PostRest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by nasheikh on 4/17/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void savePostsWithCreds() {
        TestRestTemplate template = new TestRestTemplate("user", "password");
        PostRest posts = new PostRest(122,"title","testcontent","nawaz","sumthing");
        ResponseEntity<String> response = template.postForEntity("http://localhost:"
                + port + "/posts",posts, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void fetchAllPostsWithCreds() {
        TestRestTemplate template = new TestRestTemplate("user", "password");
        ResponseEntity<String> response = template.getForEntity("http://localhost:"
                + port + "/posts", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void fetchOnePostsWithCreds() {
        TestRestTemplate template = new TestRestTemplate("user", "password");
        int postId = 601;
        ResponseEntity<String> response = template.getForEntity("http://localhost:"
                + port + "/posts/"+postId, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
