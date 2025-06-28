package app


/**
 * Добавления билета в listTicket
 */
fun addTicket(listTicket: TicketList) {
    println("Введите данные, для покупки билета:")
    print("Имя -> ")
    val userName = readLine()!!.trim()
    if (userName.isBlank()) {
        println(ERROR.message)
        return
    }

    print("Возвраст -> ")
    val userAge = readLine()!!.trim().toIntOrNull()
    if (userAge == null || userAge <= 0 || userAge > 95) {
        println(ERROR.message)
        return
    }

    print("Город отправления -> ")
    val userDepartures = readLine()!!.trim()
    if (userDepartures.isBlank()) {
        println(ERROR.message)
        return
    }

    print("Город прибытия -> ")
    val userArrival = readLine()!!.trim()
    if (userArrival.isBlank()) {
        println(ERROR.message)
        return
    }

    listTicket.add(Ticket(userName, userAge, userDepartures, userArrival))
    println("Ваш билет добавлен в раздел -> Мои!\n")
}


/**
 * Выводит билеты, добавленные в listTicket
 */
fun myTicket(listTicket: TicketList) {
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
fun removeTicket(listTicket: TicketList) {
    if (listTicket.isEmpty()) {
        println("У вас нету билетов!\n")
        return
    }

    listTicket.forEachIndexed { index, ticket ->
        println("${index + 1}. ${ticket.name} (${ticket.age}) - ${ticket.departures} -> ${ticket.arrival}")
    }

    print("Выберите ID: ")
    val userID = readLine()!!.trim().toIntOrNull()
    if (userID == null || userID < 1 || userID > listTicket.size) {
        println(ERROR.message)
        return
    }

    val index = userID - 1
    listTicket.removeAt(index)
    println("Билет успешно удален!\n")
}

/**
 * Поиск билетов
 */
fun ticketSearch(listTicket: TicketList) {
    if (listTicket.isEmpty()) {
        println("У вас нету билетов!\n")
        return
    }

    println("Поиск:")
    print("Введите город отправления, или город прибытия: ")
    val userCity = readLine()!!.trim()
    if (userCity.isBlank()) {
        println(ERROR.message)
        return
    }

    val search = listTicket.filter {
        it.departures.contains(userCity, ignoreCase = true) ||
                it.arrival.contains(userCity, ignoreCase = true)
    }

    if (search.isEmpty()) {
        println("Не найдено!\n")
        return
    }

    search.forEachIndexed { index, ticket ->
        println("${index + 1}. ${ticket.name} (${ticket.age}) - ${ticket.departures} -> ${ticket.arrival}")
    }

    print("Купить билет: \"Да\" или \"Нет\": ")
    val userBuy = readLine()!!.trim()
    if (userBuy.isBlank()) {
        println(ERROR)
        return
    }

    when(userBuy) {
        "Да" -> {
            print("Выберите ID: ")
            val userID = readLine()!!.trim().toIntOrNull()
            if (userID == null || userID !in 1..search.size) {
                println(ERROR)
                return
            }
            val index = search[userID - 1]
            listTicket.add(index)
            println("Билет добавлен в раздел: \"Мои\"\n")
            return
        }

        "Нет" -> {
            println()
            return
        }

        else -> {
            println("Нет такой команды!\n")
            return
        }
    }
}

/**
 * Выход из программы
 */
fun exit() {
    println("До скорых встреч!")
}