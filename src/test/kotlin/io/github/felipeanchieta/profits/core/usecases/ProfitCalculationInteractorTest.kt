package io.github.felipeanchieta.profits.core.usecases

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.github.felipeanchieta.profits.core.entities.Department
import io.github.felipeanchieta.profits.core.entities.Employee
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import java.time.Month

class ProfitCalculationInteractorTest {

    private val gateway: ProfitCalculationGateway = mock()
    private val interactor = ProfitCalculationInteractor(gateway)

    @Test
    fun `should calculate the bonus of a previously persisted employee`() {
        val results = interactor.calculateBonus(distributableProfits = 10_000.0)
        assertNotEmpty(results)
    }

    private fun assertNotEmpty(results: List<Double>) {
        assertTrue(results.isNotEmpty())
    }

    @Before
    fun setUp() {
        whenever(gateway.retrieveAllEmployees()).thenReturn(
                listOf(
                        Employee(
                                id = "231231321",
                                name = "Kathy",
                                admittedAt = LocalDate.of(2016, Month.JANUARY, 17),
                                department = Department.CUSTOMER_EXPERIENCE,
                                monthlySalary = 10450.0,
                                position = "Analyst"
                        ),
                        Employee(
                                id = "1230892031",
                                name = "Rutti",
                                admittedAt = LocalDate.of(2015, Month.FEBRUARY, 19),
                                department = Department.ACCOUNTING,
                                monthlySalary = 1231.0,
                                position = "Intern"
                        )
                )
        )
    }

}