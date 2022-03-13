package theorigin.javaspringboot.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// given: 어떤 데이터가 준비가 되어있다
// → PostEntity가 존재할 때

// when: 어떤 행위가 일어났을때 (함수 호출 등)
// → 경로에 GET 요청이 오면

// then: 어떤 결과가 올 것인지
// → PostDTO가 반환된다

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    public void readPost() throws Exception {
        // given
        final int id = 10;
        PostDTO testDTO = new PostDTO();
        testDTO.setId(id);
        testDTO.setTitle("Unit Title");
        testDTO.setContent("Unit Content");
        testDTO.setWriter("unit");

        given(postService.readPost(id)).willReturn(testDTO);

        // when
        final ResultActions actions = mockMvc.perform(get("/post/{id}", id))
                .andDo(print());

        // then
        actions.andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                jsonPath("$.title", is("Unit Title")),
                jsonPath("$.content", is("Unit Content")),
                jsonPath("$.writer", is("unit"))
        );
    }

    @Test
    public void readPostAll() throws Exception {
        // given
        PostDTO post1 = new PostDTO();
        post1.setTitle("title 1");
        post1.setContent("test");
        post1.setWriter("test");

        PostDTO post2 = new PostDTO();
        post2.setTitle("title 2");
        post2.setContent("test");
        post2.setWriter("test");

        List<PostDTO> readAllPost = Arrays.asList(post1, post2);
        given(postService.readPostAll()).willReturn(readAllPost);

        // when
        final ResultActions actions = mockMvc.perform(get("/post"))
                .andDo(print());

        // then
        actions.andExpectAll(
          status().isOk(),
          content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
          jsonPath("$", hasSize(readAllPost.size()))
        );
    }
}