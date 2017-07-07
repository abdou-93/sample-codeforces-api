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
public class Problem implements Comparable<Problem> {
    private String name;
    private Double points;
    private Integer contestId;
    private String index;
    private Integer numberOfTrials;
    private Boolean solved;

    @Override
    public int compareTo(Problem temp) {
        if(contestId.equals(temp.getContestId())) {
            return (index.compareTo(temp.getIndex()));
        }
        return contestId.compareTo(temp.getContestId());
    }

    public boolean equals(Problem temp) {
        return (contestId.equals(temp.getContestId())) && index.equals(temp.getIndex());
    }
}
