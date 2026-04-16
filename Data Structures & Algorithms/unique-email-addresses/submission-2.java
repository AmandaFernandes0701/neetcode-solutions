class Solution {
    public int numUniqueEmails(String[] emails) {

        HashSet<String> uniqueEmails = new HashSet<>();

        for(String email: emails)
        {
            StringBuilder currEmail = new StringBuilder();
            int finalIdx = email.indexOf("@");

            for(int i = 0; i < finalIdx; i++)
            {
                char currChar = email.charAt(i);

                if(currChar == '.') continue;
                else if(currChar == '+') break;
                else currEmail.append(currChar);
            }

            for(int i = finalIdx; i < email.length(); i++)
                currEmail.append(email.charAt(i));
            
            uniqueEmails.add(currEmail.toString());
        }

        return uniqueEmails.size();
        
    }
}