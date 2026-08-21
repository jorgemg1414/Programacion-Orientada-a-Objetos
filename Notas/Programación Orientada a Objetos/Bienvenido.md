`# Markdown - Chuleta`

`Referencia rápida de sintaxis para Obsidian.`

`En cada bloque de abajo viene primero **la sintaxis** y luego **cómo se ve**.`

`---`

`## Títulos`

` ```` `

`# Título 1`

`## Título 2`

`### Título 3`

`#### Título 4`

` ```` `

`Se ve así:`

`# Título 1`

`## Título 2`

`### Título 3`

`#### Título 4`

``> Ojo: siempre va un espacio después del `#`. Si escribes `#Título` sin espacio, Obsidian lo toma como etiqueta.``

`---`

`## Formato de texto`

`| Sintaxis | Resultado |`

`| --- | --- |`

``| `**negritas**` | **negritas** |``

``| `*cursiva*` | *cursiva* |``

``| `***negrita y cursiva***` | ***negrita y cursiva*** |``

``| `~~tachado~~` | ~~tachado~~ |``

``| `==resaltado==` | ==resaltado== |``

```| `` `código en línea` `` | `código en línea` |```

`---`

`## Listas`

` ```` `

`- viñeta`

`- otra viñeta`

`- sub-viñeta (con Tab)`

` ```` `

`- viñeta`

`- otra viñeta`

`- sub-viñeta (con Tab)`

` ```` `

`1. lista numerada`

`2. segundo`

` ```` `

`1. lista numerada`

`2. segundo`

`---`

`## Tareas`

` ```` `

`- [ ] tarea pendiente`

`- [x] tarea hecha`

` ```` `

`- [ ] tarea pendiente`

`- [x] tarea hecha`

`---`

`## Citas y separadores`

` ```` `

`> Cita o nota resaltada`

`---`

` ```` `

`> Cita o nota resaltada`

`---`

`## Enlaces`

` ```` `

`[texto del link](https://ejemplo.com)`

`[[Otra nota]]`

`[[Otra nota|texto que se muestra]]`

`![[imagen.png]]`

` ```` `

``- `[[ ]]` enlaza a otra nota de tu bóveda``

``- `![[ ]]` incrusta la nota o imagen dentro de esta``

`---`

`## Tablas`

` ```` `

`| Sucursal | Equipo | Estado |`

`| -------- | --------- | ------ |`

`| Jardines | DVR | OK |`

`| Mapelo | Impresora | Falla |`

` ```` `

`| Sucursal | Equipo | Estado |`

`| -------- | --------- | ------ |`

`| Jardines | DVR | OK |`

`| Mapelo | Impresora | Falla |`

`---`

`## Bloques de código`

`Se abren y cierran con tres acentos graves y el nombre del lenguaje:`

` ```` `

` ```sql `

`SELECT * FROM ventas WHERE fecha = GETDATE()`

` ``` `

` ```` `

` ````sql `

`SELECT * FROM ventas WHERE fecha = GETDATE()`

` ```` `

`---`

`## Callouts (avisos de Obsidian)`

` ```` `

`> [!note] Nota`

`> Contenido del aviso.`

`> [!warning] Cuidado`

`> Algo importante.`

`> [!tip] Tip`

`> Un consejo.`

` ```` `

`> [!note] Nota`

`> Contenido del aviso.`

`> [!warning] Cuidado`

`> Algo importante.`

`> [!tip] Tip`

`> Un consejo.`

`---`

`## Atajos en Mac`

`| Atajo | Acción |`

`| --- | --- |`

``| `Cmd + B` | Negritas |``

``| `Cmd + I` | Cursiva |``

``| `Cmd + K` | Insertar enlace |``

``| `Cmd + E` | Cambiar entre edición y lectura |``

``| `Cmd + P` | Paleta de comandos |``

``| `Cmd + O` | Abrir nota rápido |``

``| `Cmd + N` | Nota nueva |``

``| `Tab` / `Shift + Tab` | Indentar / desindentar viñeta |``