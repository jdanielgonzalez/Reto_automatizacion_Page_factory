package co.com.sofka.util;

public enum Reports {
    REPORTE1("Reporte1"),
    REPORTE2("Reporte2"),
    REPORTE3("Reporte3");


    private final String value;

    Reports(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}

