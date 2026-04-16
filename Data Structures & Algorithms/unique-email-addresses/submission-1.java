class Solution {
    public int numUniqueEmails(String[] emails) {

        HashSet<String> set = new HashSet<>();

        for (String email : emails) {

            String[] parts = email.split("@");

            String local = parts[0];
            String domain = parts[1];

            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            local = local.replace(".", "");

            String normalized = local + "@" + domain;

            set.add(normalized);
        }

        return set.size();
    }
}