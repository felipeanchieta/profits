package io.github.felipeanchieta.profits.core.entities.utils

import io.github.felipeanchieta.profits.core.entities.weighting.LocalDateProvider
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class LocalDateProviderImpl : LocalDateProvider {
    override fun now() = LocalDate.now()!!
}