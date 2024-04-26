package com.ads.datae


fun main() {

    val employ = Employ()

    employ.apply {
        name = "A"
        age = 10
    }

    employ.let {
        it.name = "A"
        it.age = 10
    }

    with(employ)
    {
        name = "A"
        age = 10
    }

    employ.run {
        name = "A"
        age = 10
    }
}
data class  Employ(var name :String = "",var age:Int=18)


