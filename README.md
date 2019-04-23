# Sparse Matrices
In numerical analysis, we often come encounter large sparse matrices, where almost all of the elements are 0 or some default value. This behavior is especially common in machine learning applications such as natural language processing, and finding an efficient way to represent this data struture in memory is important. The 10 x 10 Identity matrix is a good simple example of this behavior:<br />
```
1  0  0  0  0  0  0  0  0  0
0  1  0  0  0  0  0  0  0  0
0  0  1  0  0  0  0  0  0  0
0  0  0  1  0  0  0  0  0  0
0  0  0  0  1  0  0  0  0  0
0  0  0  0  0  1  0  0  0  0
0  0  0  0  0  0  1  0  0  0
0  0  0  0  0  0  0  1  0  0
0  0  0  0  0  0  0  0  1  0
0  0  0  0  0  0  0  0  0  1
```
## Real World Applications
#### Application 1
Placeholder Text
#### Application 2
Placeholder Text
## Projects in this Repository
This repository contains 2 versions of the subset sum problem:
* [Sparse Matrix](#)<br />Placeholder Text
* [Sparse Matrix Cloneable](#)<br />Placeholder Text
## Prerequesites
Gradle 5.4 requires [Java 8](https://www.oracle.com/technetwork/java/javaee/downloads/jdk8-downloads-2133151.html) or later to run.
* Mac<br />```$ brew cask install java8```
* Linux<br />```$ sudo apt install oracle-java8-installer```
* Windows<br />```C:\> choco install jdk8```
## Usage
Running both projects:
```
$ git clone https://github.com/gurkamalpsc/sparse-matrices.git && cd sparse-matrices && ./gradlew run
```
## Built With
* [IntelliJ Idea CE](https://www.jetbrains.com/idea/) - Java & Kotlin IDE
* [Gradle 5.4](https://gradle.org/) - Build Tool & Monorepo Management
## License
This project is licensed under the MIT License
