
flow {

    from("dsl-guru@mycompany.com")({
        ctx ->
            println "From: ctx: $ctx"
    })

    to("john.doe@waitaminute.com")({
        ctx ->
            [
                    ss: 'ss'
            ]
    })

}
