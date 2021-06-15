package petstore.pojo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Tag {
    private Long id;
    private String name;

}