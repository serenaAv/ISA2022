/**
 * Generatore di numeri validi. Genera un numero random di 10 cifre
 */

package isa.ProgettoEsame.Utility;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class NumberGenerator extends Generator<String> {
    
    
     public NumberGenerator() {
        super(String.class);
    }

    @Override
    public String generate(SourceOfRandomness sor, GenerationStatus gs) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append(sor.nextChar('0', '9'));
        }

        return sb.toString();
    }
    
}
