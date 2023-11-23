package com.TestExample.TestExample.repository;

import com.TestExample.TestExample.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Các phương thức truy vấn dữ liệu nếu cần thiết
    Todo findByTitle(String title);
}