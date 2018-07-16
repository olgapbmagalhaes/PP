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
     * Método construtor para inicializar um veículo
     *
     * @param name - o nome do veículo
     */
    public Vehicle(String name) {
        super(name);
    }

    /**
     * Método responsável por converter um array do tipo json num array do tipo
     * double
     *
     * @param json -
     * @return o array do tipo double
     */
    public double[] getJSONtoDouble(JSONArray json) {
        double[] db = new double[json.size()];
        for (int i = 0; i < json.size(); i++) {
            db[i] = (double) json.get(i);
        }
        return db;
    }

    /**
     * Método responsável por mapear os limites do veículo
     *
     * @param string - o caminho para o ficheiro que contém os limites do
     * veículo
     * @return o sucesso ou insucesso da operação
     * @throws IOException - a exceção genérica
     */
    @Override
    public boolean mappingBounds(String string) throws IOException {
        try {
            FileReader reader = new FileReader(string);
            JSONParser jsonparser = new JSONParser();
            JSONObject jsonobject = (JSONObject) jsonparser.parse(reader);
            this.type = (String) jsonobject.get("Type");
            this.model = (String) jsonobject.get("Model");
            this.speedVehicle = (double) jsonobject.get("Speed");
            this.directionVehicle = ((int) ((long) jsonobject.get("Direction")));
            this.breakPadVehicle = (double) jsonobject.get("Break");
            JSONArray bound = (JSONArray) jsonobject.get("Bounds");
            this.setBounds((getJSONtoDouble(bound)));

        } catch (ParseException ex) {
            return false;
        }
        return true;

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

    /**
     * Método responsável por especificar os limites do veículo
     *
     * @param bounds - os limites do veiculo
     */
    public void setBounds(double[] bounds) {
        this.bounds = bounds;
    }

    /**
     * Método que retorna uma string com toda a informação relativa ao veiculo
     *
     * @return uma string com toda a informação do veiculo
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
