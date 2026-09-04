# Programación Orientada a Objetos — ICOM 3°

Apuntes y ejercicios del curso.

## Estructura

```
.
├── Notas/Programación Orientada a Objetos/   Vault de Obsidian
│   ├── Bienvenido.md                         Índice del vault
│   ├── Images/                               Imágenes de las notas
│   ├── Agosto/
│   │   └── Clase DD-MM-AAAA.md
│   └── Septiembre/
│       └── Clase DD-MM-AAAA.md
├── Ejercicios Java/                          Código de cada clase
│   ├── Agosto/
│   │   └── Clase 28-08-2026/
│   └── Septiembre/
│       └── Clase 04-09-2026/
└── Recursos/                                 PDFs y material de apoyo
```

## Convención

Cada clase = una carpeta con su fecha, dentro de la carpeta del mes:

```
Ejercicios Java/<Mes>/Clase DD-MM-AAAA/
```

La nota de esa misma clase vive en `Notas/Programación Orientada a Objetos/<Mes>/Clase DD-MM-AAAA.md`,
así que la fecha es la llave que une apunte y código.

Para empezar una clase nueva:

```bash
mkdir -p "Ejercicios Java/Septiembre/Clase 08-09-2026"
```

## Compilar y ejecutar

Cada carpeta de clase es autocontenida: se compila desde dentro de ella.

```bash
cd "Ejercicios Java/Septiembre/Clase 04-09-2026" && javac *.java && java Principal
```

Los `.class` no se suben al repo (están en `.gitignore`).

## Bitácora de clases

| Fecha | Nota | Ejercicios |
|---|---|---|
| 21-08-2026 | [Clase 21-08-2026](Notas/Programación%20Orientada%20a%20Objetos/Agosto/Clase%2021-08-2026.md) | — |
| 25-08-2026 | [Clase 25-08-2026](Notas/Programación%20Orientada%20a%20Objetos/Agosto/Clase%2025-08-2026.md) | — |
| 28-08-2026 | [Clase 28-08-2026](Notas/Programación%20Orientada%20a%20Objetos/Agosto/Clase%2028-08-2026.md) | `Ejemplo.java`, `Ejercicio1.java` |
| 01-09-2026 | [Clase 01-09-2026](Notas/Programación%20Orientada%20a%20Objetos/Septiembre/Clase%2001-09-2026.md) | — |
| 04-09-2026 | — | `ConsolaDeVideoJuegos.java`, `Principal.java` |
