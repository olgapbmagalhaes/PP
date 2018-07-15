/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */
package Management;

import game.classes.VehicleManagement;

public class VehicleeManagement extends VehicleManagement {

    private final int DEFAULT_SIZE = 4;
    private Object[] objects;
    private int tam;

    public VehicleeManagement() {
        this.objects = new Object[DEFAULT_SIZE];
        this.tam = 0;
    }
    
    
    
    

    /**
     * Método responsável por retornar um objeto existente numa determinada
     * posição do vetor
     *
     * @param position - o indice do elemento a devolver
     * @return o objeto do tipo Object
     */
    @Override
    public Object getObject(int position) {
        if (position < 0 || position >= tam) {
            return null;
        }

        return this.objects[position];
    }

    /**
     * Método responsável por retornar o número de elementos existentes
     *
     * @return o número de posições não nulas
     */
    @Override
    public int size() {
        return this.tam;
    }

    /**
     * Método responsável por inserir um objeto na coleção de objetos
     *
     * @param newObject - o objeto a inserir no vetor
     * @return o valor booleano que sinaliza o sucesso/insucesso da operação
     */
    @Override
    public boolean addObject(Object newObject) {
        if (tam < objects.length) {
            objects[tam++] = newObject;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }



}
