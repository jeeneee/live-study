package week4.github;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.*;

public class Application {
    final private String TOKEN = "<YOUR_TOKEN>";
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
        str.append("| 참여자 ");
        for (int i = 1; i <= weeks; i++) {
            str.append("| ").append(i).append("주차 ");
        }
        str.append("| 참석율 ").append("| 티셔츠 |\n");

        for (int i = 1; i <= weeks + 3; i++) {
            str.append("| --- ");
        }
        str.append("|\n");

        for (Map.Entry<String, List<Integer>> entry : users.entrySet()) {
            String name = entry.getKey();
            List<Integer> list = entry.getValue();
            str.append("| ").append(name).append(" ");
            for (int i = 1, j = 0; i <= weeks; i++) {
                str.append("|");
                if (j < list.size() && i == list.get(j)) {
                    str.append("✅");
                    j++;
                }
            }
            int rest = weeks - Math.max(latestLockedIssue, list.get(list.size() - 1));
            float percentage = (float)list.size() / weeks * 100;
            str.append(" | ").append(String.format("%.2f", percentage));
            str.append(" | ");
            if ((float)(rest + list.size()) / weeks * 100 < MIN_PERCENTAGE) {
                str.append("❌ |\n");
            } else if (percentage >= MIN_PERCENTAGE) {
                str.append("⭕ |\n");
            } else {
                str.append("❓ |\n");
            }
        }
        System.out.println(str);
    }
}
