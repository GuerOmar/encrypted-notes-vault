package com.notesvault.application.service;

import com.notesvault.application.port.in.ManageNoteUseCase;
import com.notesvault.application.port.out.NotePersistencePort;
import com.notesvault.domain.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService implements ManageNoteUseCase {

    private final NotePersistencePort notePersistencePort;

    public NoteService(NotePersistencePort notePersistencePort) {
        this.notePersistencePort = notePersistencePort;
    }

    @Override
    public Note createNote(UUID userId, String title, String content) {
        Note note = Note.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .build();
        return notePersistencePort.save(note);
    }

    @Override
    public List<Note> getNotesByUser(UUID ownerId) {
        return notePersistencePort.loadNotesByOwner(ownerId);
    }
}
