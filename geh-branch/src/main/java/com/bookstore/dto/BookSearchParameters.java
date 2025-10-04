package com.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchParameters {
    private String[] title;
    private String[] author;
    private String[] isbn;
}

/*package com.bookstore.dto;

public record BookSearchParameters(String[] title, String[] author, String[] isbn) {

}*/

