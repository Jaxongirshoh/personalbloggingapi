package dev.wisespirit.personalbloggingapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<PostDto> create(PostCreateDto dto) {
        log.info("Creating post: {}", dto);
        Post saved;
        try {
            saved = postRepository.save(new Post(dto.title(), dto.content(), dto.category(), dto.tags()));

        } catch (Exception e) {
            log.error("Error creating post: {}", dto, e);
            throw new RuntimeException(e.getMessage());
        }
        log.info("Post created: {}", saved);
        return Optional.of(new PostDto(saved.getId(),
                saved.getTitle(),
                saved.getContent(),
                saved.getCategory(),
                saved.getTags(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()));
    }

    public Optional<PostDto> getById(Integer id) {
        return postRepository.findById(id)
                .map(entity -> (new PostDto(entity.getId(),
                        entity.getTitle(),
                        entity.getContent(),
                        entity.getCategory(),
                        entity.getTags(),
                        entity.getCreatedAt(),
                        entity.getUpdatedAt())));
    }

    public Optional<List<PostDto>> getAllPost() {
        Iterable<Post> all = postRepository.findAll();
        List<PostDto> dtos = new ArrayList<>();
        if (all != null) {
            all.forEach(entity -> dtos.add(new PostDto(entity.getId(),
                    entity.getTitle(),
                    entity.getContent(),
                    entity.getCategory(),
                    entity.getTags(),
                    entity.getCreatedAt(),
                    entity.getUpdatedAt())));

            return Optional.of(dtos);
        }
        return Optional.empty();
    }

    public Optional<PostDto> update(Integer id, PostUpdateDto dto) {
        return postRepository.findById(id)
                .map(entity -> {
                    entity.setTitle(dto.title());
                    entity.setContent(dto.content());
                    entity.setCategory(dto.category());
                    entity.setTags(dto.tags());
                    return postRepository.save(entity);
                })
                .map(saved -> new PostDto(saved.getId(),
                        saved.getTitle(),
                        saved.getContent(),
                        saved.getCategory(),
                        saved.getTags(),
                        saved.getCreatedAt(),
                        saved.getUpdatedAt()));
    }

    public boolean delete(Integer id) {
        return postRepository.findById(id)
                .map(entity -> {
                    postRepository.delete(entity);
                    return true;
                }).orElse(false);
    }

    public Optional<List<PostDto>> search(String query) {
        Iterable<Post> all = postRepository.findAll();
        List<PostDto> dtos = new ArrayList<>();
        if (all != null) {
            all.forEach(entity -> dtos.add(new PostDto(entity.getId(),
                    entity.getTitle(),
                    entity.getContent(),
                    entity.getCategory(),
                    entity.getTags(),
                    entity.getCreatedAt(),
                    entity.getUpdatedAt())));

            return Optional.of(dtos);
        }
        return Optional.empty();
    }
}
