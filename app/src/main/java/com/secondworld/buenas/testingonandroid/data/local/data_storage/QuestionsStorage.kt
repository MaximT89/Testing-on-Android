package com.secondworld.buenas.testingonandroid.data.local.data_storage

import com.secondworld.buenas.testingonandroid.data.local.data_storage.QuestionType.*
import javax.inject.Inject

class QuestionsStorage @Inject constructor() {

    fun getQuestions() = listOf(
        Question(1, "Выберите класс в котлин, аналог класса Object" , listOf("Any", "Unit", "Nothing", "Open"), 1, JUNIOR, JUNIOR.score),
        Question(2, "Какой тип данных является типом с плавающей точкой" , listOf("Byte", "Short", "Float", "Long"), 3, JUNIOR, JUNIOR.score),
        Question(3, "Возможна ли инициализация переменной\n\n${"val d : Double = 12"}" , listOf("Да", "Нет"), 2, JUNIOR, JUNIOR.score),
        Question(4, "Что будет выведено в консоль \n\n${"println(5 / 2)"}" , listOf("2.5", "2", "Не скомпилируется", "3"), 2, JUNIOR, JUNIOR.score),
        Question(5, "Что будет выведено в консоль \n\n${"println(5 % 2)"}" , listOf("1", "4", "Не скомпилируется", "3"), 1, JUNIOR, JUNIOR.score),
        Question(6, "Есть ли ошибка в такой записи\n\n${"val s : String = null"}" , listOf("Да", "Нет"), 1, JUNIOR, JUNIOR.score),
        Question(7, "Что будет выведено в консоль\n\n${"val s : Double = 2.5\n" + "val s1 : Int = 2\n" + "println(s == s1)"}" , listOf("true", "false", "Ошибка"), 3, JUNIOR, JUNIOR.score),
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
        Question(21, "Возможно ли добавить элементы в такой список\n\n${"val numbers = listOf(1, 2, 3, 4)"}" , listOf("да", "нет"), 2, JUNIOR, JUNIOR.score),
        Question(21, "" , listOf("да", "нет"), 2, JUNIOR, JUNIOR.score),


        )
}