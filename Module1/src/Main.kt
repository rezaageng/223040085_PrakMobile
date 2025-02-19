//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>) {
    println("Hello World")
    println(args.contentToString())

    var name: String = "rezaa"
    println(name)

    var age: Int = 21
    println(age)

    if (age >= 18) {
        println("You are an adult")
    } else {
        println("You are a child")
    }

    when (age) {
        in 0..17 -> println("You are a child")
        else -> println("You are a senior")
    }

    for (i in 1..5) {
        println(i)
    }

    var i = 0;
    while (i < 5) {
        println(i)
        i++
    }

    do {
        println(i)
        i++
    } while (i < 5)


    greet("Reza")

    val greet = { name: String -> greet(name) }
    greet("Reza")

//    val rectangle = Rectangle()
//
//    val width = args[0].toInt()
//    val height = args[1].toInt()
//
//    println(
//        "width: $width \nheight: $height \nArea: ${
//            rectangle.area(
//                width,
//                height
//            )
//        } \nPerimeter: ${rectangle.perimeter(width, height)}"
//    )

    if (args.isEmpty()) {
        println("Please provide a grade")
        return
    }

    val gradeIndex = GradeIndex()
    val grade = args[0].toInt()
    println("Grade: $grade \nGrade Index: ${gradeIndex.getGradeIndex(grade)}")
}

fun greet(name: String) {
    println("Hello $name")
}