package example.model;

import lombok.Data;

@Data
public class Comment {

    private long postId;
    private long id;
    private String name;
    private String email;
    private String body;
}
