package io.github.felipeanchieta.profits.rest.controllers

import org.springframework.stereotype.Component
import ro.pippo.controller.Consumes
import ro.pippo.controller.Consumes.JSON
import ro.pippo.controller.Controller
import ro.pippo.controller.POST
import ro.pippo.controller.Path

@Path("/")
@Component
class NewEmployeesController : Controller() {

    @POST("/new")
    @Consumes(JSON)
    fun handle(): String {
        println(request.body)
        return "hello"
    }

}