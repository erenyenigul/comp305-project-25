# COMP305 Project Group 25

## To-Do
12 May 2021 - Think about a method for string distance calculation </br>
15 May 2021 - Brute force and WordTree implementation </br>
18 May 2021 - Combining solutions </br>
1 June 2021 - Add memoization to WordTree implementation </br>
2 June 2021 - Preparing presentation

## Group Members:
Anıl Asım Bilen </br>
Naz Yüksek </br>
Cağatay Soylu</br>
Eren Yenigül</br>

##How to run:

javac -cp src src/Main.java </br>
java -cp src src/Main.java <|optional args|>

Default arguments are: <br>
D = words.txt <br>
N = 5

##Analysis:

String Distance Function : O(n*m) <br>
where:<br>
n: length of the first word <br>
m: length of the second word <br>

Brute Force Solution : O(n * m *z) <br>
where:<br>
n: searched word length<br>
m: average word length in dictionary<br>
z: dictionary size

Word Tree Solution : O(n * m * log z)<br>
where:<br>
n: searched word length<br>
m: average word length in dictionary<br>
z: dictionary size
