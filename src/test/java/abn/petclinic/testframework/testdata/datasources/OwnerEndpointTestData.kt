package abn.petclinic.testframework.testdata.datasources

import abn.petclinic.testframework.dataclasses.OwnerForTests
import abn.petclinic.testframework.testdata.enums.OwnerTestTemplates.*
import abn.petclinic.testframework.testdata.interfaces.TestDataInterface

data class OwnerEndpointTestData(
    val ownerData: OwnerForTests,
    val expectedResponseCode: Int,
    val ownerDescription: String,
): TestDataInterface {
    override fun getDescription() = "Owner class: $ownerDescription, expectedResponseCode: $expectedResponseCode"
}

val ownerCreationTestData = listOf(
    OwnerEndpointTestData(BASIC_OWNER.getOwner(),201, BASIC_OWNER.description),
    OwnerEndpointTestData(OWNER_WITH_SPACE_IN_NAME.getOwner(),201,OWNER_WITH_SPACE_IN_NAME.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_PET_LIST.getOwner(), 201, OWNER_WITH_EMPTY_PET_LIST.description),
    OwnerEndpointTestData(OWNER_WITH_PREDEFINED_PETS.getOwner(),201,OWNER_WITH_PREDEFINED_PETS.description),
    OwnerEndpointTestData(OWNER_WITH_ID.getOwner(), 201, OWNER_WITH_ID.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_FIRST_NAME.getOwner(), 400, OWNER_WITH_EMPTY_FIRST_NAME.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_LAST_NAME.getOwner(), 400, OWNER_WITH_EMPTY_LAST_NAME.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_ADDRESS.getOwner(), 400, OWNER_WITH_EMPTY_ADDRESS.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_CITY.getOwner(), 400, OWNER_WITH_EMPTY_CITY.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_TELEPHONE.getOwner(), 400, OWNER_WITH_EMPTY_TELEPHONE.description),
    OwnerEndpointTestData(OWNER_WITH_TOO_LONG_NAME.getOwner(),400, OWNER_WITH_TOO_LONG_NAME.description),
    OwnerEndpointTestData(OWNER_WITH_INCORRECT_PHONE_NUMBER.getOwner(),400, OWNER_WITH_INCORRECT_PHONE_NUMBER.description),
)

val ownerModificationTestData = listOf(
    OwnerEndpointTestData(BASIC_OWNER.getOwner(),204, BASIC_OWNER.description),
    OwnerEndpointTestData(OWNER_WITH_SPACE_IN_NAME.getOwner(),204,OWNER_WITH_SPACE_IN_NAME.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_PET_LIST.getOwner(), 204, OWNER_WITH_EMPTY_PET_LIST.description),
    OwnerEndpointTestData(OWNER_WITH_ID.getOwner(), 204, OWNER_WITH_ID.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_FIRST_NAME.getOwner(), 400, OWNER_WITH_EMPTY_FIRST_NAME.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_LAST_NAME.getOwner(), 400, OWNER_WITH_EMPTY_LAST_NAME.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_ADDRESS.getOwner(), 400, OWNER_WITH_EMPTY_ADDRESS.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_CITY.getOwner(), 400, OWNER_WITH_EMPTY_CITY.description),
    OwnerEndpointTestData(OWNER_WITH_EMPTY_TELEPHONE.getOwner(), 400, OWNER_WITH_EMPTY_TELEPHONE.description),
    OwnerEndpointTestData(OWNER_WITH_TOO_LONG_NAME.getOwner(),400, OWNER_WITH_TOO_LONG_NAME.description),
    OwnerEndpointTestData(OWNER_WITH_INCORRECT_PHONE_NUMBER.getOwner(),400, OWNER_WITH_INCORRECT_PHONE_NUMBER.description),
    OwnerEndpointTestData(OWNER_WITH_FAULTY_ID.getOwner(),404, OWNER_WITH_FAULTY_ID.description),
)

val ownerDeletionTestData = listOf(
    OwnerEndpointTestData(BASIC_OWNER.getOwner(),204, BASIC_OWNER.description),
    OwnerEndpointTestData(OWNER_WITH_ID.getOwner(), 204, OWNER_WITH_ID.description),
    OwnerEndpointTestData(OWNER_WITH_FAULTY_ID.getOwner(),404, OWNER_WITH_FAULTY_ID.description)
)

val ownerGetByIdTestData = listOf(
    OwnerEndpointTestData(BASIC_OWNER.getOwner(),200, BASIC_OWNER.description),
    OwnerEndpointTestData(OWNER_WITH_ID.getOwner(), 404, OWNER_WITH_ID.description),
    OwnerEndpointTestData(OWNER_WITH_FAULTY_ID.getOwner(),400, OWNER_WITH_FAULTY_ID.description)
)
