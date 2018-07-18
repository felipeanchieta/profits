package io.github.felipeanchieta.profits.rest.models.response

import com.google.gson.annotations.SerializedName

data class ProfitHoldingsResponse(
        @SerializedName("participacoes") val holdings: List<HoldingResponse>,
        @SerializedName("total_de_funcionarios") val totalEmployees: Int,
        @SerializedName("total_distribuido") val holdingsTotal: Double,
        @SerializedName("total_disponibilizado") val availableTotal: Double,
        @SerializedName("saldo_total_disponibilizado") val totalBalance: Double
)

data class HoldingResponse(
        @SerializedName("matricula") val employeeId: String,
        @SerializedName("nome") val employeeName: String,
        @SerializedName("valor_da_participacao") val value: Double
)

