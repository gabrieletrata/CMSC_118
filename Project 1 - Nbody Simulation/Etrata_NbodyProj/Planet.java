
/**
 * The Planet class is composed of all the neccessary
 * components that a planet must have in order to run in an N-body simulation.
 * 
 * @Gabriel Etrata
 * @v1.0
 */
public class Planet
{
  double G =  6.673e-11; //Gravitational constant.
  private double px; //the x-coordinate position of planet 
  private double py; //the y-coordinate position of planet 
  private double vx; //the x component of planet's velocity 
  private double vy; //y component of planet's velocity 
  private double m;  //the planet's mass 
  private String file; //the Planet's picture file name e.g. "earth.gif", "venus,gif," etc.
  
  /**
   * Constructor for objects of type Planet.
   *
   * @param px the x-coordinate position of planet. 
   * @param py the y-coordinate position of planet.
   * @param vx the x component of planet's velocity. 
   * @param vy the y component of planet's velocity. 
   * @param m the planet's mass. 
   * @param file the Planet's picture file name e.g. "earth.gif", "venus,gif," etc.
   */
  public Planet(double px, double py, double vx, double vy, double m, String file){ 
    this.px = px;
    this.py = py;
    this.vx = vx;
    this.vy = vy;
    this.m = m;
    this.file = file;
  }   
    
  /**
   * Calls picture() method in StdDraw class and displays images of the planets.
   */
  public void display(){
      StdDraw.picture(px, py, file); 
  }
    
  /**
    * Updates planet's position and velocity.
    * 
    * @param fx the force in the x-direction acting on a planet by another planet.
    * @param fy the force in the y-direction acting on a planet by another planet.
    * @param dt change in time.
    */
  public void updatePosition(double fx, double fy, double dt){
    vx += dt*fx/m;
    vy += dt*fy/m;
    px += dt*vx;
    py += dt*vy;
  }
    
  /**
    * Calculates the force in the x-direction acting on a planet by another planet.
    * 
    * @param other terminology for the planet being acted upon.
    * 
    * @return FX the force in the x-direction acting on a planet by another planet.
    */
  public double calculateFX(Planet other){ 
    double dx = (other.px - this.px);
    double dy = (other.py - this.py);
    double r = Math.sqrt(dx*dx + dy*dy);
    double F = (G * this.m * other.m) / (r*r);
    double FX = F * dx / r; 
    return FX;
    }
    
  /**
    * Calculates the force in the y-direction acting on a planet by another planet.
    * 
    * @param other terminology for the planet being acted upon. 
    * 
    * @return FY force in the y-direction acting on a planet by another planet.
    */
  public double calculateFY(Planet other){ 
    double dx = (other.px - this.px);
    double dy = (other.py - this.py);
    double r = Math.sqrt(dx*dx + dy*dy);
    double F = (G * this.m * other.m) / (r*r);
    double FY = F * dy / r;
    return FY;
   }
}