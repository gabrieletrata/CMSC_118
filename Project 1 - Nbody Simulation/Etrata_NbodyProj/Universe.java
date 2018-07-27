
/**
 * The Universe class is composed of all the neccessary
 * components that the universe must have in order to run a N-body simulation.
 * 
 * @Gabriel Etrata
 * @v1.0
 */
public class Universe
{
    private double endT; //End time of the simulation.
    private double deltaT; //Time step of the simulation.
    private String universeFile; //Input file name containing planetary information.
    private double radius = 2.5e11; //Radius of the universe.
    Planet[] planetArray; //Array of planets.
    
    /**
     * Main method for Universe class. 
     */
    public static void main(String[] args){ 
     StdAudio.loop("2001.mid");
     StdDraw.setCanvasSize(512, 512);
     Universe u = new Universe(1577788000.0, 25000.0, "planets.txt");
     u.readUniverse();
     u.runSimulation();
    }
    
    /**
     * Constructor for objects of type Universe.
     * 
     * @param endT the end time of the simulation.
     * @param deltaT time step of the simulation.
     * @param universeFile input file name containing planetary information.
     */
    public Universe(double endT, double deltaT, String universeFile){
     this.endT = endT;
     this.deltaT = deltaT;
     this.universeFile = universeFile;
    }
    
    /**
     * Calls the displayUniverse() and runPhysics() methods and runs the simulation for a given amount of time, endT.
     */
    public void runSimulation(){ 
        for(double t = 0; t < endT; t = t + deltaT){
          this.displayUniverse();
          this.runPhysics();
        }
    }
    
     /**
      * Reads the text file containing information about the universe. Populates appropriate attributes, including the planet array.
      */
    public void readUniverse(){ 
     In planetList = new In("planets.txt");
     int N = planetList.readInt();
     planetArray = new Planet[N]; 
     double r = planetList.readDouble();
        for(int i = 0; i < N; i++){
        double px = planetList.readDouble();
        double py = planetList.readDouble();
        double vx = planetList.readDouble();
        double vy = planetList.readDouble();
        double m =  planetList.readDouble();
        String planName = planetList.readString();
        planetArray[i]  = new Planet(px, py, vx, vy, m, planName);
       }
    }
    
    /**
     * Displays a frame of the animation, including displaying all planets by calling the display() method in the Planet class.
     */
    public void displayUniverse(){ 
    StdDraw.setXscale(-radius, radius);
    StdDraw.setYscale(-radius, radius);
    StdDraw.clear();
    StdDraw.picture(0, 0, "starfield.jpg", 2*radius, 2*radius);
        for(int i = 0; i < planetArray.length; i++) {
        planetArray[i].display();
       }
    StdDraw.show(5);
    }
    
    /**
     * Goes through each planet, calculates the force on it, and updates planetary positions/velocities by calling the updatePosition() method in the Planet class.
     */
    public void runPhysics(){
        for(int i = 0; i < planetArray.length; i++){ 
            double FX = 0.0;
            double FY = 0.0;
            for(int j = 0; j < planetArray.length; j++){
               if(i != j){
                FX += planetArray[i].calculateFX(planetArray[j]);
                FY += planetArray[i].calculateFY(planetArray[j]);
               }
            }
            planetArray[i].updatePosition(FX, FY, deltaT);
        }
    }
}