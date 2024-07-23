package abn.petclinic.testframework.dataclasses

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class OwnerForTests(
    val firstName: String,
    val lastName: String,
    val address: String,
    val city: String,
    val telephone: String,
    val pets: List<PetForTests>? = null,
    var id: String? =null
)
