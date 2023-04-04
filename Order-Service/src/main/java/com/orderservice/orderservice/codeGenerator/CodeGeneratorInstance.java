package com.orderservice.orderservice.codeGenerator;

import com.generator.commonservice.utils.CodeGenerator;

public class CodeGeneratorInstance {
    public static void main(String[] args) {
        CodeGenerator.generator("Order-Service", "com.orderservice.orderservice");
    }
}
