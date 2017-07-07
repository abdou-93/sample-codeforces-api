package rest.api.codeforces.controller;

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
public class ResponseObject {
    private String message;
    private Object result;
}
