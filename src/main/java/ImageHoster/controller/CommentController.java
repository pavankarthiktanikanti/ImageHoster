package ImageHoster.controller;

import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    ImageService imageService;

    /**
     * This method adds a new comment to an Image
     *
     * @param imageId     id of the image to which the comment has to be added.
     * @param imageTitle  title of the image to which the comment has to be added.
     * @param commentText The actual comment content posted by user.
     * @param session     To retrieve the logged User details from the HTTPSession.
     * @return The redirect View to be displayed
     */
    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String addCommentToImage(@PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String imageTitle, @RequestParam("comment") String commentText, HttpSession session) {

        Image image = imageService.getImage(imageId);
        User user = (User) session.getAttribute("loggeduser");
        commentService.addNewComment(image, user, commentText);
        return "redirect:/images/" + imageId + "/" + imageTitle;
    }
}
