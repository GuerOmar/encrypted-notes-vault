package com.notesvault.adapters.in.web;

import com.notesvault.adapters.in.web.dto.NoteRequest;
import com.notesvault.application.port.in.ManageNoteUseCase;
import com.notesvault.domain.Note;
import com.notesvault.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private final ManageNoteUseCase manageNoteUseCase;

    public NoteController(ManageNoteUseCase manageNoteUseCase) {
        this.manageNoteUseCase = manageNoteUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getNotes(@AuthenticationPrincipal User user) {
        List<Note> notes = manageNoteUseCase.getNotesByUser(user.getId());
        return ResponseEntity.ok(notes);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@AuthenticationPrincipal User user, @RequestBody NoteRequest request) {
        Note createdNote = manageNoteUseCase.createNote(user.getId(), request.title(), request.content());
        return ResponseEntity.ok(createdNote);
    }
}
