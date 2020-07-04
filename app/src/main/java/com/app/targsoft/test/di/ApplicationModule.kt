package com.app.targsoft.test.di

import android.content.Context
import com.app.targsoft.test.data.api.CatApi
import com.app.targsoft.test.data.api.CatApiHelper
import com.app.targsoft.test.data.api.CatApiHelperImpl
import com.app.targsoft.test.data.datasource.database.FavoriteCatDao
import com.app.targsoft.test.data.datasource.database.FavoriteCatDataSource
import com.app.targsoft.test.data.datasource.network.RemoteCatDataSource
import com.app.targsoft.test.data.datasource.network.RemoteCatDataSourceImpl
import com.app.targsoft.test.data.mapper.MapperCatToFavoriteCat
import com.app.targsoft.test.data.repository.CatRepositoryImpl
import com.app.targsoft.test.domain.repository.CatRepository
import com.app.targsoft.test.domain.usecases.AddCatToFavoriteUseCase
import com.app.targsoft.test.domain.usecases.GetPagingCatsUseCase
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    companion object {
        private const val API = "https://api.thecatapi.com/v1/"
    }

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()



    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return OkHttpClient.Builder().addInterceptor(logging).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okhttp: OkHttpClient, moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(API)
            .client(okhttp)
            .build()

    @Provides
    @Singleton
    fun provideCatsApi(retrofit: Retrofit): CatApi = retrofit.create(CatApi::class.java)

    @Provides
    @Singleton
    fun provideCatApiHelper(api: CatApi): CatApiHelper = CatApiHelperImpl(api = api)

    @Provides
    @Singleton
    fun provideRemoteCatDataSource(apiHelper: CatApiHelper): RemoteCatDataSource = RemoteCatDataSourceImpl(apiHelper)

    @Provides
    @Singleton
    fun provideFavoriteCatDao(@ApplicationContext context: Context): FavoriteCatDao = FavoriteCatDataSource.getDatabase(context).animalDao()

    @Provides
    fun provideMapperCatToFavoriteCat(): MapperCatToFavoriteCat = MapperCatToFavoriteCat()

    @Provides
    fun provideCoroutineDispatcher() : CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideCatRepository(
        remoteCatDataSource: RemoteCatDataSource,
        favoriteCatDataBase: FavoriteCatDao,
        mapper: MapperCatToFavoriteCat,
        ioDispatcher: CoroutineDispatcher
    ): CatRepository =
        CatRepositoryImpl(
            remoteCatDataSource = remoteCatDataSource,
            favoriteCatDatabase = favoriteCatDataBase,
            mapper = mapper,
            ioDispatcher = ioDispatcher
        )

    @Provides
    fun provideAddCatToFavoriteUseCase(repo: CatRepository): AddCatToFavoriteUseCase = AddCatToFavoriteUseCase(repo)

    @Provides
    fun provideGetPagingCatsUseCase(repo: CatRepository): GetPagingCatsUseCase = GetPagingCatsUseCase(repo)

}