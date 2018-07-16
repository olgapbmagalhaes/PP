/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */
package Management;

import game.collections.ClassificationManagementContract;

public class ClassificationManagement extends ListManagement implements ClassificationManagementContract {

    private Object[] objects;
    private int tam = 0;

    public ClassificationManagement(Object[] objects) {
        super(objects);
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável por retornar o número de elementos existentes da
     * classificação
     *
     * @return o número de posições não nulas
     */
    @Override
    public int size() {
        return this.tam;
    }

    /**
     * Método responsável por aumentar o número de elementos existentes na
     * classificação
     */
    @Override
    public void increaseSize() {
        Object[] obj = new Object[this.objects.length + 1];
        for (int i = 0; i < obj.length; i++) {
            obj[i] = this.objects[i];
        }
        this.objects = obj;
    }

    /**
     * Método responsável por diminuir o número de elementos existentes na
     * classificação
     */
    @Override
    public void decreaseSize() {
        Object[] obj = new Object[this.objects.length - 1];
        for (int i = 0; i < obj.length; i++) {
            obj[i] = this.objects[i];
        }
        this.objects = obj;
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
        return super.findObject(o);
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
        return super.getObject(i);
    }

    /**
     * Método responsável por remover um objeto do vetor de objetos.
     *
     * @param i - índice correspondente ao elemento a eliminar
     * @return o objeto eliminado
     */
    @Override
    public Object removeObject(int i) {
        return super.removeObject(i);
    }

    /**
     * Método responsável por inserir um objeto do vetor de objetos.
     *
     * @param o - objeto a inserir no vetor
     * @return o valor que sinaliza o sucesso/insucesso da operação
     */
    @Override
    public boolean addObject(Object o) {
        return super.addObject(o);
    }

}
