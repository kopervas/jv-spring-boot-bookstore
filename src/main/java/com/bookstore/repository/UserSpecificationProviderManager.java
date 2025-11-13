package com.bookstore.repository;

import com.bookstore.exception.EntityNotFoundException;
import com.bookstore.model.Book;
import com.bookstore.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@RequiredArgsConstructor
@Component
public class UserSpecificationProviderManager implements SpecificationProviderManager<User> {
    private final List<SpecificationProvider<User>> userSpecificationProviders;

    @Override
    public SpecificationProvider getSpecificationProvider(String key) {
        return userSpecificationProviders.stream().filter(b -> b.getKey().equals(key)).findFirst()
                .orElseThrow(() ->
                        new EntityNotFoundException("Can`t find correct specification provider "
                                + "for key" + key));
    }
}
