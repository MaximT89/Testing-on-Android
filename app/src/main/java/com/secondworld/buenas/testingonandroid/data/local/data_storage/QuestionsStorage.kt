package com.secondworld.buenas.testingonandroid.data.local.data_storage

import com.secondworld.buenas.testingonandroid.data.local.data_storage.QuestionType.*
import javax.inject.Inject

class QuestionsStorage @Inject constructor() {

    fun getQuestions() = listOf(
        Question(1, "Выберите класс в котлин, аналог класса Object" , listOf("Any", "Unit", "Nothing", "Open"), 1, JUNIOR, JUNIOR.score),
        Question(2, "Какой тип данных является типом с плавающей точкой" , listOf("Byte", "Short", "Float", "Long"), 3, JUNIOR, JUNIOR.score),
        Question(3, "Возможна ли инициализация переменной\n\nval d : Double = 12" , listOf("Да", "Нет"), 2, JUNIOR, JUNIOR.score),
        Question(4, "Что будет выведено в консоль \n\nprintln(5 / 2)" , listOf("2.5", "2", "Не скомпилируется", "3"), 2, JUNIOR, JUNIOR.score),
        Question(5, "Что будет выведено в консоль \n\nprintln(5 % 2)" , listOf("1", "4", "Не скомпилируется", "3"), 1, JUNIOR, JUNIOR.score),
        Question(6, "Есть ли ошибка в такой записи\n\nval s : String = null" , listOf("Да", "Нет"), 1, JUNIOR, JUNIOR.score),
        Question(7, "Что будет выведено в консоль\n\nval s : Double = 2.5\nval s1 : Int = 2\nprintln(s == s1)" , listOf("true", "false", "Ошибка"), 3, JUNIOR, JUNIOR.score),
        Question(8, "Какого ключевого слова нет в языке Kotlin" , listOf("break", "package", "is", "close"), 4, JUNIOR, JUNIOR.score),
        Question(9, "Какое ключевое слово проверяет, что значение имеет определенный тип данных" , listOf("as", "is", "in", "this"), 2, JUNIOR, JUNIOR.score),
        Question(10, "Какой оператор является оператором присваивания" , listOf("=", "==", "||", "&"), 1, JUNIOR, JUNIOR.score),
        Question(11, "Какой оператор является оператором равества" , listOf("=", "==", "||", "&"), 2, JUNIOR, JUNIOR.score),
        Question(12, "Какой оператор вводит аннотацию" , listOf("@", "&", "$", "!"), 1, JUNIOR, JUNIOR.score),
        Question(13, "Какая запись цикла неверная" , listOf("for (i in 1..100)", "for (i in 100)", "while (true)", "do {} while (true)"), 2, JUNIOR, JUNIOR.score),
        Question(14, "Что будет выведено в консоль\n\n${"try {\n" +
                "    throw Exception()\n" +
                "    print(\"try \")\n" +
                "} catch (e: Exception) {\n" +
                "    print(\"catch \")\n" +
                "} finally {\n" +
                "    print(\"finally \")\n" +
                "}"}" , listOf("Ничего", "try catch finally", "catch finally", "finally"), 3, JUNIOR, JUNIOR.score),
        Question(15, "Какая запись data класса правильная" , listOf("data class Example", "data class Example(val id: Int)", "data class Example()"), 2, JUNIOR, JUNIOR.score),
        Question(16, "Какие методы по умолчанию переопределены для data класса" , listOf("equals() hashCode() toString()", "hashCode() toString()", "hashCode() toString() getName()", "equals() hashCode() toString() copy()"), 4, JUNIOR, JUNIOR.score),
        Question(17, "Укажите какой оператор называют Элвис оператор" , listOf("?.", "::", "?:", ".."), 3, JUNIOR, JUNIOR.score),
        Question(18, "Объявление переменной только для чтения" , listOf("val", "var", "void", "this"), 1, JUNIOR, JUNIOR.score),
        Question(19, "Что должно быть обязательно у класса чтобы от него могли наследоваться другие классы" , listOf("Ничего не требуется", "Перед классом - open", "Перед классом - abstract", "Перед классом - data"), 2, JUNIOR, JUNIOR.score),
        Question(20, "Возможно ли создать экземпляр абстрактного класса" , listOf("да", "нет"), 2, JUNIOR, JUNIOR.score),
        Question(21, "Возможно ли добавить элементы в такой список\n\nval numbers = listOf(1, 2, 3, 4)" , listOf("да", "нет"), 2, JUNIOR, JUNIOR.score),
        Question(22, "Возможно ли создать такой класс\n\n class Example {\n" +
                "    abstract fun some()\n" +
                "}" , listOf("да", "нет"), 2, JUNIOR, JUNIOR.score),
        Question(23, "Какого модификатора доступа нет в kotlin" , listOf("private", "protected", "package", "internal"), 3, JUNIOR, JUNIOR.score),
        Question(24, "Модификатор доступа, который предоставляет видимость внутри модуля" , listOf("private", "protected", "public", "internal"), 4, JUNIOR, JUNIOR.score),
        Question(25, "Как проверить что ссылки указывают на один и тот же объект" , listOf("=", "==", "===", "->"), 3, JUNIOR, JUNIOR.score),
        Question(26, "В каком примере правильно создается экземпляр класса" , listOf("val example = new Example()", "val example = val Example()", "val example = Example()", "val example = Example"), 3, JUNIOR, JUNIOR.score),
        Question(27, "Что будет выведено в консоль\n\nval a = \"Hello\"\nval b = \"World\"\nprint(\"a \$b\")" , listOf("Hello World", "a World", "a b", "Ошибка компиляции"), 2, JUNIOR, JUNIOR.score),
        Question(28, "Как создать синглтон в kotlin" , listOf("singleton SomeSingleton", "class SomeSingleton", "data class SomeSingleton", "object SomeSingleton"), 4, JUNIOR, JUNIOR.score),
        Question(29, "Что будет выведено в консоль\n\nprintln(\"Hello\".length)" , listOf("5", "Hello", "Не скомпилируется", "1"), 1, JUNIOR, JUNIOR.score),
        Question(30, "Какой тип данных называют логическим" , listOf("Boolean", "Float", "Byte", "Char"), 1, JUNIOR, JUNIOR.score),
        Question(31, "Какой тип данных называют целочисленным" , listOf("Boolean", "Float", "Char", "Byte"), 4, JUNIOR, JUNIOR.score),
        Question(32, "Возможна ли такая запись в kotlin\n\nvar name: String = \"Mike\"\nname = null" , listOf("Да", "Нет"), 2, JUNIOR, JUNIOR.score),
        Question(33, "Что будет выведино в консоль\n\nval name = \"Mike\"\nname = \"Tomas\"\nprintln(name)" , listOf("Mike", "Tomas", "Mike Tomas", "Компилятор выдаст ошибку"), 4, JUNIOR, JUNIOR.score),
        Question(34, "Что будет выведено в консоль\n\nprint(\"Hello \${\"world\".toUpperCase()}\")" , listOf("Hello world", "Компилятор выдаст ошибку", "Hello WORLD", "HELLO WORLD"), 3, JUNIOR, JUNIOR.score),
        Question(35, "Что будет выведено в консоль\n\nprint(\"Hello\".plus(\" world\"))" , listOf("Helloworld", "Hello+world", "Hello.plus( world)", "Hello world"), 4, JUNIOR, JUNIOR.score),
        Question(36, "Сколько итераций цикла отработают\n\nvar i = 0\n" +
                "    while (i < 10) {\n" +
                "        i++\n" +
                "        println(i)\n" +
                "        break\n" +
                "    }" , listOf("1", "10", "0", "9"), 1, JUNIOR, JUNIOR.score),
        Question(37, "Какой модификатор доступа позволяет обращаться к переменной только внутри класса, в котором она была объявлена" , listOf("public", "private", "Такого модификатора нет", "protected"), 2, JUNIOR, JUNIOR.score),
        Question(38, "Какое ключевое слово мгновенно завершает выполнение цикла" , listOf("return", "continue", "break", "loop"), 3, JUNIOR, JUNIOR.score),
        Question(39, "Что выведется в консоль\n\nif (3 % 2 == 1) println(\"Работает\")\n" +
                "else println(\"Не работает\")" , listOf("Работает", "Не работает", "", ""), 4, JUNIOR, JUNIOR.score),
        Question(40, "Какой оператор мгновенно переводит к следующей итерации цикла" , listOf("break", "continue", "return", "repeat"), 2, JUNIOR, JUNIOR.score),
        )
}





































