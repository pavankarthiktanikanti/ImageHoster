package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * Adds a new Comment and stores in the Database
     *
     * @param image       The Image to which comment has to be added.
     * @param user        The logged in user who commented on the image.
     * @param commentText The content of the comment.
     */
    public void addNewComment(Image image, User user, String commentText) {
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setImage(image);
        comment.setText(commentText);
        //Set the current date
        comment.setCreatedDate(LocalDate.now());
        commentRepository.createComment(comment);
    }
}
