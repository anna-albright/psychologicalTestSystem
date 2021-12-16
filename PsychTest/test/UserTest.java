
import static org.junit.jupiter.api.Assertions.*;

class UserTest { //tests the user class when it creates user - Anna

    @org.junit.jupiter.api.Test
    void verifyCredentials() {
        User patient = new User();
        String[] info = {"username", "password"};
        boolean result = patient.verifyCredentials(info);
        assertEquals(true,result);
    }

}
