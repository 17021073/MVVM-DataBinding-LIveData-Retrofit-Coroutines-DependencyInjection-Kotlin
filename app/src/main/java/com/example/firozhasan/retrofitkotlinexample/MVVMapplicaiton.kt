package com.example.firozhasan.retrofitkotlinexample

import android.app.Application
import com.example.firozhasan.retrofitkotlinexample.model.api.CountriesAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.LoginAPI
import com.example.firozhasan.retrofitkotlinexample.model.api.NetworkConnectionInterceptor
import com.example.firozhasan.retrofitkotlinexample.model.repos.AllCountriesRepository
import com.example.firozhasan.retrofitkotlinexample.model.repos.CountryDetailsRepository
import com.example.firozhasan.retrofitkotlinexample.model.repos.FindCountryRepository
import com.example.firozhasan.retrofitkotlinexample.model.repos.LoginRepository
import com.example.firozhasan.retrofitkotlinexample.viewModel.AllCountriesViewModelFactory
import com.example.firozhasan.retrofitkotlinexample.viewModel.AuthViewModelFactory
import com.example.firozhasan.retrofitkotlinexample.viewModel.CountryDetailsViewModelFactory
import com.example.firozhasan.retrofitkotlinexample.viewModel.FindCountryViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMapplicaiton : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMapplicaiton))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { LoginAPI(instance()) }
        bind() from singleton { CountriesAPI(instance()) }
        bind() from singleton { LoginRepository(instance()) }
        bind() from singleton { AllCountriesRepository(instance()) }
        bind() from singleton { CountryDetailsRepository(instance()) }
        bind() from singleton { FindCountryRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance())}
        bind() from provider { CountryDetailsViewModelFactory(instance())}
        bind() from provider { AllCountriesViewModelFactory(instance()) }
        bind() from provider { FindCountryViewModelFactory(instance()) }
    }
}
