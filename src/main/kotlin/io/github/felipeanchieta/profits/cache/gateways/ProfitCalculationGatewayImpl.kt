package io.github.felipeanchieta.profits.cache.gateways

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import io.github.felipeanchieta.profits.core.entities.Employee
import io.github.felipeanchieta.profits.core.usecases.ProfitCalculationGateway
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class ProfitCalculationGatewayImpl(
        private val cache: KeyValueCache
) : ProfitCalculationGateway {

    private val gson = GsonBuilder().registerTypeAdapter(
            LocalDate::class.java,
            JsonDeserializer<LocalDate> { json, _, _ -> LocalDate.parse(json.asString) }
    ).create()!!

    override fun retrieveAllEmployees(): List<Employee> {
        val employees = cache.getAll()
        return employees.map { gson.fromJson(it, Employee::class.java) }
    }

}