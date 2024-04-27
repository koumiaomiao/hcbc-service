package com.kmj.hcbcservice.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("book")
public class Book {

    @Id
    private int id;
    private String title;
    private String author;
    @Field("publication_year")
    private String publicationYear;
    @Field("ISBN")
    private String isbn;
}
