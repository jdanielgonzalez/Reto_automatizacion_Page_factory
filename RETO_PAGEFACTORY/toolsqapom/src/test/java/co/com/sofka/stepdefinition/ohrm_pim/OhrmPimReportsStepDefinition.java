package co.com.sofka.stepdefinition.ohrm_pim;

import co.com.sofka.model.ohrm_pim.OhrmPimLoginModel;
import co.com.sofka.model.ohrm_pim.OhrmPimReportsModel;
import co.com.sofka.page.orhm_pim.OrmhPimReports;
import co.com.sofka.page.orhm_pim.OrmhPimLogin;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.EmployeeName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.Reports.*;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class OhrmPimReportsStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(OhrmPimReportsStepDefinition.class);

    private OhrmPimLoginModel orangehrmLoginModel;
    private OhrmPimReportsModel ohrmpimreportsmodel;
    private OrmhPimLogin orangehtmLogin;
    private OrmhPimReports ormhpimreports;

    private static final String ASSERTION_EXCEPTION_MESSAGE = "El reporte no fue creado";
    private static final String ASSERTION_TABLA_REPORTE = "Report Name : Reporte1";

    @Given("el administrador inicio sesion")
    public void elAdministradorInicioSesion() {
        try {
            generalSetUp();
            dataCorrectConfiguration();
            orangehtmLogin = new OrmhPimLogin(driver, orangehrmLoginModel, TEN_SECONDS.getValue());
            orangehtmLogin.llenarLogin();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("quiere crear un reporte")
    public void quiereCrearUnReporte () {
        try {
            dataCorrectConfiguration2();
            ormhpimreports = new OrmhPimReports(driver, ohrmpimreportsmodel, TEN_SECONDS.getValue());
            ormhpimreports.toReports();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
    @Then("el sistema debe de crear el reporte y alamcenarlo")
    public void elSistemaDebeDeCrearElReporteYAlamcenarlo() {
        try {
            Assertions.assertEquals(ormhpimreports.isDisplayTableReport(),
                    ASSERTION_TABLA_REPORTE, ASSERTION_EXCEPTION_MESSAGE );
            quitDriver();
        }

        catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    private void dataCorrectConfiguration() {
        orangehrmLoginModel = new OhrmPimLoginModel();
        orangehrmLoginModel.setUser("Admin");
        orangehrmLoginModel.setPassword("admin123");

    }

    private void dataCorrectConfiguration2() {
        ohrmpimreportsmodel = new OhrmPimReportsModel();
        ohrmpimreportsmodel.setReport_name(REPORTE1);
        ohrmpimreportsmodel.setEmployeeName(EmployeeName.EMPLOYEE_NAME2);
    }
}
