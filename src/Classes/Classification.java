/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */
package Classes;

import game.Contracts.ClassificationContract;
import game.Contracts.PilotContract;
import game.Contracts.RaceResultsComparator;
import game.classes.VehicleAbstract;

public class Classification implements ClassificationContract {

    private String level;
    private int totalLaps;
    private VehicleAbstract vehicle;
    private double bestLap, totalTime;

    
    
    /**
     * Método construtor para inicializar um piloto
     */
    public Classification() {
    }


    /**
     * Método responsável por retornar o nível da classificação
     *
     * @return o nível da classificação
     */
    @Override
    public String getLevel() {
        return this.level;
    }

    /**
     * Método responsável por especificar o nível da classificação
     *
     * @param string - o nivel da classificação
     */
    @Override
    public void setLevel(String string) {
        this.level = string;
    }

    /**
     * Método responsável por especificar o número total de voltas
     *
     * @param i - o número total de voltas
     */
    @Override
    public void setTotalLaps(int i) {
        this.totalLaps = i;
    }

    /**
     * Método responsável por retornar o piloto
     *
     * @return o piloto
     */
    @Override
    public PilotContract getPilot() {
        return this.vehicle.getPilot();
    }

    /**
     * Método responsável por retornar o número total de voltas
     *
     * @return o número total de voltas
     */
    @Override
    public int getTotalLaps() {
        return this.totalLaps;
    }

    /**
     * Método responsável por especificar o piloto
     *
     * @param pc - o piloto
     */
    @Override
    public void setPilot(PilotContract pc) {
        this.vehicle.setPilot(pc);
    }

    /**
     * Método responsável por retornar o veículo
     *
     * @return o veiculo
     */
    @Override
    public VehicleAbstract getVehicle() {
        return this.vehicle;
    }

    /**
     * Método responsável por especificar o veículo
     *
     * @param va - o veiculo
     */
    @Override
    public void setVehicle(VehicleAbstract va) {
        this.vehicle = va;
    }

    /**
     * Método responsável por devolver o tempo da melhor volta
     *
     * @return o tempo da melhor volta
     */
    @Override
    public double getBestLap() {
        return this.bestLap;
    }

    /**
     * Método responsável por especificar o tempo da melhor volta
     *
     * @param bestLap - o tempo da melhor volta
     */
    public void setBestLap(double bestLap) {
        this.bestLap = bestLap;
    }

    /**
     * Método responsável por adicionar o tempo de uma volta
     *
     * @param d - o tempo de uma volta
     */
    @Override
    public void addLap(double d) {
        
    }

    /**
     * Método responsável por retornar o tempo total
     *
     * @return o tempo total
     */
    @Override
    public double getTotalTime() {
        return this.totalTime;
    }

    /**
     * Método responsável por especificar o tempo total
     *
     * @param d - o tempo total
     */
    @Override
    public void setTotalTime(double d) {
        this.totalTime = d;
    }

    /**
     * Método responsável por comparar resultados da corrida
     *
     * @param rrc - o objeto com o qual se pretende comparar
     * @return superior a 0 se o objeto a comparar for superior a objeto
     * inferior a 0 se o objeto a comparar for inferior a objeto 0 se os dois
     * objetos forem iguais
     */
    @Override
    public int compareTo(RaceResultsComparator rrc) {
        return ((Double) this.getBestLap()).compareTo(((Classification) rrc).getBestLap());
    }

    /**
     * Método que retorna uma string com toda a informação relativa á
     * classificação
     *
     * @return uma string com toda a informação á classificação
     */
    @Override
    public String toString() {
        return "Classification{"
                + "level=" + level
                + ", totalLaps=" + totalLaps
                + ", vehicle=" + vehicle
                + ", bestLap=" + bestLap
                + ", totalTime=" + totalTime
                + '}';
    }

}
