
package Classes;

import game.classes.VehicleManagement;
import java.util.Arrays;


public class VehicleManage  extends VehicleManagement{
    
    private final int DEFAULT_SIZE = 4;
    private Object[] objects;

    public VehicleManage() {
        
    }
    
    @Override
    public boolean addObject(Object newObject){
        return false;
    
    
    }
    
    @Override
    public int size(){
        return 0;
    
    }
    
    @Override
    public Object getObject(int position){
        return null;
    
    }

    @Override
    public String toString() {
        return "VehicleManage{" + "DEFAULT_SIZE=" + DEFAULT_SIZE + ", objects=" + Arrays.toString(objects) + '}';
    }
    
    
    
}
