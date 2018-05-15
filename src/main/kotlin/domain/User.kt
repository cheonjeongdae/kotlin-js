package domain

class User {
    init {
        println("i am init block......")
    }

    constructor() {
        println("i am constructor.....")
    }

    fun study(): Int {
        println("지금 슬립 스터디 중입니다.")
        return 5
    }
}