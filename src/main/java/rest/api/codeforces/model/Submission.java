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
public class Submission implements Comparable<Submission> {
    private Integer id;
    private Problem problem;
    private String verdict;

    @Override
    public int compareTo(Submission o) {
        if(problem.equals(o.getProblem())) {
            return id.compareTo(o.getId());
        }
        return problem.compareTo(o.getProblem());
    }
}
