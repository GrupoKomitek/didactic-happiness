package io.github.epelde.didactichappiness.business;

/**
 * Created by Gorka on 04/10/2016.
 *
 * Controla la interacción entre el Oráculo y el usuario que pregunta
 */
public interface IOracleProcessorInteractor {

    /**
     * Transforma la pregunta en una respuesta del Oráculo
     * @param question
     * @return identificador de respuesta
     */
    public int processQuestion(String question);
}
