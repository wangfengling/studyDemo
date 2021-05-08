package com.chuxin.study.groovy;

import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;

public class FlowGroovyShell extends GroovyShell {

    private static final CompilerConfiguration compilerConfiguration;

    static {
        ImportCustomizer importCustomizer = new ImportCustomizer();
        importCustomizer.addStaticImport("com.chuxin.study.groovy.FlowDSL", "flow");
        compilerConfiguration = new CompilerConfiguration();
        compilerConfiguration.addCompilationCustomizers(importCustomizer);
    }

    public FlowGroovyShell(){
        super(compilerConfiguration);
    }
}
