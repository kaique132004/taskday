package com.kgbz.taskday.domain.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Tasks, String> {
    List<Tasks> findAllByActiveTrue();
}
