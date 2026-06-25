package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.data.repository.TaskRepository
import java.util.concurrent.TimeUnit

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        delay(TimeUnit.SECONDS.toMillis(10))
        repository.deleteTask(taskId)
    }
}
