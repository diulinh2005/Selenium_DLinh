package Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationTestNG {

    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {
        return new Object[][] {
            { "existingUser", "WeakPass1", false },
            { "newUser", "weak", false },
            { "newUser", "StrongPass1", true }
        };
    }

    @Test(dataProvider = "registrationData")
    public void testUserRegistration(String username, String password, boolean expectedOutcome) {
        boolean actualOutcome = registerUser(username, password);
        Assert.assertEquals(actualOutcome, expectedOutcome);
    }

    private boolean registerUser(String username, String password) {
        if (username.equals("existingUser")) return false;
        if (password.length() < 6) return false;
        return true;
    }
}
//nộp bài tập 4