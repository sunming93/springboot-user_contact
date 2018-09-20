package com.thoughtworks.beijingGrad.springbootuserWithContacts.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
                .andExpect(jsonPath("$.contacts",hasSize(2)))
                .andExpect(jsonPath("$.contacts[0].id").value(1))
                .andExpect(jsonPath("$.contacts[0].name").value("wu qian"))
                .andExpect(jsonPath("$.contacts[1].id").value(2))
                .andExpect(jsonPath("$.contacts[1].name").value("xin kuan"));
    }
}
