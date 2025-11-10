package com.bookstore.service;

import com.bookstore.dto.BookDto;
import com.bookstore.dto.BookSearchParameters;
import com.bookstore.dto.CreateBookRequestDto;
import com.bookstore.dto.UpdateBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    Page<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    BookDto update(Long id, UpdateBookRequestDto requestDto);

    List<BookDto> search(BookSearchParameters bookSearchParameters);
}
