package io.github.felipeanchieta.profits.core.entities.scorer

import io.github.felipeanchieta.profits.core.entities.Department
import io.github.felipeanchieta.profits.core.entities.Employee
import org.junit.Test
import org.junit.Assert.assertEquals
import java.time.LocalDate
import java.time.Month

class NormalizedHoldingScorerTest {

    val scorer = NormalizedHoldingScorer()

    @Test
    fun `should proportionally divide the money we have in case we have less money than the expected`() {
        val availableAmount = 10_000.0

        val employeesShares = listOf(
                Pair(Employee(
                        id = "231231321",
                        name = "Kathy",
                        admittedAt = LocalDate.of(2016, Month.JANUARY, 17),
                        department = Department.CUSTOMER_EXPERIENCE,
                        monthlySalary = 10450.0,
                        position = "Analyst"
                ), availableAmount * 2),
                Pair(Employee(
                        id = "1230892031",
                        name = "Rutti",
                        admittedAt = LocalDate.of(2015, Month.FEBRUARY, 19),
                        department = Department.ACCOUNTING,
                        monthlySalary = 1231.0,
                        position = "Intern"
                ), availableAmount * 4)
        )

        val finalShares = scorer.normalizeHolding(availableAmount, employeesShares)

        assertEquals(2, finalShares.size)
        assertEquals(3333.33, finalShares[0].value, 0.01)
        assertEquals(6666.66, finalShares[1].value, 0.01)
    }

    @Test
    fun `should do nothing if we have enough money`() {
        val availableAmount = 10_000.0

        val employeesShares = listOf(
                Pair(Employee(
                        id = "231231321",
                        name = "Kathy",
                        admittedAt = LocalDate.of(2016, Month.JANUARY, 17),
                        department = Department.CUSTOMER_EXPERIENCE,
                        monthlySalary = 10450.0,
                        position = "Analyst"
                ), availableAmount / 2),
                Pair(Employee(
                        id = "1230892031",
                        name = "Rutti",
                        admittedAt = LocalDate.of(2015, Month.FEBRUARY, 19),
                        department = Department.ACCOUNTING,
                        monthlySalary = 1231.0,
                        position = "Intern"
                ), availableAmount / 4)
        )

        val finalShares = scorer.normalizeHolding(availableAmount, employeesShares)

        assertEquals(2, finalShares.size)
        assertEquals(5000.0, finalShares[0].value, 0.01)
        assertEquals(2500.0, finalShares[1].value, 0.01)
    }

}