package com.api.mockito.rest_template_ms.repository;

import com.api.mockito.rest_template_ms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUser extends JpaRepository<User, Long> {
}
