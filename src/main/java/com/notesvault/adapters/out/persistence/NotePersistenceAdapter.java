package com.notesvault.adapters.out.persistence;

import com.notesvault.adapters.out.persistence.entity.NoteJpa;
import com.notesvault.adapters.out.persistence.repository.NoteRepository;
import com.notesvault.application.port.out.NotePersistencePort;
import com.notesvault.domain.Note;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class NotePersistenceAdapter implements NotePersistencePort {

    private final NoteRepository repository;

    public NotePersistenceAdapter(NoteRepository noteRepository) {
        this.repository = noteRepository;
    }

    @Override
    public Note save(Note note) {
        NoteJpa noteJpa = NoteJpa.builder()
                .userId(note.getUserId())
                .title(note.getTitle())
                .content(note.getContent())
                .build();
        noteJpa = repository.save(noteJpa);
        note.setId(noteJpa.getId());
        return note;
    }

    @Override
    public List<Note> loadNotesByOwner(UUID ownerId) {
        return repository.findByOwnerId(ownerId).stream().map(this::toDomain).toList();
    }

    private Note toDomain(NoteJpa noteJpa) {
        return Note.builder()
                .id(noteJpa.getId())
                .userId(noteJpa.getUserId())
                .title(noteJpa.getTitle())
                .content(noteJpa.getContent())
                .build();
    }
}
