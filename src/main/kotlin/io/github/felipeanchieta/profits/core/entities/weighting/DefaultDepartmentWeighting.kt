package io.github.felipeanchieta.profits.core.entities.weighting

import io.github.felipeanchieta.profits.core.entities.Department
import io.github.felipeanchieta.profits.core.entities.scorer.DepartmentWeightingStrategy
import org.springframework.stereotype.Component

@Component
class DefaultDepartmentWeighting : DepartmentWeightingStrategy {
    override fun calculate(department: Department): Double {
        return when (department) {
            Department.GOVERNANCE -> 1
            Department.ACCOUNTING, Department.FINANCE, Department.TECHNOLOGY -> 2
            Department.SERVICES -> 3
            Department.CUSTOMER_EXPERIENCE -> 5
        }.toDouble()
    }
}