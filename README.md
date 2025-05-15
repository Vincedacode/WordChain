Word Chain Game
A Java-based word chain game where each new word must start with the last letter of the previous word. Supports saving/loading sessions, undo operations, and forward/backward word display.

Features
✅ Word Chaining – New words must start with the last letter of the previous word.
✅ Undo Functionality – Remove the last word with confirmation.
✅ File I/O – Save and load game sessions.
✅ Display Modes – View words in forward or reverse order.
✅ Duplicate Prevention – Ensures no repeated words.

How to Play
Add a Word

The first word can be anything.

Subsequent words must start with the last letter of the previous word.

Undo Last Word

Confirms before removing the last word.

Display Words

Forward Order (as entered)

Backward Order (reversed)

Save/Load Sessions

Save: Writes words to wordchain.txt.

Load: Reads words from wordchain.txt (replaces current session).

Code Structure
📁 Word_Chain.java – Core game logic (word chaining, undo, file I/O).
📁 Main.java – CLI menu driver.

How to Run
Compile & execute Main.java:

sh
javac WordChain/*.java
java WordChain.Main
Follow the on-screen menu.

jar
java -jar WordChainGame..jar

Future Improvements
🔹 Custom filenames for save/load.
🔹 Input validation (e.g., reject numbers/symbols).
🔹 Session statistics (word count, longest word).

Enjoy the game! 🎮
Contribute or report issues if you'd like!
