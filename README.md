# API_Concesionario 🚗 (Spring Boot + MySQL)

API REST desarrollada con **Spring Boot** para gestionar un concesionario ficticio.  
Expone endpoints que permiten realizar operaciones CRUD y devolver resultados en **formato JSON**.

## 📌 Funcionalidades
La API trabaja con una base de datos MySQL llamada `concesionario` y gestiona estas entidades:

- **Clientes**
- **Empleados**
- **Vehículos**
- **Ventas**

Cada endpoint devuelve una respuesta JSON con una estructura como:

```json
{
  "code": 1,
  "mensaje": "Mensaje descriptivo",
  "total": 10,
  "data": []
}
```

## 👥 Clientes
Base path: `/api/clientes`

| Método | Endpoint | Descripción |
|-------|----------|-------------|
| GET | `/api/clientes` | Obtener todos los clientes |
| GET | `/api/clientes/{id}` | Obtener cliente por id |
| POST | `/api/clientes` | Crear cliente |
| PUT | `/api/clientes/{id}` | Actualizar cliente |
| DELETE | `/api/clientes/{id}` | Eliminar cliente |

**Ejemplo (GET):**
```http
GET http://localhost:8080/api/clientes/1
```
```json
{
  "total": 1,
  "code": 1,
  "data": {
    "tipo": "DNI",
    "nombre": "Carlos",
    "apellidos": "García López",
    "documento": "12345678Z",
    "email": "carlos.garcia.lopez@gmail.com",
    "telefono": "+34 612 345 678",
    "direccion": "Calle Mayor 12, 3º B",
    "ciudad": "Madrid",
    "cp": "28013",
    "pais": "España",
    "fechaAlta": "2024-12-21T13:52:54.000Z",
    "id": 1
  },
  "mensaje": "Cliente encontrado"
}
```
## 📜 Licencia

Este proyecto se distribuye bajo la licencia MIT. Puedes usarlo, modificarlo y distribuirlo libremente citando la fuente.
