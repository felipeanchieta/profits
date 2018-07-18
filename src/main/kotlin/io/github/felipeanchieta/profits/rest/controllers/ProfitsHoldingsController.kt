package io.github.felipeanchieta.profits.rest.controllers

import com.google.gson.Gson
import io.github.felipeanchieta.profits.core.entities.ProfitHoldingsResult
import io.github.felipeanchieta.profits.core.usecases.ProfitCalculationInteractor
import io.github.felipeanchieta.profits.rest.models.response.HoldingResponse
import io.github.felipeanchieta.profits.rest.models.response.ProfitHoldingsResponse
import org.springframework.stereotype.Component
import ro.pippo.controller.Controller
import ro.pippo.controller.GET
import ro.pippo.controller.Path
import ro.pippo.controller.Produces
import ro.pippo.controller.Produces.JSON
import ro.pippo.controller.extractor.Param

@Component
@Path("/profits")
class ProfitsHoldingsController(private val interactor: ProfitCalculationInteractor) : Controller() {

    @GET("/sharing")
    @Produces(JSON)
    fun handle(@Param("amount") amount: Double): String {
        val response = interactor.calculateBonus(amount)
        return Gson().toJson(response.toResponseModel())
    }

    private fun ProfitHoldingsResult.toResponseModel() = ProfitHoldingsResponse(
            holdings = this.holdings.map {
                HoldingResponse(
                        employeeId = it.employeeId,
                        employeeName = it.employeeName,
                        value = it.value
                )
            },
            totalEmployees = this.totalEmployees,
            holdingsTotal = this.holdingsTotal,
            availableTotal = this.availableTotal,
            totalBalance = this.totalBalance
    )

}