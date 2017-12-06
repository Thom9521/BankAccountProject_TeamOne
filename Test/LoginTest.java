import org.junit.Test;

import static org.junit.Assert.*;
public class LoginTest {

    @Test
    public void testLogin() throws Exception {
        DB_Statements test2 = new DB_Statements();

        //Generere resultat til at være true eller false og initialisere det til at være = det indtastede uname og pword
        Boolean resultat = test2.checkLogin("Thomas","12345678");

        //Tjekker om username og password er korrekt, hvis ikke bliver nedenstående message udskrevet
        assertTrue("Forkert username eller password",resultat);

    }

}
