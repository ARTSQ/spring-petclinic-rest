package abn.petclinic.testframework.testdata.datasources

import abn.petclinic.testframework.dataclasses.OwnerForTests
import abn.petclinic.testframework.dataclasses.PetForTests
import abn.petclinic.testframework.testdata.enums.PetTestTemplates.*
import abn.petclinic.testframework.testdata.interfaces.TestDataInterface
import io.qameta.allure.SeverityLevel

data class PetTestData(
    val petData: PetForTests,
    val expectedResponseCode: Int,
    val petDescription: String,
    override val severity: SeverityLevel
):TestDataInterface
{
    override fun getDescription() = "Pet: $petDescription, expectedResponseCode: $expectedResponseCode"
}

val petsAdditionToOwnerTestData= listOf(
    PetTestData(BASIC_PET.getPet(),201, BASIC_PET.description,SeverityLevel.NORMAL),
    PetTestData(PET_WITH_SPACE_IN_NAME.getPet(), 201, PET_WITH_SPACE_IN_NAME.description,SeverityLevel.NORMAL),
    PetTestData(PET_WITH_NO_TYPE.getPet(), 400, PET_WITH_NO_TYPE.description,SeverityLevel.NORMAL),
    PetTestData(PET_WITH_EMPTY_NAME.getPet(), 400, PET_WITH_EMPTY_NAME.description,SeverityLevel.NORMAL),
    PetTestData(PET_WITH_TOO_LONG_NAME.getPet(), 400, PET_WITH_TOO_LONG_NAME.description,SeverityLevel.NORMAL),
    PetTestData(PET_WITH_EMPTY_BIRTH_DATE.getPet(), 400, PET_WITH_EMPTY_BIRTH_DATE.description,SeverityLevel.NORMAL),
    PetTestData(PET_WITH_BIRTH_DATE_WRONG_FORMAT.getPet(), 400, PET_WITH_BIRTH_DATE_WRONG_FORMAT.description,SeverityLevel.NORMAL),
    PetTestData(PET_WITH_NEW_PET_TYPE.getPet(), 400, PET_WITH_NEW_PET_TYPE.description,SeverityLevel.NORMAL),
    PetTestData(PET_BORN_IN_FUTURE.getPet(), 400, PET_BORN_IN_FUTURE.description,SeverityLevel.NORMAL)
)
