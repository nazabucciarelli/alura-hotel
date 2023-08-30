# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center">Esta aplicación de escritorio fue creado bajo el supuesto de que una empresa necesitaba gestionar sus reservas y clientes de un hotel. La interfaz gráfica estaba pre-hecha, soplo tuve que utilizarla y dedicarme a la lógica y conexión con base de datos MySQL para que el sistema sea funcional. Sirvió mucho este challenge para entender más a fondo la arquitectura MVC. </p>

<p align="center" >
     <img width="300" heigth="300" src="https://user-images.githubusercontent.com/91544872/189419040-c093db78-c970-4960-8aca-ffcc11f7ffaf.png">
</p>

</br>

## 🖥️ Tecnologías Utilizadas:

- Java
- IntelliJ
- Biblioteca JCalendar
- MySQL
- Swing
---
## ⚠️ Importante! ⚠️

☕ Use Java versión 8 o superior para compatibilidad. </br></br>
📝 Recomiendo usar el editor de IntelliJ para compatibilidad con la Interfaz Gráfica. </br></br>
---

## Levantando el proyecto

1 - Efectuar fork al repositorio.

2 - Clonar una instancia local del mismo usando Git mediante el comando:

```
git clone https://github.com/nazabucciarelli/alura-hotel.git
```
3 - Abrir proyecto usando IntelliJ como IDE. En caso de usar Eclipse u otro, importarlo con su configuración requerida para el reconocimiento de los módulos.

4- Crear una base de datos llamada "alura_hotel" en localhost, con las tablas users (con campos id <int auto_increment>, username <varchar(50)> y password<varchar(50)>), customer (con campos id <int auto_increment>, name <varchar(50)>, lastname <varchar(50)>, birthdate <Date>,nationality <varchar(50)>, phoneNumber, <varchar(50)>,booking_id <int con foreign key en tabla booking>) y por último será necesaria la tabla booking (con campos id <int auto_increment>,checkin_date <Date>,checkout_date<Date>,value,pay_method <varchar(50)> y user_id <int con foreign key en tabla user>)

4 - Ejecutar la clase Main, agregar registros y efectuar operaciones.

## Author

- [@Nazareno Bucciarelli](https://github.com/nazabucciarelli)
