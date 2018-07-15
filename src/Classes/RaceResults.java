/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */


package Classes;

import Management.ClassificationManagement;
import game.Contracts.ClassificationContract;
import game.Contracts.PilotContract;
import game.Contracts.RaceResultsComparator;
import game.classes.RaceResultsAbstract;
import game.classes.VehicleAbstract;
import game.classes.VehicleManagement;
import game.collections.ClassificationManagementContract;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class RaceResults extends RaceResultsAbstract implements RaceResultsComparator {

    
    private ClassificationManagementContract classManagement;
    private ClassificationContract classification;

    
    @Override
    public ClassificationManagementContract getClassificationManagementContract() {
        return this.classManagement;
    }

    @Override
    public boolean saveResultsToFile() throws IOException, ParseException {
           
        JSONArray obj = new JSONArray();
        
        for(int i=0; i<this.classManagement.size(); i++){
        JSONObject classificacoes = new JSONObject();
        JSONObject posDetails = new JSONObject();
        classificacoes.put("Position", i+1);
        //obj.add(classificacoes);
        posDetails.put("Vehicle",(String)(((Classification)this.classManagement.getObject(i)).getVehicle().getName()));
	posDetails.put("PilotName",(String)(((Classification)this.classManagement.getObject(i)).getPilot().getName()));
	posDetails.put("PilotId",(int)(((Classification)this.classManagement.getObject(i)).getPilot().getId()));
        posDetails.put("BestLap",(double)(((Classification)this.classManagement.getObject(i)).getBestLap()));
        posDetails.put("TotalLaps",(int)(((Classification)this.classManagement.getObject(i)).getTotalLaps()));
        posDetails.put("BestTime",(double)(((Classification)this.classManagement.getObject(i)).getTotalTime()));
	classificacoes.put("positionDetails", posDetails);
        obj.add(classificacoes);
        }
 
	try (FileWriter file = new FileWriter(this.classification.getLevel()+".json")) {
		file.write(obj.toJSONString());
		System.out.println("Successfully Copied JSON Object to File...");
	}
        return true;
    }

    @Override
    public boolean saveMultiPlayerResultsToFile(ClassificationContract cc, VehicleManagement vm) throws IOException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   

    @Override
    public ClassificationManagementContract loadResultsFromFile() throws IOException {
      
        
        try {
            FileReader reader = new FileReader(this.classification.getLevel()+".json");
            JSONParser jsonparser = new JSONParser();
            Object jsonobject = jsonparser.parse(reader);
            //JSONArray classif = (JSONArray) jsonobject.get("");
            JSONArray classif = (JSONArray) (Object)jsonobject;
            //super.setBounds(getArrayData(bound));
            
            for(int i = 0; i < classif.size(); i++){
                JSONObject obj = (JSONObject)classif.get(i);
                JSONObject objdetails = (JSONObject)obj.get("positionDetails");
                VehicleAbstract car = new Vehicle((String)objdetails.get("Vehicle"));
                Classification loadClassification = new Classification();
                Pilot piloto = new Pilot();
                
                loadClassification.setTotalTime((double)objdetails.get("BestTime"));
                
                piloto.setName((String)objdetails.get("PilotName"));
                piloto.setId((int)(long)objdetails.get("PilotId"));
                
                car.setPilot(piloto);
                
                loadClassification.setPilot(piloto);
                loadClassification.setVehicle(car);
                loadClassification.setBestLap((double)objdetails.get("BestLap"));
                loadClassification.setTotalLaps((int)(long)objdetails.get("TotalLaps"));
                
                
                this.classManagement.addObject(loadClassification);
            }
        } catch (ParseException ex) {
        }
        
        
        return this.classManagement;
    }

    @Override
    public ClassificationContract mapLoadingResults() throws IOException {
         
        
        loadResultsFromFile();
        
        
        if(((ClassificationManagement)this.classManagement).size()<7){
            this.classManagement.addObject(classification);
            ((ClassificationManagement)this.classManagement).sort();
        }else if(this.classification.getBestLap()<(double)(((Classification)this.classManagement.getObject(6)).getBestLap())){
            this.classManagement.decreaseSize();
            this.classManagement.increaseSize();
            this.classManagement.addObject(classification);
            ((ClassificationManagement)this.classManagement).sort();
        }else if(this.classification.getBestLap()>(double)(((Classification)this.classManagement.getObject(6)).getBestLap())){
            System.out.println("Tempo demasiado elevado, não se conseguiu ficar entre os 7 melhores.");
        }
        
        return this.classification;
    }

    @Override
    public void addClassification(ClassificationContract cc) {
        this.classification= cc;
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
