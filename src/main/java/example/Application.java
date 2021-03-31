package example;


import dagger.Component;
import example.model.Comment;
import example.model.Post;
import example.model.User;
import example.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.List;

public class Application {

    @Singleton
    @Component
    public interface ExampleComponent {
         Application application();
    }

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private final DataService dataService;

    public static void main(String ... args) {
        int requiredPosts = args.length > 0 ? Integer.parseInt(args[0]) : 10;
        ExampleComponent component =  DaggerApplication_ExampleComponent.builder().build();
        List<User> popularUsers = component.application().getUsersWithPopularPosts(requiredPosts);
        logger.info("Popular Users {}", popularUsers);
    }

    @Inject
    public Application(DataService dataService) {
        this.dataService = dataService;
    }

    public List<User> getUsersWithPopularPosts(int requiredPosts) {
        List<Comment> comments = dataService.getComments();
        List<Post> posts = dataService.getPosts();
        List<User> users = dataService.getUsers();

        //TODO
        return Collections.emptyList();
    }
}
