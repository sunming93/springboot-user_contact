package com.thoughtworks.beijingGrad.springbootuserWithContacts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.Contact;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.domain.Gender;
import com.thoughtworks.beijingGrad.springbootuserWithContacts.repository.UserStorage;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
        int origianlSize = UserStorage.getUSERS().get(5).getContacts().size();

        mockMvc.perform(post("/users/5/contacts")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("zeng zhipeng"))
                .andExpect(jsonPath("$.phoneNumber").value(1234567890L))
                .andExpect(jsonPath("$.age").value(20))
                .andExpect(jsonPath("$.gender").value("Male"));

        int scaledSize = UserStorage.getUSERS().get(5).getContacts().size();
        assertEquals(origianlSize + 1, scaledSize);
    }

    @Test
    void should_update_the_contact_for_the_user_with_id_5() throws Exception{
        Contact contact = new Contact(2, "zeng zhipeng", 1234567890L, 20, Gender.Male);

        mockMvc.perform(put("/users/5/contacts/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("zeng zhipeng"))
                .andExpect(jsonPath("$.phoneNumber").value(1234567890L))
                .andExpect(jsonPath("$.age").value(20))
                .andExpect(jsonPath("$.gender").value("Male"));

        Contact updatedContact = UserStorage.getUSERS().get(5).getContacts().get(2);
        assertEquals("zeng zhipeng", updatedContact.getName());
        assertEquals(1234567890L, updatedContact.getPhoneNumber());
        assertEquals(20, updatedContact.getAge());
        assertEquals(Gender.Male, updatedContact.getGender());
    }
}
