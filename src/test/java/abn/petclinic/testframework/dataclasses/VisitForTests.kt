package abn.petclinic.testframework.dataclasses

data class VisitForTests(
    val date: String,
    val description: String,
    var id: String? = null,
    val petId: String? = null
)
