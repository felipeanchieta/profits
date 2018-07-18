package io.github.felipeanchieta.profits.rest.models.request

import com.google.gson.annotations.SerializedName
import io.github.felipeanchieta.profits.core.entities.Department
import io.github.felipeanchieta.profits.core.entities.Employee
import java.time.LocalDate
import java.time.format.DateTimeFormatter

typealias NewEmployeesRequest = Array<EmployeeRequest>

data class EmployeeRequest(
        @SerializedName("matricula") val id: String,
        @SerializedName("nome") val name: String,
        @SerializedName("area") val department: Department,
        @SerializedName("cargo") val position: String,
        @SerializedName("salario_bruto") val monthlySalary: String,
        @SerializedName("data_de_admissao") val admittedAt: String
) : TranslatableToBusinessEntity<Employee> {

    // FIXME: This might not very clever...
    override fun toBusinessEntity() = Employee(
            id = id,
            name = name,
            department = Department.valueOf("GOVERNANCE"), // FIXME
            position = position,
            monthlySalary = monthlySalary.drop(3).filterNot { it == '.' }.replace(',', '.').toDouble(),
            admittedAt = LocalDate.parse(admittedAt, DateTimeFormatter.ISO_LOCAL_DATE)
    )

}