package dev.wisespirit.personalbloggingapi;

import java.time.LocalDateTime;
import java.util.List;

public record PostDto(Integer id,
                      String title,
                      String content,
                      String category,
                      List<String> tags,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt) {
}
