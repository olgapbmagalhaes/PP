/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */
package Classes;

import game.Contracts.PilotContract;
import game.classes.VehicleAbstract;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Vehicle extends VehicleAbstract {

    private double speedVehicle, breakPadVehicle, w, h;
    private int directionVehicle;
    private String type, model, name;
    private PilotContract pilot;
    private double[] bounds;

    /**
     * Construtor para inicializar um veículo
     *
     * @param name - o nome do veículo
     */
    public Vehicle(String name) {
        super(name);
    }

    /**
     *
     * @param string
     * @return
     * @throws IOException
     */
    @Override
    public boolean mappingBounds(String string) throws IOException {
       try {
            FileReader reader = new FileReader(string);
            JSONParser jsonparser = new JSONParser();
            JSONObject jsonobject = (JSONObject) jsonparser.parse(reader);
            JSONArray bound = (JSONArray) jsonobject.get("Bounds");
            this.setBounds((getArrayData(bound)));
            this.type = (String) jsonobject.get("Type");
            this.model = (String) jsonobject.get("Model");
            this.speedVehicle = (double) jsonobject.get("Speed");
            this.directionVehicle = ((int) ((long)jsonobject.get("Direction")));
            this.breakPadVehicle = (double) jsonobject.get("Break");
        } catch (ParseException ex) {
            return false;
        }
        return true; 

    }
    
      public double[] getArrayData(JSONArray a){
        double[] aux = new double[a.size()];
        for(int i=0; i<a.size(); i++){
            aux[i] = (double) a.get(i);
        }
        return aux;
    }

    /**
     * Método responsável por retornar a velocidade do veículo
     *
     * @return a velocidade do veículo
     */
    @Override
    public double getSpeedVehicle() {
        return this.speedVehicle;
    }

    /**
     * Método responsável por retornar a direção do veículo
     *
     * @return a direção do veículo
     */
    @Override
    public int getDirectionVehicle() {
        return this.directionVehicle;
    }

    /**
     * Método responsável por retornar o travão do veículo
     *
     * @return o travão do veículo
     */
    @Override
    public double getBreakPadVehicle() {
        return this.breakPadVehicle;
    }

    /**
     * Método responsável por retornar o tipo do veículo
     *
     * @return o tipo do veículo
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Método responsável por retornar o modelo do veículo
     *
     * @return o modelo do veículo
     */
    @Override
    public String getModel() {
        return this.model;
    }

    /**
     * Método responsável por especificar o piloto do veículo
     *
     * @param pc - o piloto do veículo
     */
    @Override
    public void setPilot(PilotContract pc) {
        this.pilot = pc;
    }

    /**
     * Método responsável por retornar o nome do veículo
     *
     * @return o nome do veículo
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Método responsável por especificar o nome do veículo
     *
     * @param string - o nome do veículo
     */
    @Override
    public void setName(String string) {
        this.name = string;
    }

    /**
     * Método responsável por retornar o piloto do veículo
     *
     * @return o piloto do veículo
     */
    @Override
    public PilotContract getPilot() {
        return this.pilot;
    }

    /**
     * Método responsável por retornar o tamanho horizontal em píxeis da imagem
     * do veículo
     *
     * @return o peso do veículo
     */
    @Override
    public double getW() {
        return this.w;
    }

    /**
     * Método responsável por especificar o tamanho horizontal em píxeis da
     * imagem do veículo
     *
     * @param d - o peso do veículo
     */
    @Override
    public void setW(double d) {
        this.w = d;
    }

    /**
     * Método responsável por retornar o tamanho vertical em píxeis da imagem do
     * veículo
     *
     * @return a altura do veículo
     */
    @Override
    public double getH() {
        return this.h;
    }

    /**
     * Método responsável por especificar o tamanho vertical em píxeis da imagem
     * do veículo
     *
     * @param d - a altura do veículo
     */
    @Override
    public void setH(double d) {
        this.h = d;
    }

    /**
     * Método responsável por retornar os limites do veículo
     *
     * @return os limites do veículo
     */
    @Override
    public double[] getBounds() {
        return this.bounds;
    }

    public void setBounds(double[] bounds) {
        this.bounds = bounds;
    }
    
    


    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Vehicle{"
                + "speedVehicle=" + speedVehicle
                + ", breakPadVehicle=" + breakPadVehicle
                + ", w=" + w
                + ", h=" + h
                + ", directionVehicle=" + directionVehicle
                + ", type=" + type
                + ", model=" + model
                + ", name=" + name
                + ", pilot=" + pilot
                + ", bounds=" + Arrays.toString(bounds)
                + '}';
    }

}
