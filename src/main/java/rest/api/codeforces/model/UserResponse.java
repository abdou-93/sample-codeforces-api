package rest.api.codeforces.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fox on 06/07/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserResponse {
    private String status;
    private List<User> result;
}
