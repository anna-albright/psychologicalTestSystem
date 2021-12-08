import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @org.junit.jupiter.api.Test
    void verifyCredentials() {
        User patient = new User();
        String[] info = {"anna", "741"};
        String result = patient.verifyCredentials(info);
        assertEquals("You are sign in!",result);
    }
}