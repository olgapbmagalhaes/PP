
package Classes;

import game.Contracts.PilotContract;
import javafx.scene.input.KeyCode;

public class Pilot implements PilotContract {

    private String name;
    private int id;

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
     * @param string - o nome do piloto
     */
    @Override
    public void setName(String string) {
        this.name = string;
    }

    /**
     * Método responsável por retornar o id do piloto
     * @return o id do piloto
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Método responsável por especificar o id do piloto
     * @param i - o id do piloto
     */
    @Override
    public void setId(int i) {
        this.id = i;
    }

    @Override
    public KeyCode getKeyUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setKeyUp(KeyCode kc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KeyCode getKeyDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setKeyDown(KeyCode kc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KeyCode getKeyLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setKeyLeft(KeyCode kc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public KeyCode getKeyRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setKeyRight(KeyCode kc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
