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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static java.sql.DriverManager.println;
import static org.hamcrest.MatcherAssert.assertThat;
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
    private Gson gson;

    @BeforeEach
    public void setUp() {
        book = new Book("1", "title1", "author1", "1998", "123456");
        gson = new GsonBuilder().create();
    }

    @Test
    public void create() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
                        .contentType("application/json;charset=UTF-8")
                        .content(gson.toJson(book))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        when(hcbcService.findById(book.getId())).thenReturn(Optional.ofNullable(book));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/{id}", book.getId())
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("title1"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/{id}", 2)
                        .header("Content-Type", "application/json"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void update() throws Exception {
        when(hcbcService.save(book)).thenReturn(book);
        Book anotherBook = new Book("1", "titlex", "authorx", "1998", "123456");
        when(hcbcService.findById(anotherBook.getId())).thenReturn(Optional.ofNullable(book));

        hcbcService.save(book);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/books/{id}", anotherBook.getId())
                        .contentType("application/json;charset=UTF-8")
                        .content(gson.toJson(anotherBook))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
