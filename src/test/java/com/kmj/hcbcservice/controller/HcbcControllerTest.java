package com.kmj.hcbcservice.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kmj.hcbcservice.document.Book;
import com.kmj.hcbcservice.service.HcbcService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class HcbcControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HcbcService hcbcService;

    private Book book;
    private ResultActions resultActions;

    @BeforeEach
    public void setUp() throws Exception {
        book = new Book(1, "title1", "author1", "1998", "123456");
    }

    @Test
    public void create() throws Exception {
        Gson gson = new GsonBuilder().create();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/book")
                        .contentType("application/json;charset=UTF-8")
                        .content(gson.toJson(book))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void findById() throws Exception {
        when(hcbcService.findById(String.valueOf(book.getId()))).thenReturn(Optional.ofNullable(book));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/{id}", book.getId())
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("title1"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/{id}", 2)
                        .header("Content-Type", "application/json"))
                .andExpect(status().isNotFound());
    }



}
