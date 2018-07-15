/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */
package Management;

import game.collections.ListManagementContract;

public class ListManagement implements ListManagementContract {

    private final int SIZE = 30;
    private int tam = 0;
    private Object[] objects;

    public ListManagement(Object[] objects) {
        this.objects = objects;
    }

    /**
     * Método responsável por inserir um objeto do vetor de objetos.
     *
     * @param o - objeto a inserir no vetor
     * @return o valor que sinaliza o sucesso/insucesso da operação
     */
    @Override
    public boolean addObject(Object o) {
        if (tam < objects.length) {
            objects[tam++] = o;
            return true;
        }
        return false;
    }

    /**
     * Método responsável por remover um objeto do vetor de objetos.
     *
     * @param i - índice correspondente ao elemento a eliminar
     * @return o objeto eliminado
     */
    @Override
    public Object removeObject(int i) {
        if (i >= tam) {
            return null;
        }

        Object remove = objects[i];

        for (int j = i; j < tam; j++) {
            objects[j] = objects[j + 1];
        }

        return remove;
    }

    /**
     * Método responsável por retornar um objeto existente numa determinada
     * posição do vetor de objetos.
     *
     * @param i - índice do elemento a devolver
     * @return objeto do tipo Object
     */
    @Override
    public Object getObject(int i) {
        if (i < 0 || i >= tam) {
            return null;
        }

        return this.objects[i];
    }

    /**
     * Método responsável por encontrar um objeto no vetor de objetos
     *
     * @param o - objeto a procurar no vetor
     * @return o indice do objeto no vetor. No caso do elemento não existir,
     * deverá ser retornado o valor -1
     */
    @Override
    public int findObject(Object o) {
        for (int i = 0; i < tam; i++) {
            if (objects[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    
}
