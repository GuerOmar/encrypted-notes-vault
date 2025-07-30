package com.notesvault.application.service;

import com.notesvault.application.port.in.ManageNoteUseCase;
import com.notesvault.application.port.out.NotePersistencePort;
import com.notesvault.domain.Note;
import com.notesvault.security.EncryptionProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService implements ManageNoteUseCase {

    private final NotePersistencePort notePersistencePort;
    private final EncryptionProvider encryptionProvider;

    public NoteService(NotePersistencePort notePersistencePort, EncryptionProvider encryptionProvider) {
        this.notePersistencePort = notePersistencePort;
        this.encryptionProvider = encryptionProvider;
    }

    @Override
    public Note createNote(UUID userId, String title, String content) {
        Note note = Note.builder()
                .userId(userId)
                .title(encryptionProvider.encrypt(title))
                .content(encryptionProvider.encrypt(content))
                .build();
        return notePersistencePort.save(note);
    }

    @Override
    public List<Note> getNotesByUser(UUID ownerId) {
        List<Note> notesByOwner = notePersistencePort.loadNotesByOwner(ownerId);
        notesByOwner.forEach(note -> {
            note.setTitle(encryptionProvider.decrypt(note.getTitle()));
            note.setContent(encryptionProvider.decrypt(note.getContent()));
        });
        return notesByOwner;
    }
}
