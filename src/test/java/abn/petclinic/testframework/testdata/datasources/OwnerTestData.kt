package abn.petclinic.testframework.testdata.datasources

import abn.petclinic.testframework.dataclasses.OwnerForTests
import abn.petclinic.testframework.testdata.enums.OwnerTestTemplates.*
import abn.petclinic.testframework.testdata.interfaces.TestDataInterface

data class OwnerTestData(
    val ownerData: OwnerForTests,
    val expectedResponseCode: Int,
    val ownerDescription: String,
): TestDataInterface {
    override fun getDescription() = "Owner class: $ownerDescription, expectedResponseCode: $expectedResponseCode"
}

val ownerCreationTestData = listOf(
    OwnerTestData(BASIC_OWNER.getOwner(),201, BASIC_OWNER.description),
    OwnerTestData(OWNER_WITH_SPACE_IN_NAME.getOwner(),201,OWNER_WITH_SPACE_IN_NAME.description),
    OwnerTestData(OWNER_WITH_EMPTY_PET_LIST.getOwner(), 201, OWNER_WITH_EMPTY_PET_LIST.description),
    OwnerTestData(OWNER_WITH_PREDEFINED_PETS.getOwner(),201,OWNER_WITH_PREDEFINED_PETS.description),
    OwnerTestData(OWNER_WITH_ID.getOwner(), 201, OWNER_WITH_ID.description),
    OwnerTestData(OWNER_WITH_EMPTY_FIRST_NAME.getOwner(), 400, OWNER_WITH_EMPTY_FIRST_NAME.description),
    OwnerTestData(OWNER_WITH_EMPTY_LAST_NAME.getOwner(), 400, OWNER_WITH_EMPTY_LAST_NAME.description),
    OwnerTestData(OWNER_WITH_EMPTY_ADDRESS.getOwner(), 400, OWNER_WITH_EMPTY_ADDRESS.description),
    OwnerTestData(OWNER_WITH_EMPTY_CITY.getOwner(), 400, OWNER_WITH_EMPTY_CITY.description),
    OwnerTestData(OWNER_WITH_EMPTY_TELEPHONE.getOwner(), 400, OWNER_WITH_EMPTY_TELEPHONE.description),
    OwnerTestData(OWNER_WITH_TOO_LONG_FIRST_NAME.getOwner(),400, OWNER_WITH_TOO_LONG_FIRST_NAME.description),
    OwnerTestData(OWNER_WITH_TOO_LONG_LAST_NAME.getOwner(), 400, OWNER_WITH_TOO_LONG_LAST_NAME.description),
    OwnerTestData(OWNER_WITH_TOO_LONG_ADDRESS.getOwner(), 400, OWNER_WITH_TOO_LONG_ADDRESS.description),
    OwnerTestData(OWNER_WITH_TOO_LONG_CITY.getOwner(), 400, OWNER_WITH_TOO_LONG_CITY.description),
    OwnerTestData(OWNER_WITH_TOO_LONG_TELEPHONE.getOwner(), 400, OWNER_WITH_TOO_LONG_TELEPHONE.description),
    OwnerTestData(OWNER_WITH_INCORRECT_PHONE_NUMBER.getOwner(),400, OWNER_WITH_INCORRECT_PHONE_NUMBER.description),
)

val ownerModificationTestData = listOf(
    OwnerTestData(BASIC_OWNER.getOwner(),204, BASIC_OWNER.description),
    OwnerTestData(OWNER_WITH_SPACE_IN_NAME.getOwner(),204,OWNER_WITH_SPACE_IN_NAME.description),
    OwnerTestData(OWNER_WITH_EMPTY_PET_LIST.getOwner(), 204, OWNER_WITH_EMPTY_PET_LIST.description),
    OwnerTestData(OWNER_WITH_ID.getOwner(), 204, OWNER_WITH_ID.description),
    OwnerTestData(OWNER_WITH_EMPTY_FIRST_NAME.getOwner(), 400, OWNER_WITH_EMPTY_FIRST_NAME.description),
    OwnerTestData(OWNER_WITH_EMPTY_LAST_NAME.getOwner(), 400, OWNER_WITH_EMPTY_LAST_NAME.description),
    OwnerTestData(OWNER_WITH_EMPTY_ADDRESS.getOwner(), 400, OWNER_WITH_EMPTY_ADDRESS.description),
    OwnerTestData(OWNER_WITH_EMPTY_CITY.getOwner(), 400, OWNER_WITH_EMPTY_CITY.description),
    OwnerTestData(OWNER_WITH_EMPTY_TELEPHONE.getOwner(), 400, OWNER_WITH_EMPTY_TELEPHONE.description),
    OwnerTestData(OWNER_WITH_TOO_LONG_FIRST_NAME.getOwner(),400, OWNER_WITH_TOO_LONG_FIRST_NAME.description),
    OwnerTestData(OWNER_WITH_TOO_LONG_LAST_NAME.getOwner(), 400, OWNER_WITH_TOO_LONG_LAST_NAME.description),
    OwnerTestData(OWNER_WITH_TOO_LONG_ADDRESS.getOwner(), 400, OWNER_WITH_TOO_LONG_ADDRESS.description),
    OwnerTestData(OWNER_WITH_TOO_LONG_CITY.getOwner(), 400, OWNER_WITH_TOO_LONG_CITY.description),
    OwnerTestData(OWNER_WITH_TOO_LONG_TELEPHONE.getOwner(), 400, OWNER_WITH_TOO_LONG_TELEPHONE.description),
    OwnerTestData(OWNER_WITH_INCORRECT_PHONE_NUMBER.getOwner(),400, OWNER_WITH_INCORRECT_PHONE_NUMBER.description),
    OwnerTestData(OWNER_WITH_FAULTY_ID.getOwner(),204, OWNER_WITH_FAULTY_ID.description),
)

val ownerDeletionTestData = listOf(
    OwnerTestData(BASIC_OWNER.getOwner(),204, BASIC_OWNER.description),
    OwnerTestData(OWNER_WITH_ID.getOwner(), 404, OWNER_WITH_ID.description),
    OwnerTestData(OWNER_WITH_FAULTY_ID.getOwner(),400, OWNER_WITH_FAULTY_ID.description)
)

val ownerGetByIdTestData = listOf(
    OwnerTestData(BASIC_OWNER.getOwner(),200, BASIC_OWNER.description),
    OwnerTestData(OWNER_WITH_ID.getOwner(), 404, OWNER_WITH_ID.description),
    OwnerTestData(OWNER_WITH_FAULTY_ID.getOwner(),400, OWNER_WITH_FAULTY_ID.description)
)
