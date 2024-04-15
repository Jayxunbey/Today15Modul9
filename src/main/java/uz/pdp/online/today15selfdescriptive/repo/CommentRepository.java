package uz.pdp.online.today15selfdescriptive.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.online.today15selfdescriptive.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findByid(Long id);

}