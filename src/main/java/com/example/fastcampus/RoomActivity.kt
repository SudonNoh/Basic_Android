package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.room.*
import androidx.room.Database
import org.w3c.dom.Text

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        // 기본적으로 데이터베이스 작업은 MainThread 에서 할 수 없다.
        // 이유는 데이터베이스 작업을 휴대폰이 하는 동안 사용자가 기다려야 하기 때문
        // 해결책은 Thread 를 이용하거나 async 를 이용하면 된다.
        val database = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user-database"
        ).allowMainThreadQueries().build()

        findViewById<TextView>(R.id.save).setOnClickListener {
            val userProfile = UserProfile("홍", "길동")
            database.userProfileDao().insert(userProfile)
        }

        findViewById<TextView>(R.id.load).setOnClickListener {
            val userProfiles = database.userProfileDao().getAll()
            userProfiles.forEach {
                Log.d("testt", "id: ${it.id} // firstName: ${it.firstName}")
            }
        }
        findViewById<TextView>(R.id.delete).setOnClickListener {
            database.userProfileDao().delete(1)
        }
    }
}

// 데이터베이스에서 ENTITY 로 사용하겠다는 의미
// Table
@Entity
class UserProfile(

    // id 값으로 사용
    @PrimaryKey(autoGenerate = true) val id: Int,

    // 데이터베이스에 이름을 설정하는 방법
    // 사용하는 이유: Kotlin 에서는 카멜케이스를 사용하지만 데이터베이스에서는 스네이크케이스를 사용하는 경우가
    // 많기 때문
    @ColumnInfo(name = "last_name")
    val lastName: String,

    @ColumnInfo(name = "first_name")
    val firstName: String
) {
    constructor(lastName: String, firstName: String) : this(0, lastName, firstName)
}

// Data Access Object
@Dao
interface UserProfileDao {
    // CRUD -> 데이터베이스 조작
    // Query -> 데이터베이스 조회

    // onConflict = REPLACE : Primary Key 에 이미 저장된 항목이 잇을 경우 데이터를 덮어 씌우는 방법
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userProfile: UserProfile)

    @Query("DELETE FROM userprofile WHERE id = :userId")
    fun delete(userId: Int)

    @Query("SELECT * FROM UserProfile")
    fun getAll(): List<UserProfile>
}

// abstract : 비어있는 것
@Database(entities = [UserProfile::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao
}