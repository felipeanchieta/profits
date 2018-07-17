package io.github.felipeanchieta.profits.core.usecases

import io.github.felipeanchieta.profits.core.entities.Employee
import org.springframework.stereotype.Component

@Component
class NewEmployeesInteractor(
        private val gateway: NewEmployeesGateway
) {

    fun saveNewEmployees(employees: Collection<Employee>) {
        employees.forEach { gateway.save(it) }
    }

}

interface NewEmployeesGateway {
    fun save(employee: Employee)
}
