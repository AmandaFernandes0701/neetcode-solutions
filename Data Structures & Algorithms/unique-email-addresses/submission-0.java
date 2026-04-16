class Solution {
    public int numUniqueEmails(String[] emails) {

        HashSet<String> uniqueEmails = new HashSet<>();

        for(String email : emails)
        {
            String[] fullEmail = email.split("@");
            String[] tempDomain = fullEmail[0].split("\\+");
            String domain = tempDomain[0].replace(".","");
            uniqueEmails.add(domain + "@" + fullEmail[1]);     
        }

        return uniqueEmails.size();
        
    }
}