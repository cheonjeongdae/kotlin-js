import kotlinx.html.a
import kotlinx.html.dom.create
import kotlinx.html.img
import kotlinx.html.js.tr
import kotlinx.html.td
import kotlin.browser.document

external class XMLHttpRequest

data class User(val avatar_url: String, val login: String, val html_url: String, val type: String)

// 시작시 기본 로딩
fun main(args: Array<String>) {
    println("github 로 부터 사용자를 가져 옵니다.")
    getListUser()
}

fun showUserList(msg: String){
    val root = document.getElementById("userList")

    val list=JSON.parse<Array<User>>(msg)
    list.forEach {

        val tr = document.create.tr {
            td {
                attributes["scope"] = "col"
                img("rounded-circle"){
                    src=it.avatar_url
                    width="50"
                }
            }
            td {
                attributes["scope"] = "col"
                + it.login
            }
            td {
                attributes["scope"] = "col"
                a {
                    href=it.html_url
                    + it.html_url
                }
            }
            td {
                attributes["scope"] = "col"
                + it.type
            }
        }
        root?.appendChild(tr)
    }
}

fun getListUser(){
    var xhr: dynamic = XMLHttpRequest();
    xhr.open("GET", "https://api.github.com/users", true);

    xhr.onreadystatechange=fun(){
        if (xhr.readyState == 4 && xhr.status == 200) {
            println(xhr.responseText)
            showUserList(xhr.responseText)
        }
    }
    xhr.send();
}


