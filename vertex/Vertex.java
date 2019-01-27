package vertex;

public class Vertex {
    private String name;
    private double key;
    public Vertex parent;

    /**
     *
     * @param name: This is the name of the object
     */
    public Vertex(String name){
        this.name = name;
        this.key = Double.MAX_VALUE;
        this.parent = null;
    }//Vertex

    /**
     *
     * @return: this method returns the name of the object
     */
    public String getName() {
        return this.name;
    }//getName

    /**
     *
     * @return: this method returns the parent of the object
     */
    public Vertex getParent() {
        return this.parent;
    }//getParent

    /**
     *
     * @return: this method returns the key of the object
     */
    public double getKey() {
        return this.key;
    }//getKey

    /**
     *
     * @param key: this is the new key of the object
     */
    public void setKey(double key) {
        this.key = key;
    }//setKey

    /**
     *
     * @param parent: this is the new parent of the object
     */
    public void setParent(Vertex parent){
        this.parent = parent;
    }//setParent

    /**
     *
     * @param o: this is the second object
     * @return: this method returns true if the name between the caller and the second object si equal, or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return name.equals(vertex.name);
    }//equals

    /**
     *
     * @return: this method returns the hash code value for the caller object
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }//hashCode

}//class
