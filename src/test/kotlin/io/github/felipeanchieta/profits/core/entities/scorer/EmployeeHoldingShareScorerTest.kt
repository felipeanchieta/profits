package io.github.felipeanchieta.profits.core.entities.scorer

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.github.felipeanchieta.profits.core.entities.Department
import io.github.felipeanchieta.profits.core.entities.Employee
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class EmployeeHoldingShareScorerTest {

    private val departmentWeighting: DepartmentWeightingStrategy = mock()
    private val salaryWeighting: MonthlySalaryWeightingStrategy = mock()
    private val admissionDateWeighting: AdmissionDateWeightingStrategy = mock()

    private val scorer = EmployeeHoldingShareScorer(
            departmentWeighting = departmentWeighting,
            salaryWeighting = salaryWeighting,
            admissionDateWeighting = admissionDateWeighting
    )

    @Test
    fun `should score an employee`() {
        val employee = Employee(
                id = "whatever",
                name = "whatever",
                department = Department.GOVERNANCE,
                position = "whatever",
                monthlySalary = 5000.0,
                admittedAt = LocalDate.now()!!
        )

        whenever(admissionDateWeighting.calculate(employee.admittedAt)).thenReturn(2.0)
        whenever(departmentWeighting.calculate(employee.department)).thenReturn(3.0)
        whenever(salaryWeighting.calculate(employee.monthlySalary)).thenReturn(5.0)

        assertEquals(60_000.0, scorer.scoreEmployee(employee), 0.01)
    }

}