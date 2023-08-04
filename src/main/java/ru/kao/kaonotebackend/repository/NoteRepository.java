package ru.kao.kaonotebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kao.kaonotebackend.entity.Note;

public interface NoteRepository extends JpaRepository<Note, String> {
}
