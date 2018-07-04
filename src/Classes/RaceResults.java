

package Classes;

import game.Contracts.ClassificationContract;
import game.Contracts.PilotContract;
import game.Contracts.RaceResultsComparator;
import game.classes.RaceResultsAbstract;
import game.classes.VehicleAbstract;
import game.classes.VehicleManagement;
import game.collections.ClassificationManagementContract;
import java.io.IOException;
import org.json.simple.parser.ParseException;


public class RaceResults extends RaceResultsAbstract implements RaceResultsComparator {

    @Override
    public ClassificationManagementContract getClassificationManagementContract() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveResultsToFile() throws IOException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveMultiPlayerResultsToFile(ClassificationContract cc, VehicleManagement vm) throws IOException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClassificationManagementContract loadResultsFromFile() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClassificationContract mapLoadingResults() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addClassification(ClassificationContract cc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PilotContract getBestTotalTimePlayerFromFile(int i) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClassificationContract getBestLapClassificationVehicleFromFile(VehicleAbstract va) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDifBetweenBestWorstFromFile(int i) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(RaceResultsComparator rrc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
