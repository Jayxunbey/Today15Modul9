package uz.pdp.online.today15selfdescriptive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.online.today15selfdescriptive.entity.Comment;
import uz.pdp.online.today15selfdescriptive.repo.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentRepository commentRepository;
    @GetMapping("/all")
    public CollectionModel<EntityModel<Comment>> getAllComments() {
        List<Comment> all = commentRepository.findAll();

        List<EntityModel<Comment>> entityModels = new ArrayList<>();
        for (Comment comment : all) {
            entityModels.add(EntityModel.of(comment, Link.of("http://localhost:8080/comments/"+ comment.getId())));
        }
        CollectionModel<EntityModel<Comment>> collectionModel = CollectionModel.of(entityModels);

        return collectionModel;

//        return comments;

    }

    @GetMapping("/{id}")
    public EntityModel<Comment> getCommentById(@PathVariable long id) {

        Comment comment = commentRepository.findByid(id);
        EntityModel<Comment> commentEntityModel = EntityModel.of(comment, Link.of("http://localhost:8080/comments/" + id));

        return commentEntityModel;
//         commentRepository.findByid(id);



    }
}
