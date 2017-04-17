package com.blog.api.comment;

import com.blog.pojo.CommentRest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by nasheikh on 4/17/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentControllerTest {
    @LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void postCommentsWithCreds() {
        CommentRest comments = new CommentRest("Play","nawaz",601);
        ResponseEntity<String> response = template.postForEntity("http://localhost:"
                + port + "/comments",comments, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void postCommentsWithoutCreds() {
        ResponseEntity<String> response = template.getForEntity("http://localhost:"
                + port + "/comments", String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }


}
