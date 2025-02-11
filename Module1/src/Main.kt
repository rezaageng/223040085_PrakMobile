//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main(args: Array<String>) {
    val rectangle = Rectangle()

    val width = args[0].toInt()
    val height = args[1].toInt()

    println(
        "width: $width \nheight: $height \nArea: ${
            rectangle.area(
                width,
                height
            )
        } \nPerimeter: ${rectangle.perimeter(width, height)}"
    )
}