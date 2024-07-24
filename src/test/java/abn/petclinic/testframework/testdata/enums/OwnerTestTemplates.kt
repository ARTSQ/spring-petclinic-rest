package abn.petclinic.testframework.testdata.enums

import abn.petclinic.testframework.dataclasses.OwnerForTests
import abn.petclinic.testframework.dataclasses.PetForTests
import abn.petclinic.testframework.dataclasses.PetTypeForTests

enum class OwnerTestTemplates(private val owner: OwnerForTests, val description: String) {
    BASIC_OWNER(OwnerForTests(
        firstName = "John",
        lastName = "Doe",
        address = "1234 Maple Street",
        city = "Springfield",
        telephone = "5551234",
    ),"Basic owner"),
    BASIC_OWNER2(OwnerForTests(
        firstName = "John",
        lastName = "Osbourne",
        address = "1313 Hellgate Street",
        city = "Birmingham",
        telephone = "6661313"
    ),"Basic owner 2"),
    OWNER_WITH_SPACE_IN_NAME(OwnerForTests(
        firstName = "John Michael",
        lastName = "Osbourne",
        address = "1313 Hellgate Street",
        city = "Birmingham",
        telephone = "6661313"
    ),"Owner with space in name"),
    OWNER_WITH_EMPTY_PET_LIST(OwnerForTests(
        firstName = "Alice",
        lastName = "Wonderland",
        address = "1 Imaginary Lane",
        city = "Fantasy",
        telephone = "100200300",
        pets = listOf()
    ),"Owner with empty pets list"),
    OWNER_WITH_ID(OwnerForTests(
        firstName = "Bob",
        lastName = "Builder",
        address = "9 Construction Rd",
        city = "BuilderTown",
        telephone = "101202303",
        id = "9999"
    ),"Owner with provided id"),
    OWNER_WITH_FAULTY_ID(OwnerForTests(
        firstName = "Bob",
        lastName = "Constructor",
        address = "9 Construction Rd",
        city = "BuilderTown",
        telephone = "101202303",
        id = "ABC"
    ),"Owner with faulty id"),
    OWNER_WITH_EMPTY_FIRST_NAME(OwnerForTests(
        firstName = "",
        lastName = "Carpenter",
        address = "10 Wooden Rd",
        city = "CarpenterTown",
        telephone = "10202303"
    ),"Owner with empty firstName"),
    OWNER_WITH_EMPTY_LAST_NAME(OwnerForTests(
        firstName = "John",
        lastName = "",
        address = "11 Wooden Rd",
        city = "CarpenterTown",
        telephone = "11202304"
    ), "Owner with empty lastName"),

    OWNER_WITH_EMPTY_ADDRESS(OwnerForTests(
        firstName = "Jane",
        lastName = "Smithings",
        address = "",
        city = "BuilderTown",
        telephone = "12202305"
    ), "Owner with empty address"),

    OWNER_WITH_EMPTY_CITY(OwnerForTests(
        firstName = "Jake",
        lastName = "Mason",
        address = "12 Stone Rd",
        city = "",
        telephone = "13202306"
    ), "Owner with empty city"),

    OWNER_WITH_EMPTY_TELEPHONE(OwnerForTests(
        firstName = "Jill",
        lastName = "Mason",
        address = "13 Stone Rd",
        city = "MasonTown",
        telephone = ""
    ), "Owner with empty telephone"),

    OWNER_WITH_TOO_LONG_FIRST_NAME(OwnerForTests(
        firstName = "a".repeat(31), // Exceeds max length of 30
        lastName = "Wooden",
        address = "Somewhere over the rainbow",
        city = "Oz",
        telephone = "3990290"
    ), "Owner with too long first name"),

    OWNER_WITH_TOO_LONG_LAST_NAME(OwnerForTests(
        firstName = "John",
        lastName = "b".repeat(31), // Exceeds max length of 30
        address = "Somewhere over the rainbow",
        city = "Oz",
        telephone = "3990290"
    ), "Owner with too long last name"),

    OWNER_WITH_TOO_LONG_ADDRESS(OwnerForTests(
        firstName = "John",
        lastName = "Oak",
        address = "c".repeat(256), // Exceeds max length of 255
        city = "Oz",
        telephone = "3990290"
    ), "Owner with too long address"),

    OWNER_WITH_TOO_LONG_CITY(OwnerForTests(
        firstName = "John",
        lastName = "Pinetree",
        address = "Somewhere over the rainbow",
        city = "d".repeat(61), // Exceeds max length of 60
        telephone = "3990290"
    ), "Owner with too long city"),

    OWNER_WITH_TOO_LONG_TELEPHONE(OwnerForTests(
        firstName = "John",
        lastName = "Silverback",
        address = "Somewhere over the rainbow",
        city = "Oz",
        telephone = "e".repeat(21) // Exceeds max length of 20
    ), "Owner with too long telephone"),

    OWNER_WITH_INCORRECT_PHONE_NUMBER(OwnerForTests(
        firstName = "John",
        lastName = "Dover",
        address = "Somewhere over the rainbow",
        city = "Somewhere over the rainbow",
        telephone = "13-2023-06"
    ), "Owner with wrong telephone format"),

    OWNER_WITH_PREDEFINED_PETS(OwnerForTests(
        firstName = "Ernest",
        lastName = "Hemingway",
        address = "Sea Street 1",
        city = "havana",
        telephone = "13202308",
        pets = listOf(
            PetForTests(
                name = "Gerome",
                birthDate = "2022-07-21",
                type = PetTypeForTests("cat")
            )
        )),"Owner with predefined pets"
    );

    fun getOwner(): OwnerForTests {
        return owner
    }
}
