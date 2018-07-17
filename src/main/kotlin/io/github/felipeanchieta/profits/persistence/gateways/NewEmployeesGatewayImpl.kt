package io.github.felipeanchieta.profits.persistence.gateways

import com.google.gson.Gson
import io.github.felipeanchieta.profits.core.entities.Employee
import io.github.felipeanchieta.profits.core.usecases.NewEmployeesGateway
import org.springframework.stereotype.Repository

@Repository
class NewEmployeesGatewayImpl(
        private val persistence: KeyValuePersistence
) : NewEmployeesGateway {

    override fun save(employee: Employee) {
        persistence.set(employee.id, Gson().toJson(employee))
    }

}