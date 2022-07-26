 
# iLOG - Clawtech
 
iLOG es un proyecto académico creado para la gestión logística de pequeñas y medianas empresas. Es parte del proyecto de fin de curso de la carrera Licenciatura en Tecnologías de la Información de UTEC
 
El mismo está dividido en cuatro repositorio dentro de github:
 
* [Backend Desarrollado en Spring Boot](https://github.com/tomasferok/ProyectoLogistica)
* [Front End Desarrollado en React](https://github.com/ClawTech-UTEC/react-frontend)
* [Aplicacion Movil desarrolada en Flutter](https://github.com/ClawTech-UTEC/LogisticaMobileApp)
* [Modelo Machine Learning para facturacion](https://github.com/ClawTech-UTEC/ModeloMl-Facturacion.ipynb)
## Authors
 
- [@TomasFernandez](https://www.github.com/octokatherine)
- [@GuillermoRodriguez](https://github.com/guillermo-rodriguez-dev)
- [@AndresGutierrez](https://github.com/andresgutitor)
 
 
 
 
## Deployment
 
Tanto el backend como el front end están desarrollados para correr en la nube de google cloud, usando el servicio app engine, con sql cloud como base de datos, y cloud storage como servicio de almacenamiento. Ambos contienen archivos Jenkinsfile con pipelines instructivos para su despliegue mediante la herramienta Jenkins.
 
### Backend - Spring Boot
 
Para desplegar el backend en app engine deberás modificar el archivo aplication-gcp.properties con los datos de tu base de datos
 
En caso de querer desplegar manualmente deberás correr el siguiente comando
 
 
```bash
  mvn -DskipTests package appengine:deploy -P gcp
```
 
Para su despligue local deberas modificar el archivo aplication-dev.properties con los datos de tu base de datos, instalar google cloud sdk en la computadora, autenticarte en la misma, y luego correr el siguiente comando:
 
```bash
  mvn spring-boot:run
```
 
### Frontend - React
 
Para desplegar el frontend en app engine manualmente debes modificar el archivo constants con la dirección de tu api de backend y luego correr el siguiente comando:
 
```bash
  gcloud app deploy
```
 
Para su despliegue local deberás modificar el archivo constants con la dirección de tu backend y luego correr el siguiente comando:
 
```bash
  npm run start
```
 
 
### Mobile - Flutter
 
La aplicación móvil usa el api de google maps por lo que deberás crear un archivo .env con dicha variable siguiendo las instrucciones del archivo .env.example dentro de la carpeta lib, y luego agregar tu api en los archivos android manifest e info.pilis.
 
Para crear el archivo apk de android deberás correr el siguiente comando
 
```bash
  flutter build apk
```
 
Para crear la versión IOS deberás usar la herramienta xcode
## Features
 
- Gestión y visualización de stock
- Proceso de pedidos
- Proceso de recepciones
- Ruta de última milla
- Etiquetas con códigos de barra
- Creación de remitos
- Reportes
 
 
## License
 
[MIT](https://choosealicense.com/licenses/mit/)
 
 
![Logo](https://storage.googleapis.com/clawtechpics/logo.png)
 
 
## Roadmap
Los futuros pasos para continuar el desarrollo del sistema incluyen:
- Mejorar la gestión de permisos dentro de la aplicación
 
- Integración con otros sistemas como ODOO
 
 

