package tech.task.currencyconverter.core.onboarding.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.task.currencyconverter.core.onboarding.data.remote.CountriesApi
import tech.task.currencyconverter.core.onboarding.data.repository.CountriesRepositoryImpl
import tech.task.currencyconverter.core.onboarding.domain.repository.CountriesRepository
import tech.task.currencyconverter.network.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun countriesApi(): CountriesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.COUNTRIES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCountriesRepository(api: CountriesApi): CountriesRepository {
        return CountriesRepositoryImpl(api)
    }
}