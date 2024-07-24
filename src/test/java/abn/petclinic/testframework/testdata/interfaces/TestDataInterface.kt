package abn.petclinic.testframework.testdata.interfaces

import io.qameta.allure.SeverityLevel

interface TestDataInterface {
    val severity: SeverityLevel
    fun getDescription(): String
    fun getSeverityOfCase(): SeverityLevel {return this.severity}
}
