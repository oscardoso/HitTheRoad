package org.academiadecodigo.bootcamp.service.jdbc;

/**
 * Created by codecadet on 27/07/2017.
 */
public enum SuppliesType {
    LATADEATUM("Lata de Atum"),
    FRUTADAEPOCA("Fruta da Época"),
    GARRAFAAGUA("Garrafa de Água"),
    CERVEJA("Refresco de Cevada"),
    LATADESALSICHAS("Lata de Salsichas"),
    LATADEFEIJAO("Lata de Feijões"),
    DUMDUM("Repelente de Insectos"),
    CANIVETEBEARGRYLLS("Canivete Bear Grylls"),
    TOALHETES("Toalhetes"),
    DESODORIZANTE("Desodorizante"),
    PAPELHIGIENICO("Papel Higiénico"),
    PRESERVATIVOS("Preservativos"),
    SACOCAMA("Saco de Cama"),
    CATANA("Catana");

    private String description;

    SuppliesType(String type) {
        description = type;
    }

    public String getDescription() {
        return description;
    }

}
