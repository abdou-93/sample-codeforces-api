package rest.api.codeforces.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rest.api.codeforces.model.*;

import java.util.*;

/**
 * Created by fox on 06/07/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserInfo userInfo;

    @Autowired
    private UserResponse userResponse;

    @Autowired
    private SubmissionResponse submissionResponse;

    public UserInfo getUserInfoByHandle(String userHandle) throws Exception {
        try {
            userInfo.setUser(getUserByHandle(userHandle));
            userInfo.setProblemList(getUserProblemsByHandle(userHandle));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return userInfo;
    }

    private User getUserByHandle(String userHandle) throws Exception {
        final String uri = "http://codeforces.com/api/user.info?handles={userHandle}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("userHandle", userHandle);
        RestTemplate restTemplate = new RestTemplate();
        User user = null;
        try {
            userResponse = restTemplate.getForObject(uri, UserResponse.class, params);
            if (userResponse.getStatus().equals("OK")) {
                user = userResponse.getResult().get(0);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    private List<Problem> getUserProblemsByHandle(String userHandle) throws Exception {
        final String uri = "http://codeforces.com/api/user.status?handle={userHandle}&from=1&count=20000";
        Map<String, String> params = new HashMap<String, String>();
        params.put("userHandle", userHandle);
        RestTemplate restTemplate = new RestTemplate();
        List<Problem> problemList = null;
        try {
            submissionResponse = restTemplate.getForObject(uri, SubmissionResponse.class, params);
            if (submissionResponse.getStatus().equals("OK")) {
                problemList = prepareSubmissionList(submissionResponse.getResult());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return problemList;
    }

    private List<Problem> prepareSubmissionList(List<Submission> submissions) {
        Collections.sort(submissions);
        List<Problem> result = new LinkedList<Problem>();
        Problem temp = null;
        for (Submission it: submissions) {
            if(temp == null) {
                temp = it.getProblem();
                temp.setNumberOfTrials(1);
                temp.setSolved(false);
            } else if(temp.equals(it.getProblem()) && !temp.getSolved()) {
                temp.setNumberOfTrials(temp.getNumberOfTrials() + 1);
            } else if(!temp.equals(it.getProblem())) {
                result.add(temp);
                temp = it.getProblem();
                temp.setNumberOfTrials(1);
                temp.setSolved(false);
            }
            if(it.getVerdict().equals("OK")) {
                temp.setSolved(true);
            }
        }
        if(temp != null) {
            result.add(temp);
        }
        return result;
    }
}