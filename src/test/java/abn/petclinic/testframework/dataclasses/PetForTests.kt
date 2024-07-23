package abn.petclinic.testframework.dataclasses

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PetForTests(
    val name: String,
    val birthDate: String,
    val type: PetTypeForTests?=null,
    var id: Int?=null,
    var ownerId: Int? = null,
    var visits: List<VisitForTests>?=null
)
