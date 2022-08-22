package com.james.curly.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.james.curly.data.dao.CartDao
import com.james.curly.data.entity.CartEntity


@Database(entities = [CartEntity::class], version = 1)
abstract class CartDatabase:RoomDatabase() {

    abstract fun cartDao():CartDao

    companion object{
        /* @Volatile = 접근가능한 변수의 값을 cache를 통해 사용하지 않고
        thread가 직접 main memory에 접근 하게하여 동기화. */
        @Volatile
        private var instance : CartDatabase? = null

        // 싱글톤으로 생성 (자주 생성 시 성능 손해). 이미 존재할 경우 생성하지 않고 바로 반환
        fun getDatabase(context : Context) : CartDatabase? {
            if(instance == null){
                synchronized(CartDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CartDatabase::class.java,
                        "cart_database"
                    ).build()
                }
            }
            return instance
        }
    }
}