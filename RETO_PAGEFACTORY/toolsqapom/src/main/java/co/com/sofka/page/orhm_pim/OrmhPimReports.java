package co.com.sofka.page.orhm_pim;

import co.com.sofka.model.ohrm_pim.OhrmPimReportsModel;
import co.com.sofka.page.common.CommonActionsOnPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;


public class OrmhPimReports extends CommonActionsOnPages{
    private static final Logger LOGGER = Logger.getLogger(OrmhPimReports.class);
    private OhrmPimReportsModel ohrmpimreportsmodel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    @FindBy(id= "menu_pim_viewPimModule")
    @CacheLookup
    private WebElement pimMenu;

    @FindBy(id = "menu_core_viewDefinedPredefinedReports")
    @CacheLookup
    private WebElement pimReport;

    @FindBy(id = "btnAdd")
    @CacheLookup
    private WebElement btnAdd;


    @FindBy(id = "report_report_name")
    @CacheLookup
    private WebElement report_name;

    @FindBy(id = "report_criteria_list")
    @CacheLookup
    private WebElement seleccionCriteria;

    @FindBy(id = "btnAddConstraint")
    @CacheLookup
    private WebElement btnAddConstraint;

    @FindBy(id = "report_education")
    @CacheLookup
    private WebElement reportEducation;


    @FindBy(id = "employee_name_empName")
    @CacheLookup
    private WebElement employeeNameEmpname;

    @FindBy(id = "report_employment_status")
    @CacheLookup
    private WebElement reportEmploymentStatus;

    @FindBy(id = "report_display_groups")
    @CacheLookup
    private WebElement reportDisplayGroups;

    @FindBy(id = "report_display_field_list")
    @CacheLookup
    private WebElement reportDisplayFieldList;

    @FindBy(id = "btnAddDisplayGroup")
    @CacheLookup
    private WebElement btnAddDisplayGroup;

    @FindBy(id = "btnSave")
    @CacheLookup
    private WebElement btnSave;

    @FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[5]/td[3]/a")
    @CacheLookup
    private WebElement btnRun;


    //For Assertions test case.
    @FindBy(xpath = "//*[@id=\"search-results\"]/div[1]/h1")
    @CacheLookup
    private WebElement tablaReporte;


    public OrmhPimReports(WebDriver driver, OhrmPimReportsModel orangehrmPayGradesModel) {
        super(driver);
        pageFactoryInitElement(driver,this);
        this.ohrmpimreportsmodel = orangehrmPayGradesModel;
    }
    public OrmhPimReports(WebDriver driver, OhrmPimReportsModel orangehrmPayGradesModel, int secondsForExplicitWait) {
        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver,this);
        if(orangehrmPayGradesModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);
        this.ohrmpimreportsmodel = orangehrmPayGradesModel;
    }


    public void toReports()throws IOException{
        try{
            withExplicitWaitClickOn(pimMenu);

            withExplicitWaitClickOn(pimReport);

            withExplicitWaitClickOn(btnAdd);

            scrollTo(report_name);
            withExplicitWaitClear(report_name);
            withExplicitWaitTypeInto(report_name, ohrmpimreportsmodel.getReport_name());
            withExplicitWaitTypeInto(report_name, Keys.TAB);

            //addConstraint(seleccionCriteria, "Education");
            //withExplicitWaitClickOn(btnAddConstraint);
            //addConstraint(seleccionCriteria, "Employee Name");
            //withExplicitWaitClickOn(btnAddConstraint);
            //addConstraint(seleccionCriteria, "Employment Status");
            //withExplicitWaitClickOn(btnAddConstraint);

            //addConstraint(reportEducation, "Bachelor's Degree");

            //scrollTo(employeeNameEmpname);
            //withExplicitWaitTypeInto(employeeNameEmpname, ohrmpimreportsmodel.getEmployeeName());
            //withExplicitWaitTypeInto(employeeNameEmpname, Keys.TAB);

            scrollTo(reportEmploymentStatus);
            addConstraint(reportEmploymentStatus, "Freelance");

            scrollTo(reportDisplayGroups);
            addConstraint(reportDisplayGroups,"Contact Details ");

            scrollTo(reportDisplayFieldList);
            addConstraint(reportDisplayFieldList,"Address");

            withExplicitWaitClickOn(btnAddDisplayGroup);

            scrollTo(btnSave);
            withExplicitWaitClickOn(btnSave);
            scrollTo(btnRun);
            withExplicitWaitClickOn(btnRun);
        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }

    //metodo para añadir una criterio de seleccion
    public void addConstraint (WebElement seleccion, String option)
    {
        scrollTo(seleccion);
        selectDropdownListSeleccionCriteria(seleccion, option);
    }

    // metodo para capturar las opciones de una lista desplegable
    public void selectDropdownListSeleccionCriteria(WebElement seleccion, String option)
    {
        List<WebElement> options =  seleccion.findElements(By.tagName("option"));
        for (int i=0; i<options.size();i++){
            if(getText(options.get(i)).equals(option))
            {
                withExplicitWaitClickOn(options.get(i));
            }
        }
    }

    public String isDisplayTableReport()
    {
        String value = "";
        scrollTo(this.tablaReporte);
        value=getText(this.tablaReporte);
        return value;
    }

}
