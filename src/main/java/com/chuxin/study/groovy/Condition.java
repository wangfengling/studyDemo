package com.chuxin.study.groovy;

public abstract class Condition implements Step{

    private static final StepType TYPE = StepType.JUDGE;

    public abstract boolean judge(Object object);

    public boolean run(Object object) {
        return this.judge(object);
    }
}
