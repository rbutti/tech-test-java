package example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import example.model.Comment;
import example.model.Post;
import example.model.User;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

public class DataService {

    @Inject
    public DataService() {
        
    }

    private ObjectMapper jackson = new ObjectMapper();
    private TypeFactory typeFactory = jackson.getTypeFactory();

    public List<Comment> getComments() {
        return loadType("/data/comments.json", Comment.class);
    }

    public List<Post> getPosts() {
        return loadType("/data/posts.json", Post.class);
    }

    public List<User> getUsers() {
        return loadType("/data/users.json", User.class);
    }

    private <T> List<T> loadType(String classpath, Class<T> type) {
        try {
            return jackson.readValue(
                    getClass().getResource(classpath),
                    typeFactory.constructCollectionType(List.class, type));
        } catch(IOException e) {
            throw new RuntimeException("Unable to load " + classpath, e);
        }

    }
}
