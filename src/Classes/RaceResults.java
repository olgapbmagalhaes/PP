/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */
package Classes;

import Management.ClassificationManagement;
import game.Contracts.ClassificationContract;
import game.Contracts.PilotContract;
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

public class RaceResults extends RaceResultsAbstract {

    private ClassificationManagementContract classManagement;
    private ClassificationContract classification;
    private final int TOP = 7;

    /**
     * Método responsável por retornar as classificações obtidas num determinado
     * nível
     *
     * @return a coleção de classificações
     */
    @Override
    public ClassificationManagementContract getClassificationManagementContract() {
        return this.classManagement;
    }

    /**
     * Método responsável por gravar os resultados em ficheiro
     *
     * @return o sucesso ou insucesso da operação
     * @throws IOException - a exceção genérica
     * @throws ParseException - a exceção de parsing
     */
    @Override
    public boolean saveResultsToFile() throws IOException, ParseException {

        JSONArray array = new JSONArray();
        JSONObject obj = new JSONObject();

        for (int i = 0; i < this.classManagement.size(); i++) {
            JSONObject classifications = new JSONObject();
            classifications.put("Position", i + 1);
            //obj.add(classifications);
            obj.put("Vehicle", (String) (((Classification) this.classManagement.getObject(i)).getVehicle().getName()));
            obj.put("PilotName", (String) (((Classification) this.classManagement.getObject(i)).getPilot().getName()));
            obj.put("PilotId", (int) (((Classification) this.classManagement.getObject(i)).getPilot().getId()));
            obj.put("BestLap", (double) (((Classification) this.classManagement.getObject(i)).getBestLap()));
            obj.put("TotalLaps", (int) (((Classification) this.classManagement.getObject(i)).getTotalLaps()));
            obj.put("BestTime", (double) (((Classification) this.classManagement.getObject(i)).getTotalTime()));
            //classifications.put("positionDetails", obj);
            array.add(classifications);
        }
        try (FileWriter file = new FileWriter(this.classification.getLevel() + ".json")) {
            file.write(array.toJSONString());
            System.out.println("Resultados gravados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar resultados em ficheiro!");
        }

        return true;
    }

    /**
     * Método responsável por mapear os resultados na classificação com os
     * resultados guardados em ficheiro
     *
     * @return a classificação
     * @throws IOException - a exceção genérica
     */
    @Override
    public ClassificationContract mapLoadingResults() throws IOException {

        loadResultsFromFile();

        if (((ClassificationManagement) this.classManagement).size() < TOP) {
            this.classManagement.addObject(classification);
            ((ClassificationManagement) this.classManagement).sort();
        } else if (this.classification.getBestLap() < (double) (((Classification) this.classManagement.getObject(6)).getBestLap())) {
            this.classManagement.decreaseSize();
            this.classManagement.increaseSize();
            this.classManagement.addObject(classification);
            ((ClassificationManagement) this.classManagement).sort();
        } else if (this.classification.getBestLap() > (double) (((Classification) this.classManagement.getObject(6)).getBestLap())) {
            System.out.println("Keep on trying to be in Top 7!!");
        }

        return this.classification;
    }

    /**
     * Método responsável por adicionar uma classificação
     *
     * @param cc - classificação
     */
    @Override
    public void addClassification(ClassificationContract cc) {
        this.classification = cc;
    }

    /**
     * Método responsável por retornar um piloto com o melhor resultado ao nível
     * do tempo total, dado o número de voltas. O método deverá procurar no
     * ficheiro armazenado o piloto com melhor resultado ao nível da melhor
     * volta (assuma que o vetor possa estar desordenado).
     *
     * @param i - o número de voltas da corrida
     * @return o piloto
     * @throws Exception - exceção genérica
     */
    @Override
    public PilotContract getBestTotalTimePlayerFromFile(int i) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável por retornar uma classificação dado um veículo. O
     * método deverá procurar no ficheiro armazenado a melhor classificação
     * conseguida por um veículo específico.
     *
     * @param va - o veículo
     * @return a classificação
     * @throws Exception - exceção genérica
     */
    @Override
    public ClassificationContract getBestLapClassificationVehicleFromFile(VehicleAbstract va) throws Exception {

        try {
            FileReader reader = new FileReader(this.classification.getLevel() + ".json");
            JSONParser jsonparser = new JSONParser();
            Object jsonobject = jsonparser.parse(reader);
            JSONArray classif = (JSONArray) (Object) jsonobject;

            for (int i = 0; i < classif.size(); i++) {
                JSONObject obj = (JSONObject) classif.get(i);

            }

        } catch (ParseException ex) {
            System.out.println("Erro ao carregar os resultados do ficheiro");
        }

    }


//
    /**
     * Método responsável por retornar a diferença de tempo entre o melhor e
     * pior resultado dado o número de voltas.
     *
     * @param i - o número de voltas
     * @return a diferença entre tempos melhor e pior
     * @throws Exception - a exceção genérica
     */
    @Override
    public int getDifBetweenBestWorstFromFile(int i) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável por gravar os resulados da corrida multiplayer em
     * ficheiro
     *
     * @param cc - a classificação do vencedor
     * @param vm - os veículos participantes na corrida
     * @return o sucesso ou insucesso da operação
     * @throws IOException - a exceção genérica
     * @throws ParseException - a exceção de parsing
     */
    @Override
    public boolean saveMultiPlayerResultsToFile(ClassificationContract cc, VehicleManagement vm) throws IOException, ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável por ler os resultados a partir de ficheiro
     *
     * @return a gestão da classificação
     * @throws IOException - a exceção genérica
     */
    @Override
    public ClassificationManagementContract loadResultsFromFile() throws IOException {

        try {
            FileReader reader = new FileReader(this.classification.getLevel() + ".json");
            JSONParser jsonparser = new JSONParser();
            Object jsonobject = jsonparser.parse(reader);
            JSONArray classif = (JSONArray) (Object) jsonobject;

            for (int i = 0; i < classif.size(); i++) {
                JSONObject obj = (JSONObject) classif.get(i);
                JSONObject objdetails = (JSONObject) obj.get("positionDetails");
                Vehicle vehicle = new Vehicle((String) objdetails.get("Vehicle"));
                Classification clas = new Classification();
                Pilot pilot = new Pilot();

                clas.setTotalTime((double) objdetails.get("BestTime"));

                pilot.setName((String) objdetails.get("PilotName"));
                pilot.setId((int) (long) objdetails.get("PilotId"));

                vehicle.setPilot(pilot);

                clas.setPilot(pilot);
                clas.setVehicle(vehicle);
                clas.setBestLap((double) objdetails.get("BestLap"));
                clas.setTotalLaps((int) (long) objdetails.get("TotalLaps"));

                this.classManagement.addObject(clas);
            }
        } catch (ParseException ex) {
            System.out.println("Erro ao carregar os resultados do ficheiro");
        }

        return this.classManagement;
    }

}
