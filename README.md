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
N = 5 <br>

##Analysis:

String Distance Function : O(n*m) time, O(n*m) space <br>
where:<br>
n: length of the first word <br>
m: length of the second word <br>

Brute Force Solution : O(n * m * z) time , O(z) space <br>
where:<br>
n: searched word length<br>
m: average word length in dictionary<br>
z: dictionary size

Word Tree Solution : O(n * m * log z) time , O(z) space<br>
where:<br>
n: searched word length<br>
m: average word length in dictionary<br>
z: dictionary size

Summary of what we did: <br>
We first thought about the brute force implementation, where we iterate over the dictionary and calculate the distance between each word and the given word and we output the words that are closest to the given input word. Then, we thought of the HashMap method where we thought about creating a hash table with a word tuple as a key and their distance as value, but we did not implement it as its time and space complexities are too high. Then, we implemented the Word Tree method, where we created a BK-Tree from the given dictionary where each edge's weight is the distance between the words in the nodes in terms of number of operations. Then, we added memoization to this method, and this is our final algorithm.

Test Cases: <br>

1- input: olivery <br>
output: <br>
livery <br>
olivary <br>
oliver <br>
slivery <br>
plovery <br>

2- input: oliver <br>
output: oliver<br>







