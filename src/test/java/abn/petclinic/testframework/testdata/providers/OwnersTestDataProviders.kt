package abn.petclinic.testframework.testdata.providers

import abn.petclinic.testframework.testdata.datasources.ownerCreationTestData
import abn.petclinic.testframework.testdata.datasources.ownerDeletionTestData
import abn.petclinic.testframework.testdata.datasources.ownerGetByIdTestData
import abn.petclinic.testframework.testdata.datasources.ownerModificationTestData
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class OwnersCreationTestDataProvider: ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return ownerCreationTestData.stream().map { Arguments.of(it, it.getDescription()) }
    }
}

class OwnersModificationTestDataProvider: ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return ownerModificationTestData.stream().map { Arguments.of(it, it.getDescription()) }
    }
}

class OwnersDeletionTestDataProvider: ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return ownerDeletionTestData.stream().map { Arguments.of(it, it.getDescription()) }
    }
}

class OwnerGetByIdTestDataProvider: ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return ownerGetByIdTestData.stream().map { Arguments.of(it, it.getDescription()) }
    }
}
