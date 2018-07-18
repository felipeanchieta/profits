package io.github.felipeanchieta.profits.rest.controllers

import com.jayway.restassured.http.ContentType
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import ro.pippo.controller.ControllerApplication
import ro.pippo.test.PippoRule
import ro.pippo.test.PippoTest

// TODO: Use SpringTest instead of PippoRule
class HealthControllerTest: PippoTest() {

    @get:Rule
    val pippoRule = PippoRule(object : ControllerApplication() {
        override fun onInit() {
            addControllers(HealthController())
        }
    })

    @Test
    fun `should return health`() {
        val response = get("/health")

        response.then().apply {
            statusCode(200)
            contentType(ContentType.TEXT)
        }

        assertEquals("health ok", response.asString())
    }
}
