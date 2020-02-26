package com.example.data.status

import com.example.data.status.model.LineStatusModelToLineStatusMapper
import com.example.domain.status.StatusRepository
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class StatusRepositoryImplTest {

    private val mockStatusService = mock<StatusService>()
    private lateinit var statusRepository: StatusRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        statusRepository = StatusRepositoryImpl(mockStatusService, LineStatusModelToLineStatusMapper())
    }

    @Test
    suspend fun shouldReturnThrowableWhenItFailsToFetchLinesStatus() {
        // given
        val throwable = Throwable()
        whenever(mockStatusService.getRoadStatus("A233")).thenReturn(Single.error(throwable))

        // when
        val testObserver = statusRepository.getLinesStatus("A233")

        // then
        testObserver.assertError(throwable)
        verify(mockStatusService).getRoadStatus("A233")
    }

    @Test
   suspend fun shouldReturnLinesStatusWhenItSucceedsToFetchThem() {
        // given
        whenever(mockStatusService.getRoadStatus("A2"))
            .thenReturn(Deferred.just(listOf(getLineStatusModel(), getLineStatusModel())))

        // when
        val testObserver = statusRepository.getLinesStatus("A2")

        // then
        testObserver.assertNoErrors()
        testObserver.assertValue {
            it[0].id === getExpectedLineStatus().id
        }
        verify(mockStatusService).getRoadStatus("A2")
    }
}
