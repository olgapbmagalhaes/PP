/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */

package Classes;

import game.Contracts.PilotContract;
import javafx.scene.input.KeyCode;

public class Pilot implements PilotContract {

    private String name;
    private int id;
    private KeyCode keyUp, keyDown, keyLeft, keyRight;
    
    
    
    /**
     * 
     * @param name
     * @param id
     * @param keyUp
     * @param keyDown
     * @param keyLeft
     * @param keyRight 
     */
    public Pilot(String name, int id, KeyCode keyUp, KeyCode keyDown, KeyCode keyLeft, KeyCode keyRight) {
        this.name = name;
        this.id = id;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
    }

    Pilot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * Método responsável por retornar o nome do piloto
     *
     * @return o nome do piloto
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Método responsável por especificar o nome do piloto
     *
     * @param string - o nome do piloto
     */
    @Override
    public void setName(String string) {
        this.name = string;
    }

    /**
     * Método responsável por retornar o id do piloto
     *
     * @return o id do piloto
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Método responsável por especificar o id do piloto
     *
     * @param i - o id do piloto
     */
    @Override
    public void setId(int i) {
        this.id = i;
    }

    /**
     * Método responsável por retornar a tecla de aceleração
     *
     * @return a tecla de aceleração
     */
    @Override
    public KeyCode getKeyUp() {
        return this.keyUp;
    }

    /**
     * Método responsável por especificar a tecla de aceleração
     *
     * @param kc - a tecla de aceleração
     */
    @Override
    public void setKeyUp(KeyCode kc) {
        this.keyUp = kc;
    }

    /**
     * Método responsável por retornar a tecla de travagem
     *
     * @return a tecla de travagem
     */
    @Override
    public KeyCode getKeyDown() {
        return this.keyDown;
    }

    /**
     * Método responsável por especificar a tecla de travagem
     *
     * @param kc - a tecla de travagem
     */
    @Override
    public void setKeyDown(KeyCode kc) {
        this.keyDown = kc;
    }

    /**
     * Método responsável por retornar a tecla de viragem à esquerda
     *
     * @return a tecla de viragem á esquerda
     */
    @Override
    public KeyCode getKeyLeft() {
        return this.keyLeft;
    }

    /**
     * Método responsável por especiicar a tecla de viragem à esquerda
     *
     * @param kc - a tecla de viragem á esquerda
     */
    @Override
    public void setKeyLeft(KeyCode kc) {
        this.keyLeft = kc;
    }

    /**
     * Método responsável por retornar a tecla de viragem à direita
     *
     * @return a tecla de viragem á direita
     */
    @Override
    public KeyCode getKeyRight() {
        return this.keyRight;
    }

    /**
     * Método responsável por especificar a tecla de viragem à direita
     *
     * @param kc - a tecla de viragem á direita
     */
    @Override
    public void setKeyRight(KeyCode kc) {
        this.keyRight = kc;
    }

    /**
     * Método que retorna uma string com toda a informação relativa ao piloto
     *
     * @return uma string com toda a informação relativa ao piloto
     */
    @Override
    public String toString() {
        return "Pilot{"
                + "name=" + name
                + ", id=" + id
                + ", keyUp=" + keyUp
                + ", keyDown=" + keyDown
                + ", keyLeft=" + keyLeft
                + ", keyRight=" + keyRight
                + '}';
    }

}
