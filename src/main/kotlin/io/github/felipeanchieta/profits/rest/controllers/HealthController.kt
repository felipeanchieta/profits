package io.github.felipeanchieta.profits.rest.controllers

import org.springframework.stereotype.Component
import ro.pippo.controller.Controller
import ro.pippo.controller.GET
import ro.pippo.controller.Path
import ro.pippo.controller.Produces

@Path("/")
@Component
class HealthController : Controller() {

    @GET("/health")
    @Produces(Produces.TEXT)
    fun health() = "health ok"

}