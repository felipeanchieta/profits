package io.github.felipeanchieta.profits.rest.controllers

import com.jayway.restassured.RestAssured
import com.jayway.restassured.http.ContentType
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doNothing
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.github.felipeanchieta.profits.core.entities.Department.GOVERNANCE
import io.github.felipeanchieta.profits.core.entities.Employee
import io.github.felipeanchieta.profits.core.usecases.NewEmployeesInteractor
import org.intellij.lang.annotations.Language
import org.junit.Rule
import org.junit.Test
import ro.pippo.controller.ControllerApplication
import ro.pippo.test.PippoRule
import ro.pippo.test.PippoTest
import java.time.LocalDate

class EmployeesControllerTest : PippoTest() {

    val mockedInteractor: NewEmployeesInteractor = mock()

    @get:Rule
    val pippoRule = PippoRule(object : ControllerApplication() {
        override fun onInit() {
            addControllers(EmployeesController(mockedInteractor.apply {
                doNothing().whenever(this).saveNewEmployees(any())
            }))
        }
    })

    @Test
    fun `should receive a JSON array of new employees`() {
        val response = RestAssured.with().contentType(ContentType.JSON).body(inputJSON).`when`().post("/employees/save")

        response.then().statusCode(200)

        // Careful: huge list of different employees
        verify(mockedInteractor).saveNewEmployees(listOf(
                Employee(
                        id = "0009968",
                        name = "Victor Wilson",
                        department = GOVERNANCE,
                        position = "Diretor Financeiro",
                        monthlySalary = 12696.2,
                        admittedAt = LocalDate.of(2012, 1, 5)
                ),
                Employee(
                        id = "0004468",
                        name = "Flossie Wilson",
                        department = GOVERNANCE,
                        position = "Auxiliar de Contabilidade",
                        monthlySalary = 1396.52,
                        admittedAt = LocalDate.of(2015, 1, 5)
                ),
                Employee(
                        id = "0008174",
                        name = "Sherman Hodges",
                        department = GOVERNANCE,
                        position = "Líder de Relacionamento",
                        monthlySalary = 3899.74,
                        admittedAt = LocalDate.of(2015, 6, 7)
                ),
                Employee(
                        id = "0007463",
                        name = "Charlotte Romero",
                        department = GOVERNANCE,
                        position = "Contador Pleno",
                        monthlySalary = 3199.82,
                        admittedAt = LocalDate.of(2018, 1, 3)
                ),
                Employee(
                        id = "0005253",
                        name = "Wong Austin",
                        department = GOVERNANCE,
                        position = "Economista Júnior",
                        monthlySalary = 2215.04,
                        admittedAt = LocalDate.of(2016, 8, 27)
                ),
                Employee(
                        id = "0004867",
                        name = "Danielle Blanchard",
                        department = GOVERNANCE,
                        position = "Auxiliar Administrativo",
                        monthlySalary = 2768.28,
                        admittedAt = LocalDate.of(2015, 10, 17)
                ),
                Employee(
                        id = "0001843",
                        name = "Daugherty Kramer",
                        department = GOVERNANCE,
                        position = "Atendente de Almoxarifado",
                        monthlySalary = 2120.08,
                        admittedAt = LocalDate.of(2016, 4, 21)
                ),
                Employee(
                        id = "0007961",
                        name = "Francesca Hewitt",
                        department = GOVERNANCE,
                        position = "Auxiliar de Contabilidade",
                        monthlySalary = 2101.68,
                        admittedAt = LocalDate.of(2015, 6, 21)
                ),
                Employee(
                        id = "0006806",
                        name = "Ella Hale",
                        department = GOVERNANCE,
                        position = "Auxiliar Administrativo",
                        monthlySalary = 2571.73,
                        admittedAt = LocalDate.of(2014, 7, 27)
                ),
                Employee(
                        id = "0005961",
                        name = "Jillian Odonnell",
                        department = GOVERNANCE,
                        position = "Contador Júnior",
                        monthlySalary = 2671.26,
                        admittedAt = LocalDate.of(2016, 9, 8)
                ),
                Employee(
                        id = "0007293",
                        name = "Morton Battle",
                        department = GOVERNANCE,
                        position = "Economista Pleno",
                        monthlySalary = 4457.08,
                        admittedAt = LocalDate.of(2017, 10, 19)
                ),
                Employee(
                        id = "0002105",
                        name = "Dorthy Lee",
                        department = GOVERNANCE,
                        position = "Estagiário",
                        monthlySalary = 1491.45,
                        admittedAt = LocalDate.of(2015, 3, 16)
                ),
                Employee(
                        id = "0000273",
                        name = "Petersen Coleman",
                        department = GOVERNANCE,
                        position = "Estagiário",
                        monthlySalary = 1426.13,
                        admittedAt = LocalDate.of(2016, 9, 20)
                ),
                Employee(
                        id = "0007361",
                        name = "Avila Kane",
                        department = GOVERNANCE,
                        position = "Auxiliar Administrativo",
                        monthlySalary = 2166.25,
                        admittedAt = LocalDate.of(2016, 9, 16)
                ),
                Employee(
                        id = "0004237",
                        name = "Hess Sloan",
                        department = GOVERNANCE,
                        position = "Atendente",
                        monthlySalary = 2266.46,
                        admittedAt = LocalDate.of(2014, 10, 27)
                ),
                Employee(
                        id = "000538",
                        name = "Ashlee Wood",
                        department = GOVERNANCE,
                        position = "Auxiliar Administrativo",
                        monthlySalary = 2330.19,
                        admittedAt = LocalDate.of(2014, 7, 15)
                ),
                Employee(
                        id = "0014319",
                        name = "Abraham Jones",
                        department = GOVERNANCE,
                        position = "Diretor Tecnologia",
                        monthlySalary = 1805325.0,
                        admittedAt = LocalDate.of(2016, 7, 5)
                ),
                Employee(
                        id = "0006335",
                        name = "Bealah Long",
                        department = GOVERNANCE,
                        position = "Jovem Aprendiz",
                        monthlySalary = 1019.88,
                        admittedAt = LocalDate.of(2014, 8, 27)
                ),
                Employee(
                        id = "0007676",
                        name = "Maricela Martin",
                        department = GOVERNANCE,
                        position = "Copeiro",
                        monthlySalary = 1591.69,
                        admittedAt = LocalDate.of(2018, 1, 17)
                ),
                Employee(
                        id = "0002949",
                        name = "Stephenson Stone",
                        department = GOVERNANCE,
                        position = "Analista de Finanças",
                        monthlySalary = 5694.14,
                        admittedAt = LocalDate.of(2014, 1, 26)
                ),
                Employee(
                        id = "0008601",
                        name = "Taylor Mccarthy",
                        department = GOVERNANCE,
                        position = "Auxiliar de Ouvidoria",
                        monthlySalary = 1800.16,
                        admittedAt = LocalDate.of(2017, 3, 31)
                ),
                Employee(
                        id = "0006877",
                        name = "Cross Perkins",
                        department = GOVERNANCE,
                        position = "Líder de Ouvidoria",
                        monthlySalary = 3371.47,
                        admittedAt = LocalDate.of(2016, 12, 6)
                )
        ))
    }

