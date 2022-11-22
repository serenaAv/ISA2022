/**
 * Classe che consente la generazione di una stringa alfanumerica costituita
 * da lettere maiuscole e minuscole e numeri da 0 a 9.
 */
package isa.ProgettoEsame.Utility;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class AlphanumericGenerator extends Generator<String> {

    public AlphanumericGenerator() {
        super(String.class);
    }

    @Override
    public String generate(SourceOfRandomness sor, GenerationStatus gs) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            sb.append(sor.nextChar('A', 'z'));
            sb.append(sor.nextInt(0,9));
        }

        return sb.toString();
    }

}

