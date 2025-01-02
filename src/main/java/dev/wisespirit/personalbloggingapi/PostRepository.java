package dev.wisespirit.personalbloggingapi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post,Integer> {

    @Query("""
            select p from Post p where
                        lower(p.title) like lower(concat('%', :title, '%')) or
                        lower(p.content) like lower(concat('%', :content, '%')) or
                        lower(p.category) like lower(concat('%', :category, '%'))
            """)
    List<Post> search(String term);
}
