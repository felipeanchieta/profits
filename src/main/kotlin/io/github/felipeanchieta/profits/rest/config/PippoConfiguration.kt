package io.github.felipeanchieta.profits.rest.config

import org.springframework.beans.factory.ListableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ro.pippo.controller.Controller
import ro.pippo.controller.ControllerApplication
import ro.pippo.core.Pippo

@Configuration
class PippoConfiguration {

    @Bean
    fun pippo(beanFactory: ListableBeanFactory): Pippo {
        val controllers = beanFactory.getBeansOfType(Controller::class.java).values

        val app = object : ControllerApplication() {
            override fun onInit() {
                controllers.forEach {
                    addControllers(it)
                }
            }
        }

        return Pippo(app).apply { start(8080) }
    }

}