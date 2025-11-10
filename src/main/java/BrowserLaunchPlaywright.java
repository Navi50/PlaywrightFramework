import com.microsoft.playwright.*;
import org.junit.Before;
import org.junit.Test;

public class BrowserLaunchPlaywright {
    Playwright playwright;
    Browser browser;
    Page page;
    @Before
    public void lauch(){
        playwright= Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        browser = playwright.chromium().launch(lp);
        page = browser.newPage();
    }

    @Test
    public void test(){

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
    public static void main(String[] args) {
    }
    }

