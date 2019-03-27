package lw.learn.lc.design;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @Author lw
 * @Date 2019-03-27 16:44:07
 **/
public class P911_OnlineElection {

    class TopVotedCandidate {

        TreeMap<Integer, Integer> t2p; // time -> person

        public TopVotedCandidate(int[] persons, int[] times) {

            t2p = new TreeMap<>();
            int maxVote = Integer.MIN_VALUE;
            int maxPerson = 0;

            HashMap<Integer, Integer> p2t = new HashMap<>();

            for (int i = 0; i < persons.length; i++) {

                int tmpVote = p2t.getOrDefault(persons[i], 0) + 1;

                if (maxVote <= tmpVote) {
                    maxVote = tmpVote;
                    maxPerson = persons[i];
                }
                p2t.put(persons[i], tmpVote);

                t2p.put(times[i], maxPerson);
            }
        }

        public int q(int t) {
            return t2p.floorEntry(t).getValue();
        }
    }
}
