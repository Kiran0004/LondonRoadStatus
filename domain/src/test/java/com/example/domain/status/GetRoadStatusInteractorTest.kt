package com.example.domain.status


import com.example.domain.status.model.LineStatus
import com.nhaarman.mockito_kotlin.*
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class GetRoadStatusInteractorTest {

    private val mockStatusRepository = mock<StatusRepository>()
    private lateinit var getLinesStatusInteractor: GetRoadStatusInteractor

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getLinesStatusInteractor = GetRoadStatusInteractor(
            mockStatusRepository,
            TestRxSchedulersImpl()
        )
    }

    @Test
    fun shouldReturnErrorWhenItFailsToGetLinesStatus() {
        // given
        val throwable = Throwable()
        whenever(mockStatusRepository.getLinesStatus("A233"))
            .thenReturn(XsiNilLoader.Single.error(throwable))

        // when
        val testObserver = getLinesStatusInteractor.execute("A233").test()

        // then
        testObserver.assertError(throwable)
        verify(mockStatusRepository).getLinesStatus()
    }

    @Test
    fun shouldReturnListOfLineStatusWhenItSucceedsToGetLinesStatus() {
        // given
        whenever(mockStatusRepository.getLinesStatus("A2"))
            .thenReturn(Single.just(mutableListOf(getLineStatus())))

        // when
        val testObserver = getLinesStatusInteractor.execute("A2").test()

        // then
        verify(mockStatusRepository).getLinesStatus("A2")
        testObserver.assertComplete()
        testObserver.assertValue {
            it[0] == getLineStatus()
        }
    }

    private fun getLineStatus(): LineStatus {
        return LineStatus(
            id = "id",
            name = "name",
            severityLevel = "severity_level",
            severityLevelDescription = "severity_level_description"
        )
    }
}

class TestRxSchedulersImpl {

}
