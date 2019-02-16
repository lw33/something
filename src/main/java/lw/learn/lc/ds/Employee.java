package lw.learn.lc.ds;

import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-15 23:14:34
 **/
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
