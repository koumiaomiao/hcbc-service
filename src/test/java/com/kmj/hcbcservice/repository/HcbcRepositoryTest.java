package com.kmj.hcbcservice.repository;

import com.kmj.hcbcservice.document.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@DataMongoTest
@RunWith(SpringRunner.class)
public class HcbcRepositoryTest {

    @Autowired
    private HcbcRepository hcbcRepository;

    private Book book;

    @Test
    public void should_insert_a_book_to_repository_success_when_create_a_book() {
        book = new Book(1, "title1", "author1", "1998", "123456");
        hcbcRepository.save(book);
        assertThat(hcbcRepository.findAll()).isNotEmpty();
    }
}
