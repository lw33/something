package lw.learn.lc.dfs;

import lw.learn.lc.ds.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-15 23:14:06
 **/
public class P690_EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id, map);
    }

    private int dfs(Integer id, HashMap<Integer, Employee> map) {
        Employee employee = map.get(id);
        int res = employee.importance;
        for (Integer subordinate : employee.subordinates) {
            res += dfs(subordinate, map);
        }
        return res;
    }

}
