package com.bookstore.repository.user;

import com.bookstore.model.User;
import com.bookstore.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EmailSpecificationProvider implements SpecificationProvider<User> {
    private static final String EMAIL = "email";
    @Override
    public String getKey() {
        return EMAIL;
    }

    @Override
    public Specification<User> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> {
            var predicates = Arrays.stream(params)
                    .map(param -> criteriaBuilder.like(
                            criteriaBuilder.lower(root.get(EMAIL)),
                            "%" + param.toLowerCase() + "%"
                    ))
                    .toArray(jakarta.persistence.criteria.Predicate[]::new);

            return criteriaBuilder.or(predicates);
        };
    }
}
