package io.github.felipeanchieta.profits.core.entities.weighting

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import java.time.Month

class DefaultAdmissionDateWeightingTest {

    private val localDateProvider: LocalDateProvider = mock()
    private val admissionDateWeighting = DefaultAdmissionDateWeighting(localDateProvider)

    @Test
    fun `should weight 1 when no more than one year in the company`() {
        assertEquals(1, admissionDateWeighting.calculate(LocalDate.of(2017, Month.JULY, 18)).toInt())
    }

    @Test
    fun `should weight 2 when no more one year in the company but less than three years`() {
        assertEquals(2, admissionDateWeighting.calculate(LocalDate.of(2015, Month.JULY, 18)).toInt())
    }

    @Test
    fun `should weight 3 when no more one year in the company but less than eight years`() {
        assertEquals(3, admissionDateWeighting.calculate(LocalDate.of(2013, Month.JULY, 18)).toInt())
    }

    @Test
    fun `should weight 5 when more than eight years in the company`() {
        assertEquals(5, admissionDateWeighting.calculate(LocalDate.of(2010, Month.JULY, 18)).toInt())
    }

    @Before
    fun setUp() {
        whenever(localDateProvider.now()).thenReturn(LocalDate.of(2018, Month.JULY, 18))
    }

}