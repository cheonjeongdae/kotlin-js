package util

fun testFun() {
    println("testFun function call")
}

@JsName("helloFun")
fun testFun2(arg: String) {
    println(" testFun2 call. arg = $arg")
}