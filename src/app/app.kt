package app

/**
 * Start
 */
fun main() {
    val listTicket = mutableListOf<Ticket>()
    while (true) {
        println("1. Добавить билет\n2. Мои билеты\n3. Удалить билет\n4. Поиск\n5. Выход")
        print("Введите ID -> ")
        val userIdTicket = readLine()!!.trim().toIntOrNull()
        if (userIdTicket == null || userIdTicket !in 1..5) {
            println("Ошибка!")
            return
        }
        when (userIdTicket) {
            1 -> addTicket(listTicket)
            2 -> myTicket(listTicket)
            3 -> removeTicket(listTicket)
            4 -> ticketSearch(listTicket)
            5 -> {
                exit()
                break
            }
        }
    }
}