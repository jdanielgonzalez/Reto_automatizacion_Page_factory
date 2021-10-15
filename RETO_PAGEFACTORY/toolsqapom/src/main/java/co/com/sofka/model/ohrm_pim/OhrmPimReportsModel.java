package co.com.sofka.model.ohrm_pim;

import co.com.sofka.util.EmployeeName;
import co.com.sofka.util.Reports;

public class OhrmPimReportsModel {
    private Reports report_name;
    private EmployeeName employeeName;

    public String getEmployeeName() {return employeeName.getValue();}

    public void setEmployeeName(EmployeeName employeeName) {this.employeeName = employeeName;}

    public String getReport_name() {
        return report_name.getValue();
    }

    public void setReport_name(Reports report_name) {
        this.report_name = report_name;
    }

}
