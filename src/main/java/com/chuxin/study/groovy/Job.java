package com.chuxin.study.groovy;

public abstract class Job implements Step {

    private static final StepType TYPE = StepType.JOB;

    public abstract boolean execute(Object object);

    public boolean run(Object object) {
        return this.execute(object);
    }
}
