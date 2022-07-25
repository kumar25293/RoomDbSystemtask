package com.demo.roomdbsystemtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.roomdbsystemtask.databinding.ActivityMainBinding
import com.demo.roomdbsystemtask.dbwithschema.model.User
import com.demo.roomdbsystemtask.dbwithschema.repository.SchemaRepository
import com.demo.roomdbsystemtask.model.UsersData
import com.demo.roomdbsystemtask.repository.UserRepository

class MainActivity : AppCompatActivity() {

    var user:UsersData?=null
    var repository:UserRepository?=null

    var isRoomDBSchema: Boolean = false

    var schemarepository:SchemaRepository?=null

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        repository = UserRepository(this)
        schemarepository = SchemaRepository(this)
        isRoomDBSchema = false


        binding.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->

            isRoomDBSchema = isChecked
        }


        binding.tvCreate.setOnClickListener {

            if(!binding.etFirstname.text.isNullOrEmpty()
                &&!binding.etLastname.text.isNullOrEmpty()){

                    val ftname = binding.etFirstname.text.toString()
                val lname = binding.etLastname.text.toString()


                if(!isRoomDBSchema) {

                    val alluser: List<UsersData>? = repository?.getAllUsers()
                    alluser?.let {

                        if(!alluser.isNullOrEmpty()) {
                           alluser.forEach {
                               println("All users befir insert ${it?.userid} ---- ${it?.username} " +
                                       "--- ${it?.lastname}")

                           }
                        }
                    }


                    val user = UsersData(ftname, lname)

                    repository!!.insertUser(user)
                }
                else{
                    val alluser: List<User>? = schemarepository?.getAllUsers()
                    alluser?.let {
                        println("Schema All users before insert ${it}")
                    }


                    val user = User(ftname, lname)

                    schemarepository!!.insertUser(user)
                }
            }
        }

        binding.tvGetuser.setOnClickListener {

           val name = binding.etUsername.text.toString()
            val user: UsersData? = repository?.getUserByName(name)

            println("User name ${user?.userid} -- ${user?.username}")

//            val users:List<UsersData> = repository!!.getAllUsers()
//                   users?.let {
//                      val name = users?.first().username
//                       id?.let {
//                           val user: UsersData? = repository?.getUserByName(name)
//                       }
//                   }

        }


        binding.tvDeleteuser.setOnClickListener {
            val deleteusername = binding.etDeleteusername.text.toString()

            if(!isRoomDBSchema) {
                val users: UsersData = repository!!.getUserByName(deleteusername)
                users?.let {
                    val id = users?.userid
                    deleteusername?.let {
                        repository?.deletetUserByName(deleteusername)
                        println("User deleted")

                        val alluser: List<UsersData>? = repository?.getAllUsers()
                        println("All users ${alluser}")
                    }

                }
            }
            else{
                val userdetail:User? = schemarepository?.getUserByName(deleteusername)
                userdetail?.let {
                    val id = userdetail?.userid
                    deleteusername?.let {
                        repository?.deletetUserByName(deleteusername)
                        println("Schema User deleted")

                        val alluser: List<User>? = schemarepository?.getAllUsers()
                        println("Schema All users ${alluser}")
                    }

                }
            }

            }

        }

}