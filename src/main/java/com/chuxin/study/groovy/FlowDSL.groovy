package com.chuxin.study.groovy;

class FlowDSL {

    def flowDsl

    def actions = [name: Step]

    def post(String name) {
        { cfgfunc ->
            actions[name] = [execute: { ctx ->
                def cfg = cfgfunc(ctx)
                def url = cfg.url
            }] as Job
        }
    }

    def condition(String name) {
        {
            it ->
                actions[name] = [judge: it] as Condition
        }
    }

    def node(String name) {
        {
            it -> actions[name] = [judge: it] as Condition
        }
    }

    def start(String name) {
        flowDsl.buildStart(actions[name])
    }

    def end(String name) {
        {
            it -> actions[name] = [judge: it] as Condition
        }
    }

//    def when(boolean condition) {
//        [
//                edge: {
//                    String form ->
//                        [
//                                to: {
//                                    String  to ->
//                                        if (condition) {
//                                            builder. putEdgeValue(actions[from],  actions[to], EdgeMatcher.TRUE)
//                                        } else {
//                                            builder. putEdgeValue(actions[from],  actions[to], EdgeMatcher.FALSE)
//                                        }
//                                }
//                        ]
//                },
//                end : {
//                    String name ->
//                        if(condition) {
//                            if(condition) {
//                                builder. linkEnd(actions[name], EdgeMatcher.TRUE)
//                            } else {
//                                builder. linkEnd(actions[name], EdgeMatcher.FALSE)
//                            }
//                        }
//                }
//        ]
//    }
//    def end（String name）{
//        builder. linkEnd(actions[name], EdgeMatcher.Any)
//    }
    def when(boolean flag) {
        [

                edge: {
                    it ->
                        [
                                to: {
                                    to -> flowDsl.buildWhen(flag, actions[it], actions[to])
                                }
                        ]

                }

        ]


    }

    def edge(String name) {
        [
                to: {
                    to ->
                        flowDsl.buildEdge(actions[name], actions[to])
                }
        ]
    }

    def buildFlow() {
        flowDsl = new Flow();
        return flowDsl;
    }

    def static flow(Closure cl) {
        def flowDSL = new FlowDSL();
        def flow = flowDSL.buildFlow()
        def code = cl.rehydrate(flowDSL, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        return flow;
    }
}
