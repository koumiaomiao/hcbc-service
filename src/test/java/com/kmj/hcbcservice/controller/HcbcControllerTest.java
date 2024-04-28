package com.kmj.hcbcservice.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kmj.hcbcservice.document.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertSame;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class HcbcControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book(1, "title1", "author1", "1998", "123456");
    }

    @Test
    public void create() throws Exception {
        Gson gson = new GsonBuilder().create();
        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .contentType("application/json;charset=UTF-8")
                        .content(gson.toJson(book))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
