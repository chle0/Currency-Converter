package tech.task.currencyconverter.core.onboarding.domain.use_cases

import tech.task.currencyconverter.core.onboarding.domain.repository.CountriesRepository
import javax.inject.Inject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import tech.task.currencyconverter.core.dto.response.BaseErrorResponse
import tech.task.currencyconverter.core.dto.response.CountriesResponseBody
import tech.task.currencyconverter.network.Resource
import java.io.IOException

class CountriesUseCase @Inject constructor(
    private val repository: CountriesRepository
) {
    operator fun invoke(): Flow<Resource<CountriesResponseBody>> = flow {
        try {
            emit(Resource.Loading<CountriesResponseBody>())
            val countries = repository.getCountriesDataList()
            emit(Resource.Success<CountriesResponseBody>(countries))
        } catch (e: HttpException) {
            val gson = Gson()
            val type = object : TypeToken<BaseErrorResponse>() {}.type
            val errorResponse: BaseErrorResponse? =
                gson.fromJson(e.response()?.errorBody()!!.charStream(), type)
            emit(
                Resource.Error<CountriesResponseBody>(
                    errorResponse?.message ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<CountriesResponseBody>("Couldn't reach server. Check your internet connection."))
        }
    }
}