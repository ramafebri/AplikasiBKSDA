package com.example.aplikasibksda.view.mainmenu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainMenuViewModel: ViewModel() {
    private val _selectedTab = MutableLiveData<TabName>()
    val selectedTab: LiveData<TabName> = _selectedTab

    fun setSelectedTab(tabName: TabName){
        _selectedTab.value = tabName
    }
}