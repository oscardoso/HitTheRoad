package org.academiadecodigo.bootcamp.service.jdbc;

/**
 * Created by codecadet on 27/07/2017.
 */
public enum SuppliesType {
    LATADEATUM("Lata de Atum"),
    LATADESALSICHAS("Lata de Salsichas"),
    GARRAFAAGUA("Garrafa de Água"),
    FRUTADAEPOCA("Fruta da Época"),
    LATADEFEIJAO("Lata de Feijões"),
    SACOCAMA("Saco de Cama"),
    PAPELHIGIENICO("Papel Higiénico"),
    PRESERVATIVOS("Preservativos"),
    DUMDUM("Repelente de Insectos"),
    CANIVETEBEARGRYLLS("Canivete Bear Grylls"),
    CATANA("Catana"),
    TOALHETES("Toalhetes"),
    DESODORIZANTE("Desodorizante"),
    CERVEJA("Refresco de Cevada");

    private String description;

    SuppliesType(String type) {
        description = type;
    }

    public String getDescription() {
        return description;
    }

}
