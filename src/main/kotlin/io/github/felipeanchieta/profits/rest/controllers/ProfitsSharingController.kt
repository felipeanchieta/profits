package io.github.felipeanchieta.profits.rest.controllers

import io.github.felipeanchieta.profits.core.usecases.ProfitCalculationInteractor
import org.springframework.stereotype.Component
import ro.pippo.controller.Controller
import ro.pippo.controller.GET
import ro.pippo.controller.Path
import ro.pippo.controller.Produces
import ro.pippo.controller.Produces.JSON

@Component
@Path("/profits")
class ProfitsSharingController(private val interactor: ProfitCalculationInteractor): Controller() {

    @GET("/sharing")
    @Produces(JSON)
    fun handle(): String {
        interactor.calculateBonus(0.0)
        return """{ "bonus": 0.0 }"""
    }
}