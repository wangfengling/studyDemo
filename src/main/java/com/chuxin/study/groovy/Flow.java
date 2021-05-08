package com.chuxin.study.groovy;

import com.chuxin.study.model.Pet;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

import java.util.Set;

public class Flow {

    private MutableValueGraph<Step, Boolean> taskGraph = ValueGraphBuilder.directed().allowsSelfLoops(false).build();
    private Step startNode;

    void buildStart(Step step) {
        startNode = step;
    }

    void buildWhen(boolean flag, Step step, Step endStep) {
        taskGraph.putEdgeValue(step, endStep, flag);
    }

    void buildEdge(Step step, Step endStep) {
        taskGraph.putEdgeValue(step, endStep, false);

    }

    public void run() {
        Pet pet = new Pet();
        pet.setName("zhengwang");
        Step currentStep = startNode;
        boolean flag = false;
        while (true) {
            flag = currentStep.run(pet);
            Set<Step> successors = taskGraph.successors(currentStep);
            for (Step step : successors) {
                boolean weight = (boolean) taskGraph.edgeValue(currentStep, step);
            }
        }
    }

//    ImmutableValueGraph<step, EdgeMatcher>
//    Object curr = startStep;
//    while(curr !=endStep)
//
//    {
//        EdgeMatcher state = null;
//        try {
//            log.info(....);
//            state = ((Step) curr).run(ctx);
//        }
//    }
//    Set<Step> successors=  this. graph. successors(curr);
//    bollean found  =false;
//    Iterator  var6 =successors. iterator();
//while(var6.hasNext()){
//        Step succ =(Step)var6.next();
//        EdgeMatcher edgeMatcher=(EdgeMatcher)this. graph. edgeValue(curr,succ). get()；
//        if(edgeMatcher==EdgeMatcher.ANY  ||  edgeMatcher == state) {
//            curr == succ；
//            found = true;
//            break;
//        }
//    }
}
