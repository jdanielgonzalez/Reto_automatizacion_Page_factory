package co.com.sofka.page.orhm_pim;
import co.com.sofka.model.ohrm_pim.OhrmPimLoginModel;
import co.com.sofka.page.common.CommonActionsOnPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class OrmhPimLogin extends CommonActionsOnPages{
    private static final Logger LOGGER = Logger.getLogger(OrmhPimLogin.class);
    private OhrmPimLoginModel orangehrmLoginModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    @FindBy(id = "txtUsername")
    @CacheLookup
    private WebElement user;

    @FindBy(id = "txtPassword")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement btnLogin;

    public OrmhPimLogin(WebDriver driver, OhrmPimLoginModel orangehrmLoginModel) {
        super(driver);
        pageFactoryInitElement(driver,this);
        this.orangehrmLoginModel = orangehrmLoginModel;
    }

    public OrmhPimLogin(WebDriver driver, OhrmPimLoginModel orangehrmLoginModel, int secondsForExplicitWait) {
        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver,this);
        if(orangehrmLoginModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);
        this.orangehrmLoginModel= orangehrmLoginModel;
    }

    public void llenarLogin() throws IOException {
        try{
            scrollTo(user);
            withExplicitWaitClear(user);
            withExplicitWaitTypeInto(user,orangehrmLoginModel.getUser());

            scrollTo(password);
            withExplicitWaitClear(password);
            withExplicitWaitTypeInto(password,orangehrmLoginModel.getPassword());

            scrollTo(btnLogin);
            clickOn(btnLogin);
        }
        catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }

}