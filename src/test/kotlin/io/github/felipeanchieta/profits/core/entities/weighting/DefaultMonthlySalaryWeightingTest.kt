package io.github.felipeanchieta.profits.core.entities.weighting

import org.junit.Assert.assertEquals
import org.junit.Test

class DefaultMonthlySalaryWeightingTest {

    private val monthlySalaryWeighting = DefaultMonthlySalaryWeighting()

    @Test
    fun `should weight 1 for internships and everyone with less than 3 minimums wages`() {
        assertEquals(1, monthlySalaryWeighting.calculate(3 * 954.0 - 1).toInt())
    }

    @Test
    fun `should weight 2 when between 3 and 5 minimums wages`() {
        assertEquals(2, monthlySalaryWeighting.calculate(5 * 954.0 - 1).toInt())
    }

    @Test
    fun `should weight 3 when between 5 and 8 minimums wages`() {
        assertEquals(3, monthlySalaryWeighting.calculate(8 * 954.0 - 1).toInt())
    }

    @Test
    fun `should weight 5 when between 5 and 8 minimums wages`() {
        assertEquals(5, monthlySalaryWeighting.calculate(8 * 954.0).toInt())
    }

}