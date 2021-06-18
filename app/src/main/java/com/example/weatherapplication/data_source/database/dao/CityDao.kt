package com.example.weatherapplication.data_source.database.dao

import androidx.room.*
import com.example.weatherapplication.data_source.database.entity.CityEntity
import io.reactivex.Single

@Dao
interface CityDao {
    @Query("select * from city")
    fun getAll(): List<CityEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(list: List<CityEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAll(list: List<CityEntity>)

    @Delete
    fun deleteAll(list: List<CityEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(entity: CityEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(entity: CityEntity)

    @Delete
    fun delete(entity: CityEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: CityEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<CityEntity>)

    @Query("select * from city")
    fun getList(): Single<List<CityEntity>>

}