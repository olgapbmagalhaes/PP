/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */
package Main;

import Classes.Classification;
import Classes.Level;
import Classes.Pilot;
import Classes.RaceResults;
import Classes.Vehicle;
import Management.VehicleeManagement;
import game.Contracts.LevelContract;
import game.Contracts.PilotContract;
import game.classes.RacingGame;
import game.classes.VehicleAbstract;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;

public class PP_EPR {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        
        PilotContract olga = new Pilot("Olga", 1, KeyCode.W, KeyCode.S, KeyCode.A, KeyCode.D);
        PilotContract patricia = new Pilot("Patricia", 2, KeyCode.KP_UP, KeyCode.KP_DOWN, KeyCode.KP_LEFT, KeyCode.KP_RIGHT);
        
        VehicleAbstract carro = new Vehicle("Carro");
        VehicleAbstract mota = new Vehicle("Mota");
       

        mota.setPathToImage("files\\vehicleImages\\car1.png");
        mota.mappingBounds("files\\vehicleJSON\\car.json");
        mota.setPilot(patricia);
        carro.setPathToImage("files\\vehicleImages\\car1.png");
        carro.mappingBounds("files\\vehicleJSON\\car.json");
        carro.setPilot(olga);
        /*
        mota.setH(16);
        mota.setW(36);
        carro.setH(20);
        carro.setW(40);*/
        
        LevelContract level01 = new Level();
        level01.setPathToImage("files\\levelImages\\level02.png");
        level01.mappingBounds("files\\levelsJSON\\level2.json");
        level01.setName("Nivel 01");

        Classification classification = new Classification();
       // classification.setVehicle(carro);
        
        RaceResults race = new RaceResults();
        RacingGame game = new RacingGame();
        //RacingGame.multiplayerMode = true;
        
        VehicleeManagement manager = new VehicleeManagement();
        manager.addObject(carro);
        manager.addObject(mota);
        
        game.addLevel(level01);
        game.addVehicle(carro);
        game.addVehicle(mota);
        game.addNumberOfLaps(1);
        game.setClassification(classification);
        game.setRaceResults(race);
        
        
         try {
            game.startGame();
        } catch (Exception ex) {
            Logger.getLogger(PP_EPR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //System.out.println(olga.toString());
        //System.out.println(carro.toString());
        //System.out.println(level01.toString());
        
    }

}


        