package io.github.felipeanchieta.profits.core.entities.weighting

import io.github.felipeanchieta.profits.core.entities.scorer.AdmissionDateWeightingStrategy
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Component
class DefaultAdmissionDateWeighting(
        private val localDateProvider: LocalDateProvider
) : AdmissionDateWeightingStrategy {

    override fun calculate(admissionDate: LocalDate): Double {
        return when (admissionDate.until(localDateProvider.now(), ChronoUnit.YEARS)) {
            in 0..1 -> 1
            in 1..3 -> 2
            in 3 until 8 -> 3
            else -> 5
        }.toDouble()
    }
}

interface LocalDateProvider {
    fun now(): LocalDate
}