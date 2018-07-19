package io.github.felipeanchieta.profits.core.usecases

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.github.felipeanchieta.profits.core.entities.Department
import io.github.felipeanchieta.profits.core.entities.Employee
import io.github.felipeanchieta.profits.core.entities.Holding
import io.github.felipeanchieta.profits.core.entities.scorer.EmployeeHoldingShareScorer
import io.github.felipeanchieta.profits.core.entities.scorer.NormalizedHoldingScorer
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import java.time.Month

class ProfitCalculationInteractorTest {

    private val gateway: ProfitCalculationGateway = mock()
    private val employeeHoldingShareScorer: EmployeeHoldingShareScorer = mock()
    private val normalizedHoldingScorer: NormalizedHoldingScorer = mock()
    private val interactor = ProfitCalculationInteractor(
            gateway,
            employeeHoldingShareScorer,
            normalizedHoldingScorer
    )

    @Test
    fun `should calculate the bonus of a previously persisted employee`() {
        val results = interactor.calculateBonus(availableAmount = 10_000.0)

        assertEquals(
                listOf(Holding(employeeId = "231231321", employeeName = "Kathy", value = 200.0),
                        Holding(employeeId = "231231321", employeeName = "Kathy", value = 200.0)),
                results.holdings
        )
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

        whenever(employeeHoldingShareScorer.scoreEmployee(any())).thenReturn(100.0)

        whenever(normalizedHoldingScorer.normalizeHolding(any(), any())).thenReturn(
                listOf(
                        Holding(
                                employeeId = "231231321",
                                employeeName = "Kathy",
                                value = 200.0
                        ),
                        Holding(
                                employeeId = "231231321",
                                employeeName = "Kathy",
                                value = 200.0
                        )
                )
        )
    }

}