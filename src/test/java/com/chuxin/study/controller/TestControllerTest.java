package com.chuxin.study.controller;

import com.chuxin.study.anotation.ParamsFromFile;
import com.chuxin.study.WebControllerTest;
import org.junit.jupiter.params.ParameterizedTest;


public class TestControllerTest extends WebControllerTest {

    @ParameterizedTest
    @ParamsFromFile(fileName = {"test.json", "test1.json"})
    public void buildPrintHello(String params) throws Exception {
        buildGetRequest("/printHello", params);
    }

}
