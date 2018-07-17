package io.github.felipeanchieta.profits.persistence.gateways

import io.github.felipeanchieta.profits.core.entities.Employee
import io.github.felipeanchieta.profits.core.usecases.ProfitCalculationGateway
import org.springframework.stereotype.Repository

@Repository
class ProfitCalculationGatewayImpl(
        private val persistence: KeyValuePersistence
) : ProfitCalculationGateway {

    override fun retrieveEmployees(): List<Employee> {
        return emptyList()
//        return Gson().fromJson<Employee>(persistence.get("*").byteInputStream())
    }

}