package com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage

import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType.*
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.Question
import javax.inject.Inject

class ResultQuestionsStorage @Inject constructor() {

    fun getQuestions() = listOf(
        Question("Какой тип данных является типом с плавающей точкой" , listOf("Byte", "Short", "Float", "Long"), 3, JUNIOR, JUNIOR.score),
        Question("Возможна ли инициализация переменной\n\nval d : Double = 12" , listOf("Да", "Нет"), 2, JUNIOR, JUNIOR.score),
        Question("Что будет выведено в консоль \n\nprintln(5 / 2)" , listOf("2.5", "2", "Не скомпилируется", "3"), 2, JUNIOR, JUNIOR.score),
        Question("Что будет выведено в консоль \n\nprintln(5 % 2)" , listOf("1", "4", "Не скомпилируется", "3"), 1, JUNIOR, JUNIOR.score),
        Question("Есть ли ошибка в такой записи\n\nval s : String = null" , listOf("Да", "Нет"), 1, JUNIOR, JUNIOR.score),
        Question("Что будет выведено в консоль\n\nval s : Double = 2.5\nval s1 : Int = 2\nprintln(s == s1)" , listOf("true", "false", "Ошибка"), 3, JUNIOR, JUNIOR.score),
        Question("Какого ключевого слова нет в языке Kotlin" , listOf("break", "package", "is", "close"), 4, JUNIOR, JUNIOR.score),
        Question("Какое ключевое слово проверяет, что значение имеет определенный тип данных" , listOf("as", "is", "in", "this"), 2, JUNIOR, JUNIOR.score),
        Question("Какой оператор является оператором присваивания" , listOf("=", "==", "||", "&"), 1, JUNIOR, JUNIOR.score),
        Question("Какой оператор является оператором равества" , listOf("=", "==", "||", "&"), 2, JUNIOR, JUNIOR.score),
        Question("Какой оператор вводит аннотацию" , listOf("@", "&", "$", "!"), 1, JUNIOR, JUNIOR.score),
        Question("Какая запись цикла неверная" , listOf("for (i in 1..100)", "for (i in 100)", "while (true)", "do {} while (true)"), 2, JUNIOR, JUNIOR.score),
        Question("Что будет выведено в консоль\n\n${"try {\n" +
                "    throw Exception()\n" +
                "    print(\"try \")\n" +
                "} catch (e: Exception) {\n" +
                "    print(\"catch \")\n" +
                "} finally {\n" +
                "    print(\"finally \")\n" +
                "}"}" , listOf("Ничего", "try catch finally", "catch finally", "finally"), 3, JUNIOR, JUNIOR.score),
        Question("Укажите какой оператор называют Элвис оператор" , listOf("?.", "::", "?:", ".."), 3, JUNIOR, JUNIOR.score),
        Question("Объявление переменной только для чтения" , listOf("val", "var", "void", "this"), 1, JUNIOR, JUNIOR.score),
        Question("Возможно ли добавить элементы в такой список\n\nval numbers = listOf(1, 2, 3, 4)" , listOf("да", "нет"), 2, JUNIOR, JUNIOR.score),

        Question("Как проверить что ссылки указывают на один и тот же объект" , listOf("=", "==", "===", "->"), 3, JUNIOR, JUNIOR.score),
        Question("Что будет выведено в консоль\n\nval a = \"Hello\"\nval b = \"World\"\nprint(\"a \$b\")" , listOf("Hello World", "a World", "a b", "Ошибка компиляции"), 2, JUNIOR, JUNIOR.score),
        Question("Что будет выведено в консоль\n\nprintln(\"Hello\".length)" , listOf("5", "Hello", "Не скомпилируется", "1"), 1, JUNIOR, JUNIOR.score),
        Question("Какой тип данных называют логическим" , listOf("Boolean", "Float", "Byte", "Char"), 1, JUNIOR, JUNIOR.score),
        Question("Какой тип данных называют целочисленным" , listOf("Boolean", "Float", "Char", "Byte"), 4, JUNIOR, JUNIOR.score),
        Question("Возможна ли такая запись в kotlin\n\nvar name: String = \"Mike\"\nname = null" , listOf("Да", "Нет"), 2, JUNIOR, JUNIOR.score),
        Question("Что будет выведино в консоль\n\nval name = \"Mike\"\nname = \"Tomas\"\nprintln(name)" , listOf("Mike", "Tomas", "Mike Tomas", "Компилятор выдаст ошибку"), 4, JUNIOR, JUNIOR.score),
        Question("Что будет выведено в консоль\n\nprint(\"Hello \${\"world\".toUpperCase()}\")" , listOf("Hello world", "Компилятор выдаст ошибку", "Hello WORLD", "HELLO WORLD"), 3, JUNIOR, JUNIOR.score),
        Question("Что будет выведено в консоль\n\nprint(\"Hello\".plus(\" world\"))" , listOf("Helloworld", "Hello+world", "Hello.plus( world)", "Hello world"), 4, JUNIOR, JUNIOR.score),
        Question("Сколько итераций цикла отработают\n\nvar i = 0\n" +
                "    while (i < 10) {\n" +
                "        i++\n" +
                "        println(i)\n" +
                "        break\n" +
                "    }" , listOf("1", "10", "0", "9"), 1, JUNIOR, JUNIOR.score),
        Question("Какой модификатор доступа позволяет обращаться к переменной только внутри класса, в котором она была объявлена" , listOf("public", "private", "Такого модификатора нет", "protected"), 2, JUNIOR, JUNIOR.score),
        Question("Какое ключевое слово мгновенно завершает выполнение цикла" , listOf("return", "continue", "break", "loop"), 3, JUNIOR, JUNIOR.score),
        Question("Что выведется в консоль\n\nif (3 % 2 == 1) println(\"Работает\")\n" +
                "else println(\"Не работает\")" , listOf("Работает", "Не работает"), 4, JUNIOR, JUNIOR.score),
        Question("Какой оператор мгновенно переводит к следующей итерации цикла" , listOf("break", "continue", "return", "repeat"), 2, JUNIOR, JUNIOR.score),



        )
}





































