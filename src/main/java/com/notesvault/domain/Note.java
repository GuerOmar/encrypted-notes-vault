package com.notesvault.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class Note {

    private UUID id;
    private UUID userId;
    private String title;
    private String content;
}
