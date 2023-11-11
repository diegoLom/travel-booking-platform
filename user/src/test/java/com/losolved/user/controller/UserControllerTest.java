package com.losolved.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.losolved.user.model.User;
import com.losolved.user.services.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@WebMvcTest
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void givenARetrieveUserObject() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(User.builder().userId(1l).userName("Jhon").build());
        users.add(User.builder().userId(2l).userName("Dave").build());
        users.add(User.builder().userId(3l).userName("Lennon").build());

        given(userService.get()).willReturn(users);

        mockMvc.perform(get("/users")).andExpect(status().isOk()).
                andExpect(jsonPath("$", Matchers.hasSize(3))).
                andExpect(jsonPath("$[0].userName", Matchers.equalTo("Jhon")));
    }

    @Test
    public void givenARegisterOfNewUser() throws Exception {
        User user = User.builder().userId(1l).userName("yassuo").build();
        given(userService.register(ArgumentMatchers.any())).
                willReturn(user);
         String json = mapper.writeValueAsString(user);

         mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.userId", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.userName", Matchers.equalTo("yassuo")));

    }

    @Test
    public void givenAnUpdateOfExistingObject() throws Exception {
        User user = User.builder().userId(3l).userName("oriana").build();
        given(userService.update(ArgumentMatchers.any())).willReturn(Optional.of(user));
        String json = mapper.writeValueAsString(user);

        mockMvc.perform(put("/user").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.userName", Matchers.equalTo("oriana")));
    }

    @Test
    public void givenAnUpdateOfNotFoundObject() throws Exception {
        User user = User.builder().userId(3l).userName("swain").build();
        given(userService.update(ArgumentMatchers.any())).willReturn(Optional.of(user));

        mockMvc.perform(put("/user").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.userId", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.userName", Matchers.equalTo("oriana")));

    }



    //https://asbnotebook.com/spring-boot-rest-controller-junit-test-example/
}
