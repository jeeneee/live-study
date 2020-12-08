package week4.github;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.*;

public class Application {
    final private String TOKEN = "<YOUR TOKEN>";
    final private String ADDRESS = "whiteship/live-study";
    final private float MIN_PERCENTAGE = 80.0f;
    private GitHub github;

    public static void main(String[] args) throws IOException {
        Application app = new Application();
        app.run();
    }

    void run() throws IOException {
        github = new GitHubBuilder().withOAuthToken(TOKEN).build();
        GHRepository repo = github.getRepository(ADDRESS);
        List<GHIssue> issues = repo.getIssues(GHIssueState.ALL);
        int weeks = issues.size();
        int latestLockedIssue = 0;

        Map<String, List<Integer>> users = new TreeMap<>();

        for (int i = weeks - 1, j = 1; i >= 0; i--, j++) {
            List<GHIssueComment> comments = issues.get(i).getComments();
            if (issues.get(i).isLocked()) {
                latestLockedIssue = j;
            }
            Set<String> nicknames = new HashSet<>();
            for (GHIssueComment comment: comments) {
                String nickname = comment.getUser().getLogin();
                String body = comment.getBody();
                if (body.contains("http://") || body.contains("https://")) {
                    nicknames.add(nickname);
                }
            }
            for (String nickname : nicknames) {
                List<Integer> list;
                if (users.containsKey(nickname)) {
                    list = users.get(nickname);
                } else {
                    list = new ArrayList<>();
                }
                list.add(j);
                users.put(nickname, list);
            }
        }

        print(users, weeks, latestLockedIssue);

    }

    void print(Map<String, List<Integer>> users, int weeks, int latestLockedIssue) {
        StringBuilder str = new StringBuilder();
        int[] statistics = new int[weeks + 3];   // 통계 저장
        statistics[0] = users.size();

        // 첫째 줄
        str.append("| 참여자 ");
        for (int i = 1; i <= weeks; i++) {
            str.append("| ").append(i).append("주차 ");
        }
        str.append("| 참석율 ").append("| 티셔츠 |\n");

        for (int i = 1; i <= weeks + 3; i++) {
            str.append("| --- ");
        }
        str.append("|\n");

        // 1주차 ~ weeks주차 과제 및 참석율
        for (Map.Entry<String, List<Integer>> entry : users.entrySet()) {
            String name = entry.getKey();
            List<Integer> list = entry.getValue();
            str.append("| ").append(name).append(" ");
            for (int i = 1, j = 0; i <= weeks; i++) {
                str.append("|");
                if (j < list.size() && i == list.get(j)) {
                    str.append("✅");
                    statistics[i]++;
                    j++;
                }
            }
            int rest = weeks - Math.max(latestLockedIssue, list.get(list.size() - 1));
            float percentage = (float)list.size() / weeks * 100;
            statistics[weeks + 1] += percentage * 100;
            str.append(" | ").append(String.format("%.2f", percentage));
            str.append(" | ");
            if ((float)(rest + list.size()) / weeks * 100 < MIN_PERCENTAGE) {
                str.append("❌ |\n");   // 불가
            } else if (percentage >= MIN_PERCENTAGE) {
                str.append("⭕ |\n");    // 확실
                statistics[weeks + 2]++;
            } else {
                str.append("❓ |\n");   // 불확실
            }
        }

        // 마지막 줄
        str.append("| ");
        for (int i = 0; i < statistics.length; i++) {
            if (i == 0 || i == statistics.length - 1) {
                str.append(statistics[i]);
            } else if (i == statistics.length - 2) {
                str.append((float)(statistics[i] / statistics[0]) / 100);
            } else {
                float percentage = (float)statistics[i] / statistics[0] * 100;
                str.append(String.format("%.2f", percentage));
                str.append("(").append(statistics[i]).append(")");
            }
            str.append(" | ");
        }

        System.out.println(str);
    }
}