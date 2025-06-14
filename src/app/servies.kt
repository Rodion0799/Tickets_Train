package app


/**
 * Добавления билета в listTicket
 */
fun addTicket(listTicket: MutableList<Ticket>) {
    println("Введите данные, для покупки билета:")
    print("Имя -> ")
    val userName = readLine()!!.trim()
    if (userName.isBlank()) {
        throw IllegalArgumentException("Ошибка!")
    }

    print("Возвраст -> ")
    val userAge = readLine()!!.trim().toIntOrNull()
    if (userAge == null || userAge <= 0 || userAge > 95) {
        throw IllegalArgumentException("Ошибка!")
    }

    print("Город отправления -> ")
    val userDepartures = readLine()!!.trim()
    if (userDepartures.isBlank()) {
        throw IllegalArgumentException("Ошибка!")
    }

    print("Город прибытия -> ")
    val userArrival = readLine()!!.trim()
    if (userArrival.isBlank()) {
        throw IllegalArgumentException("Ошибка!")
    }

    listTicket.add(Ticket(userName, userAge, userDepartures, userArrival))
    println("Ваш билет добавлен в раздел -> Мои!\n")
}


/**
 * Выводит билеты, добавленные в listTicket
 */
fun myTicket(listTicket: MutableList<Ticket>) {
    if (listTicket.isEmpty()) {
        println("У вас нету билетов!\n")
        return
    }
    listTicket.forEachIndexed { index, ticket ->
        println("${index + 1}. ${ticket.name} (${ticket.age}) - ${ticket.departures} -> ${ticket.arrival}")
    }
    println()
}

/**
 * Удаление билета
 */
fun removeTicket(listTicket: MutableList<Ticket>) {
    if (listTicket.isEmpty()) {
        println("У вас нету билетов!\n")
        return
    }

    listTicket.forEachIndexed { index, ticket ->
        println("${index + 1}. ${ticket.name} (${ticket.age}) - ${ticket.departures} -> ${ticket.arrival}")
    }

    print("Выберите ID: ")
    val userID = readLine()!!.trim().toIntOrNull()
    if (userID == null || userID < 1  || userID > listTicket.size) {
        throw IllegalArgumentException("Ошибка!")
    }

    val index = userID - 1
    listTicket.removeAt(index)
    println("Билет успешно удален!\n")
}

/**
 * Выход из программы
 */
fun exit() {
    println("До скорых встреч!")
}