package com.notesvault.application.port.in;

import com.notesvault.domain.Note;

import java.util.List;
import java.util.UUID;

public interface ManageNoteUseCase {
    Note createNote(UUID userId, String title, String content);
    List<Note> getNotesByUser(UUID ownerId);
}
