package ru.kao.kaonotebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kao.kaonotebackend.entity.Task;

public interface TaskRepository extends JpaRepository<Task, String> {
}
