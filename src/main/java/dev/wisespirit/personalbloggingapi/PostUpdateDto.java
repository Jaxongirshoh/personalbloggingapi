package dev.wisespirit.personalbloggingapi;

import java.util.List;

public record  PostUpdateDto(String title,
        String content,
        String category,
        List<String>tags) {

}
