package com.bookstore.repository.impl;

import com.bookstore.dto.UserSearchParameters;
import com.bookstore.model.User;
import com.bookstore.repository.SpecificationProviderManager;
import com.bookstore.repository.UserSpecificationBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserSpecificationBuilderImpl implements UserSpecificationBuilder<User> {
    private static final String EMAIL = "email";

    private final SpecificationProviderManager<User> userSpecificationProviderManager;

    @Override
    public Specification<User> build(UserSearchParameters searchParameters) {
        Specification<User> spec = Specification.not(null);
        if (searchParameters.getEmail() != null && searchParameters.getEmail().length > 0) {
            spec = spec.and(userSpecificationProviderManager.getSpecificationProvider(EMAIL)
                    .getSpecification(searchParameters.getEmail()));
        }
        return spec;
    }
}
