package com.thoughtworks.beijingGrad.springbootuserWithContacts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.Contact;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.Gender;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = standaloneSetup(new UserController()).build();
    }

    @Test
    void should_return_contacts_of_the_user_with_id_5() throws Exception {
        mockMvc.perform(get("/users/5/contacts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("wu qian"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("xin kuan"));
    }

    @Test
    void should_create_a_contact_for_the_user_with_id_5() throws Exception {
        Contact contact = new Contact(3, "zeng zhipeng", 1234567890L, 20, Gender.Male);

        mockMvc.perform(post("/users/5/contacts")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].name").value("zeng zhipeng"));
    }
}
