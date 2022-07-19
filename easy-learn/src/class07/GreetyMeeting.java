package class07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一段连续时间可以安排多少场会议
 */


public class GreetyMeeting {

    public static int Greety(Meeting[] meetings, int timePoint) {
        Arrays.sort(meetings, new MeetingPriority());
        int result = 0;
        for (int i = 0; i < meetings.length; i++) {
            if (timePoint <= meetings[i].start) {
                result++;
                timePoint = meetings[i].end;
            }
        }
        return result;
    }

    public static class MeetingPriority implements Comparator<Meeting> {

        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.end - o2.end;
        }
    }

    public static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

}
