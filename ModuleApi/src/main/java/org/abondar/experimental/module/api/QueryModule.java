package org.abondar.experimental.module.api;

import java.sql.Driver;

public class QueryModule {

    public static void main(String[] args) {
        Class<QueryModule> cls = QueryModule.class;
        Module module = cls.getModule();

        Module javaSqlModule = Driver.class.getModule();

        System.out.println("Named: "+module.isNamed());
        System.out.println("Module name: "+module.getName());
        System.out.println("Can read java sql? "+module.canRead(javaSqlModule));
        System.out.println("Exports module.api? " +
                module.isExported("org.abondar.experimental.module.api"));
        System.out.println("Exports module.api to java.sql? "+
                module.isExported("org.abondar.experimental.module.api",javaSqlModule));
        System.out.println("Opens module.api to java.sql? "+
                module.isOpen("org.abondar.experimental.module.api",javaSqlModule));
    }
}
