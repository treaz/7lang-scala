val xValues = 1 to 4
val yValues = 1 to 2
val coordinates = for {
  x <- xValues
  y <- yValues
} yield (x, y)


val coords = xValues.flatMap(i =>
  yValues.map(j => (i, j))
)