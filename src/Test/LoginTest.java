package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    public static void main(String[] args) {
        // 1. Cấu hình đường dẫn đến file chromedriver.exe từ hình ảnh bạn gửi
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");

        // Khởi tạo tùy chọn cho Chrome (giúp chạy ổn định hơn)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Tắt thông báo đẩy của Facebook

        WebDriver driver = new ChromeDriver(options);

        try {
            // 2. Mở trang đăng nhập Facebook
            driver.get("https://www.facebook.com");
            driver.manage().window().maximize();
            System.out.println("Đã mở trang Facebook thành công.");

            // 3. Nhập Email/Số điện thoại
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("0357171447"); // Thay bằng email thật

            // 4. Nhập Mật khẩu
            WebElement passField = driver.findElement(By.id("pass"));
            passField.sendKeys("mat_khau_cua_ban"); // Thay bằng mật khẩu thật

            // 5. Nhấn nút Đăng nhập (Facebook dùng name='login')
            WebElement loginButton = driver.findElement(By.name("login"));
            loginButton.click();
            System.out.println("Đã nhấn nút đăng nhập.");

            // Đợi 5 giây để trang kịp chuyển hướng
            Thread.sleep(5000);

            // 6. Xác minh chuyển hướng đến trang chính
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("facebook.com") && !currentUrl.contains("login")) {
                System.out.println("KẾT QUẢ: Đăng nhập thành công! Đã chuyển hướng đến: " + currentUrl);
            } else {
                System.out.println("KẾT QUẢ: Đăng nhập thất bại hoặc đang dừng ở trang login.");
            }

        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        } finally {
            // driver.quit(); // Bỏ comment nếu muốn tự động đóng trình duyệt khi xong
        }
    }
}