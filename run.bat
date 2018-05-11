SET file="medium_input.txt"

javac -d build -cp src src/com/geo/Main.java
cd build
java com/geo/Main "%file%"
pause