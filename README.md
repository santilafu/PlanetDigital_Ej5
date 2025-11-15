# 📘 Proyecto: Gestión de Empresas y Personas de Contacto – PlanetDigital

Este proyecto implementa una aplicación en Java con Hibernate para gestionar la información de empresas y sus personas de contacto.
Forma parte del ejercicio donde se solicita crear una SessionFactory, mapear clases de entidad y establecer una relación entre tablas.

## ✅ Objetivos del ejercicio

- Implementar una SessionFactory usando Hibernate.

- Crear y mapear las clases de entidad:

  - Empresa

  - PersonaContacto

- Definir la relación 1 a N:
  - Una Empresa puede tener muchas PersonasContacto.

  - Cada PersonaContacto pertenece a una sola Empresa.

- Generación automática de tablas en MySQL mediante Hibernate.

## 🧱 Estructura del Proyecto
````
src/
└── main/
├── java/
│    └── org/planetdigital/
│           ├── Empresa.java
│           ├── PersonaContacto.java
│           └── Main.java
└── resources/
└── hibernate.cfg.xml
````

## 🟦 Clases de Entidad
### 👔 1. Empresa


Representa las empresas que forman parte del sistema.

Campos:

- idempresa – clave primaria

- nombreEmpresa

- pais

- contactos 

Relación:
```` java
@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
````
**Resumen:**

- Esta entidad actúa como "padre" en la relación.
- Con el método addContacto() vinculamos automáticamente cada contacto a su empresa.

### 👤 2. PersonaContacto

Representa a las personas asociadas a cada empresa.

Campos:

- idcontacto – clave primaria

- nombre

- telefono

- empresa 

Relación:
```` java
@ManyToOne

@JoinColumn(name = "idempresa")
````
Resumen:

Entidad "hija" en la relación.
Cada contacto pertenece únicamente a una empresa.

## ⚙️ Configuración de Hibernate (hibernate.cfg.xml)

El proyecto usa MySQL y la configuración incluye:

Conexión JDBC

Usuario y contraseña

hibernate.hbm2ddl.auto=update para crear/modificar tablas automáticamente

Mapeo explícito de las clases

Hibernate genera automáticamente las tablas:

empresa

personacontacto

incluyendo la clave ajena idempresa.

## 🚀 Clase Main: Inserción de datos

En la clase Main se:

- Crea la SessionFactory

- Abre una sesión Hibernate

- Se inicia una transacción

- Se construyen los objetos Empresa y PersonaContacto

- Se vinculan usando addContacto()

- Se persisten en la BBDD con session.save(e1)

- Se cierra la sesión correctamente

Tras ejecutar el programa, los datos aparecen registrados en MySQL.

## 🗄️ Relación entre Tablas (Diagrama)
````
Empresa (1) —— (N) PersonaContacto
Tabla empresa	Tabla personacontacto
idempresa (PK)	idcontacto (PK)
nombreEmpresa	nombre
pais	telefono
—	idempresa (FK)
````
## ✔️ Comprobación en MySQL

- Tras ejecutar el proyecto, Hibernate:

- Crea las tablas automáticamente

- Actualiza columnas si es necesario

- Inserta los registros proporcionados

- Puedes verificarlo con:
````sql
SELECT * FROM empresa;
SELECT * FROM personacontacto;
````
## 🧩 Conclusión

Este ejercicio demuestra el proceso completo de:

- Crear entidades con anotaciones JPA

- Configurar Hibernate desde cero

- Establecer relaciones entre tablas

- Construir una SessionFactory funcional

- Realizar operaciones CRUD básicas mediante Hibernate

## ‍🎓AUTOR: 
- Santiago Lafuente Hernández
- 2º DAM – Acceso a Datos
- (Desarrollo del README realizado con acompañamiento técnico de ChatGPT)