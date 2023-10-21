# Socket-Based Transaction System

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
<!--   <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a> todo !!!-->

  <h3 align="center">socket-transaction-system</h3>

  <p align="center">
    Socket-Based Transaction System
    <br />
    <a href="https://github.com/EduardoMarcal-347/sockets-multithread/"><strong>Explore the docs »</strong></a>
  </p>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

Implementing an application with Sockets, where the server will process credit and debit card purchase requests. Messages will be exchanged using the ISO 8583 standard. There are several reasons that justify this choice:

* **Efficiency in Transaction Processing**: The use of Sockets allows direct and efficient communication between the client and the server, resulting in faster and more responsive processing of card transactions.
* **Security in Sensitive Data Transmission**: The ISO 8583 standard is internationally recognized as a secure protocol for the exchange of financial information. By adopting it, we ensure the integrity and confidentiality of payment data.
* **Scalability and Concurrency**: Sockets enable support for multiple clients simultaneously, meaning the application can handle a large volume of transactions concurrently without sacrificing performance.
* **Standardization and Interoperability**: The use of the ISO 8583 standard facilitates integration with third-party payment systems and financial institutions, promoting interoperability and compatibility with different platforms.
* **Ease of Maintenance and Updates**: With a Socket-based architecture, it is simpler to perform maintenance and updates on the application, ensuring it is always aligned with the requirements and regulations of the financial sector.
* **Enhanced User Experience**: Efficiency in communication between client and server leads to a faster and uninterrupted shopping experience, contributing to user satisfaction.
* **Adoption of DRY Principles**: By opting for a Socket-based implementation, we follow the DRY (Don't Repeat Yourself) principle, avoiding code redundancy and promoting a more efficient and organized approach in the development of the application.


<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

This project was developed using the Java programming language, leveraging its Socket and Multithreading system to facilitate communication between the server and clients, allowing simultaneous processing of multiple transactions.

[![Java][java.io]][java-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This project uses the Maven system for dependency management and compilation. Follow the steps below to run the application locally:

#### Prerequisites

- Make sure you have Maven installed on your system. If you don't, you can download and install it from the [official Maven website](https://maven.apache.org/download.cgi).

#### Installation

1. Clone the repository.:

    ```bash
    git clone git@github.com:EduardoMarcal-347/sockets-multithread.git
    ```

2. Navigate to the project directory.:

    ```bash
    cd transacoesCartao
    ```
    
#### Running the Socket Server

1. In the project directory, navigate to the class`SocketsServer.java`

2. Run the application. This will start the socket server.

#### Running the Socket Client 

1. In the project directory, navigate to the class `ClientSocket.java`

2. Run the application. This will start the socket client.

Remember to configure the necessary information, such as the desired messages if you want to customize the specific outputs of your project, as indicated in the comments of the source code.

With these steps, you will be ready to use the application locally. If you encounter any issues or have any questions, feel free to reach out.

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Eduardo Marçal - edumsfilho347@gmail.com

Project Link: [https://github.com/EduardoMarcal-347/sockets-multithread.git)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

I would like to express my gratitude to the following resources that were crucial in the development of this project:

### Java

* [Oracle's Java Documentation](https://docs.oracle.com/en/java/) - The official Java language documentation provided by Oracle. Essential for understanding syntax, API, and best practices.

* [Baeldung's Java Guides](https://www.baeldung.com/guides) - A valuable source of tutorials and practical guides on various Java topics.

* [Java Code Geeks](https://www.javacodegeeks.com/) - An active community with a wide variety of Java articles and code examples.

### Sockets in Java

* [Java™ Platform, Standard Edition 8 - java.net](https://docs.oracle.com/javase/8/docs/api/java/net/package-summary.html) - Official documentation of the java.net API, providing essential resources for network communication, including Sockets.

* [Tutorialspoint - Java Socket Programming](https://www.tutorialspoint.com/java/java_networking.htm) - A practical and straightforward guide to Socket programming in Java.

* [Baeldung's Guide to Java Sockets](https://www.baeldung.com/java-sockets) - A comprehensive tutorial covering everything from basics to advanced techniques in Socket programming.

### Multithreading in Java

* [Oracle's Concurrency in Java Guide](https://docs.oracle.com/javase/tutorial/essential/concurrency/) - Official tutorial providing a detailed introduction to concurrent programming in Java.

* [Java Concurrency in Practice](https://www.oreilly.com/library/view/java-concurrency-in/0321349601/) (Book) - Written by Brian Goetz and others, it is an essential reference for Java developers working with concurrent programming.

* [Baeldung's Guide to Java Concurrency](https://www.baeldung.com/java-concurrency) - A series of comprehensive articles covering everything from basic thread concepts to advanced concurrency techniques.

These resources were immensely valuable during the development of this project, providing knowledge and practical examples that were crucial to the implementation's success.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/EduardoMarcal-347/sockets-multithread.svg?style=for-the-badge
[contributors-url]: https://github.com/EduardoMarcal-347/sockets-multithread/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/EduardoMarcal-347/sockets-multithread.svg?style=for-the-badge
[forks-url]: https://github.com/EduardoMarcal-347/sockets-multithread/network/members
[stars-shield]: https://img.shields.io/github/stars/EduardoMarcal-347/sockets-multithread.svg?style=for-the-badge
[stars-url]: https://github.com/EduardoMarcal-347/sockets-multithread/stargazers
[issues-shield]: https://img.shields.io/github/issues/EduardoMarcal-347/sockets-multithread.svg?style=for-the-badge
[issues-url]: https://github.com/EduardoMarcal-347/sockets-multithread/issues
[license-shield]: https://img.shields.io/github/license/EduardoMarcal-347/sockets-multithread.svg?style=for-the-badge
[license-url]: https://github.com/EduardoMarcal-347/sockets-multithread/blob/main/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://br.linkedin.com/in/eduardo-marcal-de-souza-filho
[java.io]: https://img.shields.io/badge/Java-f89820?style=for-the-badge&logo=java&logoColor=61DAFB
[java-url]: [https://nextjs.org/](https://docs.oracle.com/en/java/)
