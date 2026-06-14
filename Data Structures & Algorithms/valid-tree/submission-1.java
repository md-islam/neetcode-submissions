class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<Integer>());
        }
        for( int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<Integer>();
        boolean result = validTreeHelper(0,-1, graph, visited);
        return result && visited.size() == n;
    }

    public boolean validTreeHelper(int currentNode, int prevNode, 
            Map<Integer, List<Integer>> graph, Set<Integer> visited) {
                if(visited.contains(currentNode)){
                    return false;
                }
                visited.add(currentNode);
                List<Integer> neighbors = graph.get(currentNode);
                for(int neighbor: neighbors){
                    if(prevNode != neighbor){
                        boolean result = validTreeHelper(
                            neighbor, currentNode, graph, visited);
                        if (!result){
                            return false;
                        }
                    }
                }
                return true;
    }
}
