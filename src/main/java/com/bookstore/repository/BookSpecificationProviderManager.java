package com.bookstore.repository;

import com.bookstore.exception.EntityNotFoundException;
import com.bookstore.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProviders;

    @Override
    public SpecificationProvider getSpecificationProvider(String key) {
        return bookSpecificationProviders.stream().filter(b -> b.getKey().equals(key)).findFirst()
                .orElseThrow(() ->
                        new EntityNotFoundException("Can`t find correct specification provider "
                                + "for key" + key));
    }
}
