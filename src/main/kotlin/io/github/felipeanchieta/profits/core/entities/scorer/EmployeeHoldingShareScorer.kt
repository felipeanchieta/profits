package io.github.felipeanchieta.profits.core.entities.scorer

import io.github.felipeanchieta.profits.core.entities.Department
import io.github.felipeanchieta.profits.core.entities.Employee
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class EmployeeHoldingShareScorer(
        private val departmentWeighting: DepartmentWeightingStrategy,
        private val salaryWeighting: MonthlySalaryWeightingStrategy,
        private val admissionDateWeighting: AdmissionDateWeightingStrategy
) {

    fun scoreEmployee(employee: Employee): Double {
        val admissionWeight = admissionDateWeighting.calculate(employee.admittedAt)
        val departmentWeight = departmentWeighting.calculate(employee.department)
        val salaryWeight = salaryWeighting.calculate(employee.monthlySalary)

        return (employee.monthlySalary * (admissionWeight + departmentWeight) / salaryWeight) * 12.0
    }

}

interface DepartmentWeightingStrategy {
    fun calculate(department: Department): Double
}

interface MonthlySalaryWeightingStrategy {
    val minimumWage: Double
    fun calculate(salary: Double): Double
}

interface AdmissionDateWeightingStrategy {
    fun calculate(admissionDate: LocalDate): Double
}