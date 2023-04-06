package com.ruimind.gis.codeGenerator;

import com.generator.commonservice.utils.CodeGenerator;
import com.generator.commonservice.utils.DatabaseEntity;

public class CodeGeneratorInstance {
    public static void main(String[] args) {
        DatabaseEntity databaseEntity = new DatabaseEntity();
        databaseEntity.setPwd("58fTm6Li");
        databaseEntity.setUname("postgres");
        databaseEntity.setAuthorName("dongwentao");
        databaseEntity.setModuleName("User-Service");
        databaseEntity.setDriverName("org.postgresql.Driver");
        databaseEntity.setPackageName("com.ruimind.gis");
        databaseEntity.setUrl("jdbc:postgresql://8.140.167.225:32054/RuiMind_Cloud_PlatForm");
        CodeGenerator.generator(databaseEntity);
    }
}
