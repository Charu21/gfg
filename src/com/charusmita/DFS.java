package com.charusmita;

import java.util.*;

public class DFS {
    public static void main(String[] args){
        System.out.println("PERFORM DFS");

        Node n1 = new Node(1,false);
        Node n2 = new Node(2,false);
        Node n3 = new Node(3,false);
        Node n4 = new Node(4,false);
        Node n5 = new Node(5,false);
//        Node n6 = new Node(6,false);

        Graph g = new Graph();
        Map<Node, Set<Node>> m = new HashMap<>();
//        m.putIfAbsent(n1, new TreeSet<Node>(Arrays.asList(n2,n3)));
//        m.putIfAbsent(n2, new TreeSet<Node>(Collections.singleton(n4)));
//        m.putIfAbsent(n3, new TreeSet<Node>(Arrays.asList(n4,n5)));
//        m.putIfAbsent(n4, new TreeSet<Node>(Collections.singleton(n6)));
//        m.putIfAbsent(n5, new TreeSet<Node>(Collections.singleton(n6)));
        //        m.putIfAbsent(n1, new TreeSet<Node>(Arrays.asList(n2,n3)));
//        m.putIfAbsent(n2, new TreeSet<Node>(Collections.singleton(n4)));

        m.putIfAbsent(n1, new TreeSet<Node>(Collections.singleton(n2)));
        m.putIfAbsent(n3, new TreeSet<Node>(Collections.singleton(n4)));
        m.putIfAbsent(n4, new TreeSet<Node>(Collections.singleton(n5)));

        g.setAdjList(m);
      printDfs(g, n1);
    }

    //static List<Node> result = new ArrayList<>();
    public static void printDfs(Graph graph, Node start) {
            dfs(graph,start);
    }
    public static void dfs(Graph g, Node start){
        System.out.println(start.getData());
        start.setVisited(true);
        if(!g.getAdjList().containsKey(start))
            return;
        for(Node n: g.getAdjList().get(start)){
            if(!n.isVisited()){
                dfs(g,n);
            }
        }
    }
    public static class Graph{

        Map<Node, Set<Node>> adjList;

        public Graph(){
            this.adjList = new HashMap<>();
        }
        public Map<Node, Set<Node>> getAdjList() {
            return adjList;
        }

        public void setAdjList(Map<Node, Set<Node>> adjList) {
            this.adjList = adjList;
        }

    }
    public static class Node implements Comparable<Node>{
        private int data;
        private boolean visited;

        Node(int data, boolean visited){
            this.data = data;
            this.visited = visited;
        }

        public int getData() {
            return data;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }


        @Override
        public int compareTo(Node o) {
            return this.getData() - o.getData();
        }
    }
}
