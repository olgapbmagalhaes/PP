/**
 * Nome: Olga Patrícia Barbosa Magalhães Número: 8130149 Turma: T3
 */
package Exceptions;

import game.exceptions.GeneralException;

public class General extends GeneralException {

    /**
     * Construtor para criar uma nova instância de uma excepção genérica sem
     * mensagem detalhada
     */
    public General() {
        super();
    }

    /**
     * Construtor para criar uma nova instância de uma excepção genérica com uma
     * mensagem detalhada
     *
     * @param msg - a mensagem detalhada
     */
    public General(String msg) {
        super(msg);
    }

}
