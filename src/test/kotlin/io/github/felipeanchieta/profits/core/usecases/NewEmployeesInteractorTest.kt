package io.github.felipeanchieta.profits.core.usecases

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doNothing
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.github.felipeanchieta.profits.core.entities.Department
import io.github.felipeanchieta.profits.core.entities.Employee
import org.junit.Test
import java.time.LocalDate
import java.time.Month

class NewEmployeesInteractorTest {

    private val gateway: NewEmployeesGateway = mock()
    private val interactor = NewEmployeesInteractor(gateway)

    @Test
    fun `should persist new employees`() {
        val employees = arrayListOf(
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

        doNothing().whenever(gateway).save(any())

        interactor.saveNewEmployees(employees)

        employees.forEach {
            verify(gateway, times(1)).save(it)
        }
    }

    @Test
    fun `should not call gateway when receive an empty collection`() {
        val employees: List<Employee> = emptyList()

        doNothing().whenever(gateway).save(any())

        interactor.saveNewEmployees(employees)

        verify(gateway, never()).save(any())
    }

}