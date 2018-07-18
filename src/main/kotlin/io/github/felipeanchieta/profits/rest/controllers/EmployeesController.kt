package io.github.felipeanchieta.profits.rest.controllers

import com.google.gson.Gson
import io.github.felipeanchieta.profits.core.usecases.NewEmployeesInteractor
import io.github.felipeanchieta.profits.rest.models.request.NewEmployeesRequest
import org.springframework.stereotype.Component
import ro.pippo.controller.Consumes
import ro.pippo.controller.Consumes.JSON
import ro.pippo.controller.Controller
import ro.pippo.controller.POST
import ro.pippo.controller.Path

@Component
@Path("/employees")
class EmployeesController(
        private val interactor: NewEmployeesInteractor
) : Controller() {

    @POST("/save")
    @Consumes(JSON)
    fun handle(): String {
        val request = Gson().fromJson(request.body, NewEmployeesRequest::class.java)

        val employees = request.map { it.toBusinessEntity() }

        interactor.saveNewEmployees(employees)

        return "${request.size}"
    }

}