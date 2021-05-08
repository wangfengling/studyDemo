package com.chuxin.study.groovy;

class FlowDSLBak {

    def flowDsl

    def actions = [name: Step]

    def from(String from) {
        {
            cxt ->
                cxt(from)
        }
    }

    def to(String to) {
        {
            ctx ->
                println "To: $to,ctx: $ctx"

        }

    }

    def start(String name) {
        flowDsl.buildStart(actions[name])
    }

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

    def when(boolean flag) {
        [

                edge: {
                    it ->
                        flowDsl.buildWhen(flag, actions[it])
                        [
                                to: {
                                    to -> flowDsl.buildEdge(actions[it], actions[to])
                                }
                        ]

                }

        ]


    }

    def end(String name) {
        {
            it -> actions[name] = [judge: it] as Condition
        }
    }


    def node(String name) {
        {
            it -> actions[name] = [judge: it] as Condition
        }
    }

    def edge(String name) {
        [
                to: {
                    it ->
                        flowDsl.buildEdge(actions[name], actions[it])
                }
        ]
    }

    def buildFlow() {
        flowDsl = new Flow();
        return flowDsl;
    }

    def static flow(Closure cl) {
        def flowDSL = new FlowDSLBak();
        def flow = flowDSL.buildFlow()
        def code = cl.rehydrate(flowDSL, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        return flow;
    }
}