    @Language("JSON")
    private val inputJSON = """[
   {
      "matricula":"0009968",
      "nome":"Victor Wilson",
      "area":"Diretoria",
      "cargo":"Diretor Financeiro",
      "salario_bruto":"R${'$'} 12.696,20",
      "data_de_admissao":"2012-01-05"
   },
   {
      "matricula":"0004468",
      "nome":"Flossie Wilson",
      "area":"Contabilidade",
      "cargo":"Auxiliar de Contabilidade",
      "salario_bruto":"R${'$'} 1.396,52",
      "data_de_admissao":"2015-01-05"
   },
   {
      "matricula":"0008174",
      "nome":"Sherman Hodges",
      "area":"Relacionamento com o Cliente",
      "cargo":"Líder de Relacionamento",
      "salario_bruto":"R${'$'} 3.899,74",
      "data_de_admissao":"2015-06-07"
   },
   {
      "matricula":"0007463",
      "nome":"Charlotte Romero",
      "area":"Financeiro",
      "cargo":"Contador Pleno",
      "salario_bruto":"R${'$'} 3.199,82",
      "data_de_admissao":"2018-01-03"
   },
   {
      "matricula":"0005253",
      "nome":"Wong Austin",
      "area":"Financeiro",
      "cargo":"Economista Júnior",
      "salario_bruto":"R${'$'} 2.215,04",
      "data_de_admissao":"2016-08-27"
   },
   {
      "matricula":"0004867",
      "nome":"Danielle Blanchard",
      "area":"Diretoria",
      "cargo":"Auxiliar Administrativo",
      "salario_bruto":"R${'$'} 2.768,28",
      "data_de_admissao":"2015-10-17"
   },
   {
      "matricula":"0001843",
      "nome":"Daugherty Kramer",
      "area":"Serviços Gerais",
      "cargo":"Atendente de Almoxarifado",
      "salario_bruto":"R${'$'} 2.120,08",
      "data_de_admissao":"2016-04-21"
   },
   {
      "matricula":"0007961",
      "nome":"Francesca Hewitt",
      "area":"Contabilidade",
      "cargo":"Auxiliar de Contabilidade",
      "salario_bruto":"R${'$'} 2.101,68",
      "data_de_admissao":"2015-06-21"
   },
   {
      "matricula":"0006806",
      "nome":"Ella Hale",
      "area":"Diretoria",
      "cargo":"Auxiliar Administrativo",
      "salario_bruto":"R${'$'} 2.571,73",
      "data_de_admissao":"2014-07-27"
   },
   {
      "matricula":"0005961",
      "nome":"Jillian Odonnell",
      "area":"Contabilidade",
      "cargo":"Contador Júnior",
      "salario_bruto":"R${'$'} 2.671,26",
      "data_de_admissao":"2016-09-08"
   },
   {
      "matricula":"0007293",
      "nome":"Morton Battle",
      "area":"Contabilidade",
      "cargo":"Economista Pleno",
      "salario_bruto":"R${'$'} 4.457,08",
      "data_de_admissao":"2017-10-19"
   },
   {
      "matricula":"0002105",
      "nome":"Dorthy Lee",
      "area":"Financeiro",
      "cargo":"Estagiário",
      "salario_bruto":"R${'$'} 1.491,45",
      "data_de_admissao":"2015-03-16"
   },
   {
      "matricula":"0000273",
      "nome":"Petersen Coleman",
      "area":"Financeiro",
      "cargo":"Estagiário",
      "salario_bruto":"R${'$'} 1.426,13",
      "data_de_admissao":"2016-09-20"
   },
   {
      "matricula":"0007361",
      "nome":"Avila Kane",
      "area":"Contabilidade",
      "cargo":"Auxiliar Administrativo",
      "salario_bruto":"R${'$'} 2.166,25",
      "data_de_admissao":"2016-09-16"
   },
   {
      "matricula":"0004237",
      "nome":"Hess Sloan",
      "area":"Relacionamento com o Cliente",
      "cargo":"Atendente",
      "salario_bruto":"R${'$'} 2.266,46",
      "data_de_admissao":"2014-10-27"
   },
   {
      "matricula":"000538",
      "nome":"Ashlee Wood",
      "area":"Contabilidade",
      "cargo":"Auxiliar Administrativo",
      "salario_bruto":"R${'$'} 2.330,19",
      "data_de_admissao":"2014-07-15"
   },
   {
      "matricula":"0014319",
      "nome":"Abraham Jones",
      "area":"Diretoria",
      "cargo":"Diretor Tecnologia",
      "salario_bruto":"R${'$'} 18.053.25",
      "data_de_admissao":"2016-07-05"
   },
   {
      "matricula":"0006335",
      "nome":"Bealah Long",
      "area":"Tecnologia",
      "cargo":"Jovem Aprendiz",
      "salario_bruto":"R${'$'} 1.019,88",
      "data_de_admissao":"2014-08-27"
   },
   {
      "matricula":"0007676",
      "nome":"Maricela Martin",
      "area":"Serviços Gerais",
      "cargo":"Copeiro",
      "salario_bruto":"R${'$'} 1.591,69",
      "data_de_admissao":"2018-01-17"
   },
   {
      "matricula":"0002949",
      "nome":"Stephenson Stone",
      "area":"Financeiro",
      "cargo":"Analista de Finanças",
      "salario_bruto":"R${'$'} 5.694,14",
      "data_de_admissao":"2014-01-26"
   },
   {
      "matricula":"0008601",
      "nome":"Taylor Mccarthy",
      "area":"Relacionamento com o Cliente",
      "cargo":"Auxiliar de Ouvidoria",
      "salario_bruto":"R${'$'} 1.800,16",
      "data_de_admissao":"2017-03-31"
   },
   {
      "matricula":"0006877",
      "nome":"Cross Perkins",
      "area":"Relacionamento com o Cliente",
      "cargo":"Líder de Ouvidoria",
      "salario_bruto":"R${'$'} 3.371,47",
      "data_de_admissao":"2016-12-06"
   }
]"""

}