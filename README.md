# music-library
Music  Library  will  be  a  Web  Application  wherein  a  person   can   access  songs  add  new  songs,  create  a  playlist, view  all  songs,  albums,  singers,  etc. 
The   Music  Library  consists of 5 entities:  Songs,  Singer,  Albums,  Playlist,  Listener.  
Each entity has an EJB Service Layer Defined for it for adding values in database and Controllers for fetching those values and passing them to the specific JSF pages. 

Requirements :
The project requires some some installations to be made for it to work. The technical requirements are as below :

 JDK 11 or above
Apache Netbeans 11.2 (Latest Version)
Payara Server 5.194 (Latest Version)
 MySQL Database Installer, Workbench and shell 8.0.19 (Latest Version)
Below in depth are the steps for installation of the above requirements and database setup (Referred from the Installation and Setup Documents provided by Professor)

Download Open JDK 11 and install it.
Download Netbeans latest version and install it with default values.
Download and latest version of Payara server and add Payara to Netbeans Server.
Next Download latest version of MySQL Community Server and using custom installation add the following
MySQL Server, MySQL Workbench, MySQL Shell, MySQL Notifier
Next Open the installed MySQL Workbench and create a local user and root (remember the pass word for this root.)
I have used PORT 8000 for my database.
Next Create a database with access rights to all contents of database 
Next create a  user and password for the user
Go to the Users and privileges page and using the add property button select all and click apply
Next go to Netbeans and create a connection from Netbeans to MySQL.
Go to the services tab in Netbeans and choose "New Connection"
Select the MySQL JDBC driver (if you don not have this install a JDBC driver) add the database user created in MySQL along with its password.
Download the project as zip file and unzip the project and save it in a folder.
Go to netbeans and select open project from the menu bar at top, next go to the folder where the unzipped folder is and select the folder and click open .
Lastly once the project is opened in Netbeans click the green button, run the project.

