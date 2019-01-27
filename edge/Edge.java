package edge;
import vertex.*;


public class Edge {
    private Vertex source, destination;
    private double distance;

    /**
     *
     * @param source: this is the initial vertex
     * @param destination: this is the final vertex
     * @param distance: this is the distance between the two vertex
     */
    public Edge (Vertex source, Vertex destination, double distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }//Edge

    /**
     *
     * @return: this method returns the distance of the object
     */
    public double getDistance() {
        return distance;
    }//getDistance

    /**
     *
     * @return: this method returns the initial vertex of the object
     */
    public Vertex getSource() {
        return this.source;
    }//getSource

    /**
     *
     * @return: this method returns the final vertex of the object
     */
    public Vertex getDestination() {
        return this.destination;
    }//getDestination

    /**
     *
     * @return: this method returns a print of the initial vertex connected to the final vertex
     */
    @Override
    public String toString(){
        return this.source.getName() + " --> " +  this.destination.getName();
    }//toString

}//class
