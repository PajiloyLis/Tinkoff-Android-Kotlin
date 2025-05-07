import Employee

class Analyst : Employee()
{
    override fun haveLunch() {
        super.haveLunch()
        println("Задержусь там до 16:00")
    }

    override fun goHome() {
        super.goHome()
        println("Хотя пожалуй уйду в 17:00")
    }
}

fun main() {
    val smallAnalyst = Analyst()
    smallAnalyst.work()
    smallAnalyst.haveLunch()
    smallAnalyst.goHome()
}