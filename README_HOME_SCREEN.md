QuickBite Home Screen - JavaFX Version

Files:
- src/HomeScreen.java
- assets/background.png

This version uses JavaFX instead of Swing.

If JavaFX SDK is installed at:
C:\\javafx-sdk-21\\lib

Compile:
javac --module-path "C:\\javafx-sdk-21\\lib" --add-modules javafx.controls -d out src\\HomeScreen.java

Run:
java --module-path "C:\\javafx-sdk-21\\lib" --add-modules javafx.controls -cp out HomeScreen

Replace the JavaFX path if yours is different.
