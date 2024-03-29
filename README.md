# Sparse Matrices
In numerical analysis, we often encounter large sparse matrices, where almost all of the elements are 0 or some default value. This behavior is especially common in machine learning applications, and finding an efficient way to represent this data struture in memory is very important. Here is a simple (but small-scale) example of this behavior:

<img src="https://github.com/gurkamalpsc/sparse-matrices/blob/master/readme-images/sparse_matrix_example.png" alt="Sparse Matrix Example" width="50%"></img>
## Real World Applications
#### Representing Sparse Images
Sometimes artwork or even scientific photography can be respresented as a sparse matrix. If most of the pixels in the image are black or some default color, the image's data can be compressed into a sparse-matrix so that redundant data is not stored.

<img src="https://github.com/gurkamalpsc/sparse-matrices/blob/master/readme-images/sparse_matrix_images.jpg" alt="Sparse Matrix Images" width="50%"></img>
#### Natural Language Processing (NLP)
This is a very important field in modern day computer science, as it enables technologies such as Siri, Google Home, and even apps like Grammarly. Often, NLP aims to transform text to a structured format which eventually is represented in an organized sparse matrix. The memory efficient sparsity allows speech and text to be processed and analyzed faster, and this allows great user experiences with NLP-based platforms.

<img src="https://github.com/gurkamalpsc/sparse-matrices/blob/master/readme-images/smart_home_devices.jpg" alt="NLP" width="50%"></img>
## Projects in this Repository
This repository contains 2 versions of an abstract data class called SparseMat used to store sparse matrices:
* [Sparse Matrix](https://github.com/gurkamalpsc/sparse-matrices/blob/master/sparse-matrix/src/main/java/sparse_matrix/SparseMat.java)
* [Sparse Matrix Cloneable](https://github.com/gurkamalpsc/sparse-matrices/blob/master/sparse-matrix-cloneable/src/main/java/sparse_matrix_cloneable/SparseMat.java)
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
