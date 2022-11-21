/**
 * Generatore di stringe valide. Genera una stringa costituita da catteri
 * maiuscoli e minuscoli costituita da 50 lettere.
 */
package isa.ProgettoEsame.Utility;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class StringGenerator extends Generator<String> {

    public StringGenerator() {
        super(String.class);
    }

    @Override
    public String generate(SourceOfRandomness sor, GenerationStatus gs) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 50; i++) {
            sb.append(sor.nextChar('A', 'z'));
        }

        return sb.toString();
    }

}
