package com.notesvault.application.port.out;

import com.notesvault.domain.Note;

import java.util.List;
import java.util.UUID;

public interface NotePersistencePort {
    Note save(Note note);
    List<Note> loadNotesByOwner(UUID ownerId);

}
