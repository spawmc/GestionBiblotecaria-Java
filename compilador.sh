#!/bin/bash
javac ejemplares/Area.java ejemplares/Autor.java ejemplares/Ejemplar.java ejemplares/IPrestamo.java ejemplares/Libro.java
ejemplares/SinDeudaException.java ejemplares/Tesis.java | echo compilando ejemplares
javac files/AñadirContenido.java files/ArchivoBinario.java files/IRead.java files/ISave.java | echo compilando files
javac usuarios/*.java | echo compilando usuarios
javac util/Administrador.java util/Gerente.java util/GestorDeEjemplares.java util/Inicializador.java util/Mensajero.java util/UtilJList.java | echo
compilando utilidades
javac grafics/login/Login.java grafics/principal/jframesUtilities/devoluciones/RegresarLibro.java
grafics/principal/jframesUtilities/devoluciones/RegresarTesis.java grafics/principal/jframesUtilities/prestamos/PrestarLibro.java
grafics/principal/jframesUtilities/prestamos/PrestarTesis.java grafics/principal/jframesUtilities/registroEstudiante/RegistroE.java
grafics/principal/jframesUtilities/registroEstudiante/RegistroE.java grafics/principal/jframesUtilities/registroProfesor/RegistroP.java
grafics/principal/jframesUtilities/JFAddLibro.java grafics/principal/jframesUtilities/JFAddTesis.java
grafics/principal/jframesUtilities/JFAddUser.java | echo compilando graficas
echo compilación finalizada
