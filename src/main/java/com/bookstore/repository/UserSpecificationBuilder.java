package com.bookstore.repository;

import com.bookstore.dto.BookSearchParameters;
import com.bookstore.dto.UserSearchParameters;
import org.springframework.data.jpa.domain.Specification;

public interface UserSpecificationBuilder<T> {
    Specification<T> build(UserSearchParameters searchParameters);
}
