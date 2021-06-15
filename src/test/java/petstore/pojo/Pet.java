package petstore.pojo;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Pet {
    private  Long id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;


}

