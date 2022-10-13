package com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.storages

import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.Question
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionTheme.*
import com.secondworld.buenas.testingonandroid.data.testing_screen.local.data_storage.models.QuestionType.*
import javax.inject.Inject

class QuestionsClassesStorage @Inject constructor() : BaseStorage {

    override val listQuestions: List<Question> = listOf(

        // Junior
        Question("Выберите класс в котлин, аналог класса Object" , listOf("Any", "Unit", "Nothing", "Open"), 1, JUNIOR, JUNIOR.score, CLASSES),
        Question("От какого класса наследуются все классы в kotlin", listOf("Object", "Any", "Open", "Singleton"), 2, JUNIOR, JUNIOR.score, CLASSES),

        Question("Какая запись data класса правильная" , listOf("data class Example", "data class Example(val id: Int)", "data class Example()"), 2, JUNIOR, JUNIOR.score, CLASSES),
        Question("Какие методы по умолчанию переопределены для data класса" , listOf("equals() hashCode() toString()", "hashCode() toString()", "hashCode() toString() getName()", "equals() hashCode() toString() copy()"), 3, JUNIOR, JUNIOR.score, CLASSES),

        Question("Что должно быть обязательно у класса чтобы от него могли наследоваться другие классы" , listOf("Ничего не требуется", "Перед классом - open", "Перед классом - abstract", "Перед классом - data"), 2, JUNIOR, JUNIOR.score, CLASSES),

        Question("Возможно ли создать экземпляр абстрактного класса" , listOf("да", "нет"), 2, JUNIOR, JUNIOR.score, CLASSES),
        Question("Возможно ли создать такой класс\n\n class Example {\n" +
                "    abstract fun some()\n" +
                "}" , listOf("да", "нет"), 2, JUNIOR, JUNIOR.score, CLASSES),
        Question("От скольких абстрактных классов может наследоваться класс", listOf("1", "2", "0", "от множества"), 1, JUNIOR, JUNIOR.score, CLASSES),
        Question("Может ли абстрактный класс наследоваться от другого абстрактного класса", listOf("Да", "Нет"), 1, JUNIOR, JUNIOR.score, CLASSES),

        Question("Сколько интерфейсов может реализовать класс", listOf("0", "1", "2", "множество"), 4, JUNIOR, JUNIOR.score, CLASSES),
        Question("Может ли интерфейс реализовать другой интерфейс", listOf("Да", "Нет"), 1, JUNIOR, JUNIOR.score, CLASSES),

        Question("Какого модификатора доступа нет в kotlin" , listOf("private", "protected", "package", "internal"), 3, JUNIOR, JUNIOR.score, CLASSES),
        Question("Если не указан модификтор доступа, то какой будет использован по умолчанию, в kotlin", listOf("private", "default", "public", "protected"), 3, JUNIOR, JUNIOR.score, CLASSES),
        Question("Модификатор доступа, который предоставляет видимость внутри модуля" , listOf("private", "protected", "public", "internal"), 4, JUNIOR, JUNIOR.score, CLASSES),
        Question("Модификатор доступа, который предоставляет видимость внутри класса" , listOf("private", "protected", "public", "internal"), 1, JUNIOR, JUNIOR.score, CLASSES),
        Question("Модификатор доступа, который предоставляет видимость по всему приложению" , listOf("private", "protected", "public", "internal"), 3, JUNIOR, JUNIOR.score, CLASSES),

        Question("В каком примере правильно создается экземпляр класса" , listOf("val example = new Example()", "val example = val Example()", "val example = Example()", "val example = Example"), 3, JUNIOR, JUNIOR.score, CLASSES),
        Question("Сколько конструкторов может иметь класс", listOf("1", "2", "множество", "0"), 3, JUNIOR, JUNIOR.score, CLASSES),
        Question("Как создать синглтон в kotlin" , listOf("singleton SomeSingleton", "class SomeSingleton", "data class SomeSingleton", "object SomeSingleton"), 4, JUNIOR, JUNIOR.score, CLASSES),

        Question("Какое ключевое слово нужно добавить для класса, чтобы он получил доступ к членам внешнего класса" , listOf("inner", "outer", "open", "private"), 1, JUNIOR, JUNIOR.score, CLASSES),




        )


}