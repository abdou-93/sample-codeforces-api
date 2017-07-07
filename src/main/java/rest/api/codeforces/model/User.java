package rest.api.codeforces.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by fox on 06/07/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private String firstName;
    private String lastName;
    private String handle;
    private String country;
    private String rank;
    private Integer rating;
    private Integer maxRating;
}
