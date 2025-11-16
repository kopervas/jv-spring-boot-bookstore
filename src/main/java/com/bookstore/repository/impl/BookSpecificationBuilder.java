package com.bookstore.repository.impl;

import com.bookstore.dto.BookSearchParameters;
import com.bookstore.model.Book;
import com.bookstore.repository.SpecificationBuilder;
import com.bookstore.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private static final String AUTHOR = "author";
    private static final String ISBN = "isbn";
    private static final String TITLE = "title";
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters searchParameters) {
        Specification<Book> spec = Specification.not(null);
        if (searchParameters.getTitle() != null && searchParameters.getTitle().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(TITLE)
                            .getSpecification(searchParameters.getTitle()));
        }
        if (searchParameters.getAuthor() != null && searchParameters.getAuthor().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(AUTHOR)
                    .getSpecification(searchParameters.getAuthor()));
        }
        if (searchParameters.getIsbn() != null && searchParameters.getIsbn().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(ISBN)
                    .getSpecification(searchParameters.getIsbn()));
        }
        return spec;
    }
}
