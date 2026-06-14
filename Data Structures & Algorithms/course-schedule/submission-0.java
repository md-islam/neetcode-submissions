class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqMap = new HashMap<Integer, List<Integer>>();
        Set<Integer> visiting = new HashSet<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        //build Map
        for(int i = 0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<Integer>());
        }

        for (int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            prereqMap.get(course)
                .add(prereq);
        }

        for (int course = 0; course < numCourses; course++){
            boolean result = canFinishHelper(course, prereqMap, visiting, visited);
            if(!result){
                return false;
            }
        }
        return true;
    }

    private boolean canFinishHelper(int course, 
                                    Map<Integer, List<Integer>> prereqMap,
                                    Set<Integer> visiting,
                                    Set<Integer> visited) {
        if(visited.contains(course)){return true;}
        if(visiting.contains(course)){return false;}
        visiting.add(course);
        List<Integer> prereqs = prereqMap.get(course);
        for(int prereq : prereqs){
            boolean result = canFinishHelper(prereq, prereqMap, visiting, visited);
            if(!result) {
                return false;
            }
        }
        visiting.remove(course);
        visited.add(course);
        return true;
    }
}
