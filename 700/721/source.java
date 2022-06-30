import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        String[] names = new String[accounts.size()];
        HashSet<String>[] emails = new HashSet[accounts.size()];

        for (int id = 0; id < accounts.size(); id++) {
            List<String> account = accounts.get(id);
            names[id] = account.get(0);

            HashSet<String> currentEmails = new HashSet<>();
            for (int cursor = 1; cursor < account.size(); cursor++) {
                String email = account.get(cursor);
                currentEmails.add(email);

                for (int previousId = 0; previousId < id; previousId++) {
                    HashSet<String> prevEmails = emails[previousId];
                    if (prevEmails.contains(email)) {
                        currentEmails.addAll(prevEmails);
                        prevEmails.clear();
                    }
                }
            }
            emails[id] = currentEmails;
        }

        List<List<String>> output = new LinkedList<>();

        for (int id = 0; id < accounts.size(); id++) {
            HashSet<String> currentEmails = emails[id];

            if (!currentEmails.isEmpty()) {
                LinkedList<String> account = new LinkedList<>(currentEmails);
                account.sort(String::compareTo);
                account.addFirst(names[id]);
                output.add(account);
            }
        }

        return output;
    }
}
