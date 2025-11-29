package algorithm.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInscription {

    protected record User(Integer id, List<Integer> subscriptions) {
    }

    public List<Integer> mostCommonSubscriptions(List<User> users, Integer topK) {
        Map<Integer, Long> histogram = new HashMap<>();
        for (var user : users) {
            if (user.subscriptions == null || user.subscriptions.isEmpty()) continue;
            for (Integer subscription : user.subscriptions()) {
                histogram.merge(subscription, 1L, Long::sum);
            }
        }
        List<Integer>[] positionValues = new ArrayList[histogram.size()];
        for (var entry : histogram.entrySet()) {
            var key = entry.getValue().intValue();
            if (positionValues[key] == null) {
                List<Integer> subscriptions = new ArrayList<>();
                subscriptions.add(entry.getKey());
                positionValues[key] = subscriptions;
            } else {
                List<Integer> subscriptions = positionValues[key];
                subscriptions.add(entry.getKey());
            }
        }
        var currentItems = 0;
        List<Integer> response = new ArrayList<>();
        for (var j = positionValues.length - 1; j > 0; j--) {
            List<Integer> subscriptions = positionValues[j];
            if (subscriptions != null) {
                for (Integer subscription : subscriptions) {
                    if (currentItems < topK) {
                        response.add(subscription);
                        currentItems++;
                    } else {
                        break;
                    }
                }
            }
        }
        return response;
    }
}