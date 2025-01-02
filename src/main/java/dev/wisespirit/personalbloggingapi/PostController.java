package dev.wisespirit.personalbloggingapi;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> save(@RequestBody PostCreateDto dto) {
        try {
            return postService.create(dto)
                    .map(post -> new ResponseEntity<>(post, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable Integer id) {
        return postService.getById(id)
                .map(post -> new ResponseEntity<>(post, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAll() {
        Optional<List<PostDto>> optioanl = postService.getAllPost();
        if (optioanl.isPresent()) {
            return new ResponseEntity<>(optioanl.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> update(@PathVariable Integer id,
            @RequestBody PostUpdateDto dto) {
        return postService.update(id, dto)
                .map(updatedPost -> new ResponseEntity<>(updatedPost, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        if (postService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PostDto>> search(@RequestParam(required = false) String term){
        Optional<List<PostDto>> search = postService.search(term);
        if (search.isPresent()) {
            return new ResponseEntity<>(search.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
