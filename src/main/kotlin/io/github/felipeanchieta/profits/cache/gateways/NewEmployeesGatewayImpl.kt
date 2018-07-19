package io.github.felipeanchieta.profits.cache.gateways

import com.google.gson.Gson
import io.github.felipeanchieta.profits.core.entities.Employee
import io.github.felipeanchieta.profits.core.usecases.NewEmployeesGateway
import org.springframework.stereotype.Repository
import java.time.format.DateTimeFormatter

@Repository
class NewEmployeesGatewayImpl(
        private val cache: KeyValueCache
) : NewEmployeesGateway {

    override fun save(employee: Employee) {
        cache.set(employee.id, Gson().toJson(employee.toCacheModel()))
    }

    private data class PersistentEmployee(
            val id: String,
            val name: String,
            val department: String,
            val position: String,
            val monthlySalary: Double,
            val admittedAt: String
    )

    private fun Employee.toCacheModel() = PersistentEmployee(
            id = this.id,
            name = this.name,
            department = this.department.toString(),
            position = this.position,
            monthlySalary = this.monthlySalary,
            admittedAt = this.admittedAt.format(DateTimeFormatter.ISO_LOCAL_DATE)
    )

}