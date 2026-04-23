class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int result = students.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int student : students)    
            map.put(student, map.getOrDefault(student, 0) + 1);

        for(int sandwich : sandwiches) 
        {
            if(map.containsKey(sandwich) && map.get(sandwich) > 0)
            {
                map.put(sandwich, map.get(sandwich) - 1);
                result--;
            }
            else return result;
        }
        return result;
    }
}