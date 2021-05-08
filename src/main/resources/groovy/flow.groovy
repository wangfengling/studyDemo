flow {

    condition("paramCheck")({
        ctx ->
            def name = ctx.name;
            println "From: ctx: $name"
            [
                    ss: 'ss'
            ]
    })

    post("queryPet")({
        ctx ->
            [
                    ss: 'ss'
            ]
    })

    node("checkResp")({
        ctx ->
            [
                    ss: 'ss'
            ]
    })

    start "paramCheck"
    end   "checkResp"
    when true edge "paramCheck" to "queryPet"
    when false edge "paramCheck" to "checkResp"
    edge "queryPet" to "checkResp"
}

