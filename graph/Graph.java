package graph;

import priorityqueue.*;
import edge.*; 
import vertex.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Graph {
    private HashMap<Vertex, ArrayList<Edge>> adj;


    public Graph() {
        this.adj = new HashMap<Vertex, ArrayList<Edge>>();
    }//Graph

    /**
     *
     * @return: this method returns the Graph inside the Hashmap
     */
    public HashMap<Vertex, ArrayList<Edge>> getGraph() {
        return this.adj;
    }//HashMap

    /**
     * this method takes all input line and divides it into three parts, source, destination and distance,
     * after that it creates the Edge and its inverse, so checks if the Edge is present in the Hashmap
     * and insert it into the ArrayList,
     * else the method inserts the Edge into the map and adds it into the ArrayList, the same for the reverse Edge.
     * @param par: this is the input line of the file
     */
    public void add(String[] par) {
        if (par == null) return;
        Vertex v1 = new Vertex(par[0]);
        Vertex v2 = new Vertex(par[1]);
        Edge edge = new Edge(v1, v2, Double.parseDouble(par[2]));
        Edge edgeRev = new Edge(v2, v1, Double.parseDouble(par[2]));
        ArrayList<Edge> tmp;
        ArrayList<Edge> arr;
        if (this.adj.containsKey(v1)) {
            tmp = this.adj.get(v1);
            tmp.add(edge);
        }
        else {
            arr = new ArrayList<Edge>();
            arr.add(edge);
            this.adj.put(v1, arr);
        }
        if (this.adj.containsKey(v2)) {
            tmp = this.adj.get(v2);
            tmp.add(edgeRev);
        }
        else {
            arr = new ArrayList<Edge>();
            arr.add(edgeRev);
            this.adj.put(v2, arr);
        }
    }//add

    /**
     *
     * @return: this methods return the number of key mappings in the map
     */
    public int size() {
        return this.adj.size();
    }//size

    /**
     *
     * @return: this method returns the PriorityQueue loaded of all vertex in graph
     * @throws PriorityQueueException: throws an error if the element that we try to insert into the queue is null
     */
    public PriorityQueue<Vertex> createQueue()throws PriorityQueueException{
        PriorityQueue<Vertex> Q = new PriorityQueue<>();
        Iterator it = adj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            Q.insert(((Vertex)entry.getKey()).getKey(), ((Vertex)entry.getKey()));
        }
        return Q;
    }//createQueue

    /**
     *
     * @param v: this is the Vertex on which we have to find the key
     * @param Q: this is the PriorityQueue on we saved the Vertexs
     * @return: this method returns the key of the Vertex in the PriorityQueue
     * @throws PriorityQueueException: throws an error when there is not the element in the map
     */
    public Double getVertexKeyInQueue(Vertex v, PriorityQueue<Vertex> Q) throws PriorityQueueException{
        double key = Double.MAX_VALUE;
        if (Q.contains(v)){
            Vertex vt = (Vertex)Q.getElem(Q.getIndexOf(v)).getElem();
            key = vt.getKey();
        }
        return key;
    }//getVertexInQueue

    //return an array with the edges of the minimum spanning tree

    /**
     * this algorithm is a greedy algorithm that finds a minimum spanning tree for a weighted undirected graph,
     * so it find a subset of edges that form a tree with all vertex with the smallest weight.
     * @return: this method returns the array with the edges of the minimum spanning tree
     * @throws PriorityQueueException: throws an error when there is not the element in the map or the element is null
     */
    public ArrayList<Edge> prim ()throws PriorityQueueException{
        ArrayList<Edge> A = new ArrayList<>();
        PriorityQueue<Vertex> Q = createQueue();
        Q.getMax().setPr(0);
        ((Vertex)Q.getMax().getElem()).setKey(0);
        Vertex u,v;
        int i,j;
        Edge e;
        Double vKey;
        while(Q.size()>1){
            u = Q.extractMax();
            if (u.getParent() != null)
                A.add(new Edge(u.getParent(), u, u.getKey()));
            for (i=0; i<adj.get(u).size(); i++){
                e = adj.get(u).get(i);
                v = e.getDestination();
                vKey = getVertexKeyInQueue(v, Q);
                if ((Q.contains(v)) && (e.getDistance()<vKey)){
                    j = Q.getIndexOf(v);
                    ((Vertex)Q.getElem(j).getElem()).setParent(u);
                    ((Vertex)Q.getElem(j).getElem()).setKey(e.getDistance());
                    Q.updateKey(v, ((Vertex) Q.getElem(j).getElem()).getKey());
                }
            }
        }
        return A;
    }//prim

}//class
