package abn.petclinic.testframework.testdata.enums

import abn.petclinic.testframework.dataclasses.PetForTests
import abn.petclinic.testframework.testdata.enums.PetTypesTestTemplates.*

enum class PetTestTemplates(private val pet: PetForTests, val description: String) {
    BASIC_PET(PetForTests(
        name = "Basilisk",
        birthDate = "2021-07-22",
        type = EXISTING_PET_TYPE.getPetType()
    ),"Basic Pet"),
    PET_WITH_SPACE_IN_NAME(PetForTests(
        name = "Pet with Space",
        birthDate = "2021-07-22",
        type = EXISTING_PET_TYPE.getPetType()
    ),"Pet with space in name"),
    PET_WITH_NO_TYPE(PetForTests(
        name = "Pettit",
        birthDate = "2022-07-11"
    ),"Pet without type specified"),
    PET_WITH_EMPTY_NAME(PetForTests(
        name = "",
        birthDate = "2021-07-22",
        type = EXISTING_PET_TYPE.getPetType()
    ),"Pet with empty name"),
    PET_WITH_EMPTY_BIRTH_DATE(PetForTests(
        name ="Woody",
        birthDate = "",
        type = EXISTING_PET_TYPE.getPetType()
    ),"Pet with empty birthdate"),
    PET_WITH_TOO_LONG_NAME(PetForTests(
        name = "a".repeat(31),
        birthDate = "2021-07-22",
        type = EXISTING_PET_TYPE.getPetType()
    ),"Pet with too long name"),
    PET_WITH_BIRTH_DATE_WRONG_FORMAT(PetForTests(
        name ="Doody",
        birthDate = "22.07.2019",
        type = EXISTING_PET_TYPE.getPetType()
    ),"Pet with birthdate in wrong format"),
    PET_WITH_NEW_PET_TYPE(PetForTests(
        name = "Hoody",
        birthDate = "2022-01-01",
        type = NEW_PET_TYPE.getPetType()
    ),"Pet with new pet type"),
    PET_BORN_IN_FUTURE(PetForTests(
        name = "Silver",
        birthDate = "2077-01-01",
        type = EXISTING_PET_TYPE.getPetType()
    ),"Pet born in future date"),;

    fun getPet(): PetForTests {
        return pet
    }
}
