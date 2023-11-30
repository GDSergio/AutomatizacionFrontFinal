Arquetipo Serenity BDD POM
Consideraciones
- La conexion con la Base de Datos que esta ya configurada se hace con una DB MySQL online gratuita de db4free.net
  (https://www.db4free.net/signup.php), las credenciales estan en el archivo de configuracion expuesto en el proximo punto.

- Para ejecutar la funcionalidad de prueba que implementa la utilidad de Base de Datos con una BD diferente a la configurada
  es importante que se instacie una Base de datos y se configure en el archivo de configuración la url de conexion, usuario
  y contraseña, ubicado en:

  ./src/main/resources/configs/congig.properties

  En las dependencias del proyecto esta agregada la dependencia del driver de MySQL, si no
  desea realizar mayores ajustes respecto al motor de BD use MySQL. Si desea usar otro motor,
  adiciones la dependencia del driver al build.gradle y configure este driver como observa
  se realizo para MySQL en:

        ./src/main/java/utils/data/ConnectionManagerDB.java

  Si no desea realizar mayores ajustes al ejemplo puesto en el .feature nombre a la base de
  datos "pruebas_pragma" y dentro de ella cree una tabla con el nombre "search_values".
  Dicha tabla debe tener dos columnas, la primera debe llamarse "id" y la segundo "value"

  Puedes insertar los datos con la siguiete Query:

        INSERT INTO `search_values` (`id`, `value`) VALUES ('1', 'Automation Step by Step'), ('2', 'Prueba 2');



- La funcionalidad de prueba que implementa la utilidad de manejo de documentos de Google Sheet hace uso
  de un documento de Google Sheet ubicado en el drive de Pragma, por ende las credenciasles que se encuentran
  en:
  ./src/main/resources/credenciales.json
  fueron generadas por un API de google creado bajo una cuenta de Pragma.

Dadas las consideraciones anteriores, la implementacion de las utilidades solo se encuentran expuestas a modo
de ejemplo y unicamente funcionaran si se hacen las configuraciones pertinentes.
Name
Proyecto base de Serenity BDD con Page Object Model (POM)

Description
This project aims to establish a standard base for test automation with Srenity BDD and POM

✅ Technologies
This project required:
[JDK java] version 1.8
[Maven] version
[Serenity] version
[Cucumbre] version
[JUnit] version
Project status
🚧 Proyecto en construcción 🚧
Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

📁 Access to project
Create or upload files
Add files using the command line or push an existing Git repository with the following command:
cd existing_repo
git remote add origin https://gitlab.com/calidad_de_software/.../.git
git branch -M develop
git push -uf origin develop
** 🛠️ Run after tests to generate report**
mvn serenity:aggregate
Collaborate with your team
Invite team members and collaborators
Create a new merge request
Automatically close issues from merge requests
Enable merge request approvals
Automatically merge when pipeline succeeds
Test and Deploy
Use the built-in continuous integration in GitLab.

Get started with GitLab CI/CD
Analyze your code for known vulnerabilities with Static Application Security Testing(SAST)
Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy
Use pull-based deployments for improved Kubernetes management
Set up protected environments
Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.


License
Open source project.