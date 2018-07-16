/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */
package Classes;

import game.Contracts.LevelContract;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Level implements LevelContract {

    private String name;
    private String pathToImage;
    private double[] lowerBounds, upperBounds, checkPoints, startCar;

    /**
     * Método responsável por retornar o nome do nível
     *
     * @return o nome do nível
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Método responsável por especificar o nome do nivel
     *
     * @param string - o nome do nivel
     */
    @Override
    public void setName(String string) {
        this.name = string;
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
     * Método responsável por carregar os limites do nível a partir de ficheiro
     *
     * @param string - ficheiro onde estão definidos os limites do nível
     * @return o sucesso ou insucesso da operação
     * @throws IOException - excepção a ser lançada em caso de erro na leitura
     * do ficheiro
     */
    @Override
    public boolean mappingBounds(String string) throws IOException {

        try {
            FileReader reader = new FileReader(string);
            JSONParser jsonparser = new JSONParser();
            JSONObject jsonobject = (JSONObject) jsonparser.parse(reader);
            JSONArray lowerBound = (JSONArray) jsonobject.get("LowerBound");
            this.setUpperBounds(getJSONtoDouble(lowerBound));
            JSONArray upperBound = (JSONArray) jsonobject.get("UpperBound");
            this.setLowerBounds(getJSONtoDouble(upperBound));
            JSONArray check = (JSONArray) jsonobject.get("Checkpoints");
            this.setCheckpoints(getJSONtoDouble(check));
            JSONArray initialCar = (JSONArray) jsonobject.get("StartCar");
            this.setStartCar(getJSONtoDouble(initialCar));
        } catch (ParseException ex) {
            return false;
        }
        return true;

    }

    /**
     * Método responsável por retornar o caminho para a imagem do nível
     *
     * @return o caminho para a imagem do nivel
     */
    @Override
    public String getPathToImage() {
        return this.pathToImage;
    }

    /**
     * Método responsável por especificar o caminho para a imagem do nível
     *
     * @param string - o caminho para a imagem do nivel
     */
    @Override
    public void setPathToImage(String string) {
        this.pathToImage = string;
    }

    /**
     * Método responsável por retornar os limites inferiores do nível
     *
     * @return um array com os limites inferiores do nível
     */
    @Override
    public double[] getLowerBounds() {
        return this.lowerBounds;
    }

    /**
     * Método responsável por retornar os limites superiores do nível
     *
     * @return um array com os limites superiores do nível
     */
    @Override
    public double[] getUpperBounds() {
        return this.upperBounds;
    }

    /**
     * Método responsável por retornar a localização dos checkpoints do nível
     *
     * @return um array com a localização dos checkpoints do nível
     */
    @Override
    public double[] getCheckPoints() {
        return this.checkPoints;
    }

    /**
     * Método reponsável por retornar a localização inicial do veículo
     *
     * @return um array com a localização inicial do veículo
     */
    @Override
    public double[] getStartCar() {
        return this.startCar;
    }

    /**
     * Método responsável por especiicar os limites inferiores do nível
     *
     * @param lowerBounds - os limites inferiores do nivel
     */
    public void setLowerBounds(double[] lowerBounds) {
        this.lowerBounds = lowerBounds;
    }

    /**
     * Método responsável por especificar os limites superiores do nível
     *
     * @param upperBounds - os limites superiores do nivel
     */
    public void setUpperBounds(double[] upperBounds) {
        this.upperBounds = upperBounds;
    }

    /**
     * Método responsável por especificar a localização dos checkpoints do nível
     *
     * @param checkPoints - a localização dos checkpoints do nivel
     */
    public void setCheckpoints(double[] checkPoints) {
        this.checkPoints = checkPoints;
    }

    /**
     * Método reponsável por especificar a localização inicial do veículo
     *
     * @param startCar - um array com a localização inicial do veículo
     */
    public void setStartCar(double[] startCar) {
        this.startCar = startCar;
    }

    /**
     * Método que retorna uma string com toda a informação relativa ao nivel
     *
     * @return uma string com toda a informação relativa ao nivel
     */
    @Override
    public String toString() {
        return "Level{"
                + "name=" + name
                + ", pathToImage=" + pathToImage
                + ", lowerBounds=" + Arrays.toString(lowerBounds)
                + ", upperBounds=" + Arrays.toString(upperBounds)
                + ", checkPoints=" + Arrays.toString(checkPoints)
                + ", startCar=" + Arrays.toString(startCar)
                + '}';
    }

}
