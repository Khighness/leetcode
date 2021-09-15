package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 1450. 在既定时间做作业的学生人数
 */
public class T1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i ++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }

}
