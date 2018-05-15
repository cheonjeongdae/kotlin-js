
import kotlin.browser.document

external class XMLHttpRequest

data class User(val avatar_url: String, val login: String, val html_url: String, val type: String)

// 시작시 기본 로딩
fun main(args: Array<String>) {
    getListUser()
}

fun showUserList(msg: String){
    val root = document.getElementById("userList")

    val list=JSON.parse<Array<User>>(msg)
    list.forEach {
        val tr = document.createElement("tr")

        val imgTd = document.createElement("td")
        imgTd.setAttribute("scope","col")
        val img= document.createElement("img")
        img.setAttribute("src", it.avatar_url)
        img.setAttribute("class","rounded-circle")
        img.setAttribute("width","50")
        imgTd.appendChild(img)
        tr.appendChild(imgTd)

        val nameTd = document.createElement("td")
        nameTd.setAttribute("scope","col")
        nameTd.textContent=it.login
        tr.appendChild(nameTd)

        val homeTd = document.createElement("td")
        homeTd.setAttribute("scope","col")
        val homeA = document.createElement("a")
        homeA.setAttribute("href", it.html_url)
        homeA.textContent=it.html_url
        homeTd.appendChild(homeA)
        tr.appendChild(homeTd)

        val typeTd = document.createElement("td")
        typeTd.setAttribute("scope","col")
        typeTd.textContent=it.type
        tr.appendChild(typeTd)

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


