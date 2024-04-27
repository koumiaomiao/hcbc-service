package com.kmj.hcbcservice;

import com.kmj.hcbcservice.document.Book;
import com.kmj.hcbcservice.repository.HcbcRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@DataMongoTest
@RunWith(SpringRunner.class)
public class HcbcRepositoryTest {

    @Autowired
    private HcbcRepository hcbcRepository;
    private Book book;

    @Test
    public void should_get_a_book_when_create_a_book() {
        book = new Book(1, "title1", "author1", "1998", "123456");
        hcbcRepository.save(book);
        assertThat(hcbcRepository.findAll()).isNotEmpty();
    }
}
