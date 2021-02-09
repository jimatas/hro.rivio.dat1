package dat1.tests;

import dat1.Queue;

/**
 * @author K. Atas 
 */
public class CarTunnel {
    private final Queue<Car> cars;
    
    /**
     * Constructs a new <tt>CarTunnel</tt>.
     */
    public CarTunnel() {
        cars = new Queue<Car>();
    }
    
    /**
     * Have a car enter this tunnel.
     * 
     * @param car the <tt>Car</tt> that is to enter.
     */
    public void enter(Car car) {
        cars.enqueue(car);
    }
    
    /**
     * Have a car exit this tunnel.
     * 
     * @return the <tt>Car</tt> that just left.
     * @throws dat1.QueueEmptyException if there are no cars in the tunnel.
     */
    public Car exit() {
        return cars.dequeue();
    }
}