import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstTest {
    public static void main(String[] args) {
        // burada try kullananin amaci playwright i test biitiginde otomatik olarak kapamak, eger sayfa yuklenmiyorsa exception verecek
        try (Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.google.com/");
            System.out.println("Page title is "+page.title());
            browser.close();// eger try varsa close gerek yok
        }
    }
}
