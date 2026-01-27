package Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTestData {

    // 1. Bộ dữ liệu kiểm thử (Test Data) theo yêu cầu đề bài
    @DataProvider(name = "registrationData")
    public Object[][] dataProvider() {
        return new Object[][] {
            { "existingUser", "WeakPass1", false }, // Đăng ký tên đã tồn tại
            { "newUser", "123", false },            // Mật khẩu không đủ mạnh
            { "newUser", "StrongPass@2026", true }  // Đăng ký thành công
        };
    }

    // 2. Hàm thực thi kiểm thử
    @Test(dataProvider = "registrationData")
    public void testUserRegistration(String username, String password, boolean expectedOutcome) {
        // Giả lập logic kiểm tra đăng ký
        boolean actualOutcome = registerUser(username, password);
        
        // So sánh thực tế với mong đợi (Tạo ra kết quả PASSED/FAILED)
        Assert.assertEquals(actualOutcome, expectedOutcome, "Kết quả không khớp cho user: " + username);
    }

    // 3. Phương thức giả lập logic đăng ký người dùng
    private boolean registerUser(String username, String password) {
        if (username.equals("existingUser")) {
            return false; // Lỗi tên tồn tại
        }
        if (password.length() < 6) {
            return false; // Lỗi mật khẩu yếu
        }
        return true; // Thành công
    }
}