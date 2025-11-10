import com.microsoft.playwright.*;
public class BrowserLaunchPlaywright {



        public static void main(String[] args) {
            Playwright playwright = Playwright.create();
            BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
            lp.setChannel("chrome");
            lp.setHeadless(false);
            Browser browser = playwright.chromium().launch(lp);
            Page page = browser.newPage();
            page.navigate("https://www.saucedemo.com/");
            System.out.println(page.title());
            page.fill("//*[@id='user-name']","standard_user");
            page.fill("//*[@id='password']","secret_sauce");
            page.click("//*[@id='login-button']");
            System.out.println(page.title());
            page.close();
            browser.close();
            playwright.close();

        }
    }

