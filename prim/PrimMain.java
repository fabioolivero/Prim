package prim;

import edge.*;
import graph.*;
import java.io.*;
import java.util.ArrayList;

public class PrimMain {

    public static void main(String[] args) throws Exception{

        String path = "italian_dist_graph.csv";
        Graph graph = new Graph();
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(path));
            while ((sCurrentLine = br.readLine()) != null) {
                String[] fields = sCurrentLine.split(",");
                graph.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        ArrayList<Edge> ris;
        ris = graph.prim();
        System.out.println("Numero nodi:      "+graph.size());
        System.out.println("Numero archi:     "+ris.size());
        double dist = 0;
        for(int i=0; i<ris.size(); i++)
            dist += ris.get(i).getDistance();
        System.out.printf("Peso complessivo: %.3f Km\n",dist/1000);

    }//main
}//Main
