/**
 * Test eseguito con Junit relativo alla classe "User": si occupa di testare
 * attraverso valori validi e non il corretto funzionamento delle operazioni
 * di SET definite nella classe stessa.
 */

package isa.ProgettoEsame.model;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import isa.ProgettoEsame.Utility.InvalidStringGenerator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class UserTest {
    
    @BeforeClass
    public static void printName() {
        System.out.println("[Unit test] UserTest-Avvio");
    }
    @AfterClass
    public static void tearDownClass() {
        System.out.println("[Unit test] UserTest-Fine");
    }
/**
 * Viene testato l'inserimento di una stringa: nello specifico viene definita
 * valida una stringa con max 30 caratteri mentre è invalida una stringa con
 * un numero di caratteri superiore, tali stringhe vengono rispettivamente
 * generate dalle classi "StringGenerator" ed "InvalidStringGenerator".
 */ 

    @Property(trials = 25)
    public void testSetFirstname(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new User().setFirstname(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new User().setFirstname(valid);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNull(e2);
    }

    /**
 * Viene testato l'inserimento di una stringa: nello specifico viene definita
 * valida una stringa con max 30 caratteri mentre è invalida una stringa con
 * un numero di caratteri superiore, tali stringhe vengono rispettivamente
 * generate dalle classi "StringGenerator" ed "InvalidStringGenerator".
 */ 

@Property(trials = 30)
public void testSetLastname(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
    IllegalArgumentException e1 = null;
    try {
        new User().setLastname(invalid);
    } catch (IllegalArgumentException ex) {
        e1 = ex;
    }
    assertNotNull(e1);

    IllegalArgumentException e2 = null;
    try {
        new User().setLastname(valid);
    } catch (IllegalArgumentException ex) {
        e2 = ex;
    }
    assertNull(e2);
}


    /**
 * Viene testato l'inserimento di un numero maggiore di 0 prendendo dapprima
 * in input un numero negativo e poi un numero positivo.
 */

    @Property(trials = 30)
    public void testSetId(@InRange(maxInt = 0) int negativeId, @InRange(minInt = 1) int positiveId) {
        IllegalArgumentException e1 = null;
        try {
            new User().setId(negativeId);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new User().setId(positiveId);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNull(e2);
    }

    /**
 * Viene testato l'inserimento di una stringa: nello specifico viene definita
 * valida una stringa con max 20 caratteri mentre è invalida una stringa con
 * un numero di caratteri superiore, tali stringhe vengono rispettivamente
 * generate dalle classi "StringGenerator" ed "InvalidStringGenerator".
 */ 

    @Property(trials = 19)
    public void testSetUsername(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new User().setUsername(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new User().setUsername(valid);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNull(e2);
    }
}
