# Delivery Slot Challenge

## Requisitos

- Open JDK 17 o superior.
- Maven 3.6+ (opcional si usa el wrapper incluido). 
- Variables de entorno: `JAVA_HOME` apuntando al JDK instalado.

## Cómo compilar y ejecutar

En sistemas Unix/macOS:

```bash
./mvnw clean package
./mvnw spring-boot:run
```

En Windows (CMD):
```bash
mvnw.cmd clean package
mvnw.cmd spring-boot:run
```

## Archivos de configuración

- `src/main/resources/data.sql` — datos iniciales para la base de datos H2 embebida. Para efectos de POC, solamente se incluyeron 2 zonas geográficas, bloques horarios desde las 09:00 hasta las 18:00 distribuidos en 7 días a partir del día en el cuál se levante el proyecto.

No obstante, se puede modificar este archivo sql para incluir más zonas geográficas, disminuir/aumentar bloques horarios y también dejar más días disponibles a gusto de la persona que este a cargo de examinar el repositorio, solo se deben ajustar los valores de inserción en este script en caso de que se desee.

## Verificar Base de datos 

- Si desea ingresar a la GUI de la base de datos H2 para poder evidenciar la consistencia de los datos, puede hacerlo sin problemas dirigiéndose a la siguiente url  : `http://localhost:8080/h2-console` (mientras el proyecto se encuentre en ejecución). 

-Una vez dentro, debe seleccionar las siguientes opciones : 
```bash
Saved Settings : Generic H2 (Embedded)
Setting Name  :  Generic H2 (Embedded)
Driver Class : org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password : (vacío)
```

-Al ingresar, podrá ver las 4 tablas creadas para este desafío (delivery_order, delivery_slots,geographic_zones y windows), donde podrá ejecutar las querys deseadas para efectos de verificar consistencia de datos. 

## Endpoints expuestos

La API expone tres endpoints REST.

- **Listar zonas geográficas**

  - Método: `GET`
  - Ruta: `/geographic-zones`
  - Descripción: Devuelve la lista de zonas geográficas disponibles almacenadas en base de datos.
  - Ejemplo (curl):

    ```bash
    curl -X GET http://localhost:8080/geographic-zones
    ```
  - Ejemplo de respuesta : 
```json
    [{
      "id": "1",
      "township": "Santiago",
      "area": "Región Metropolitana"
    },
    { 
      "id": "2",
      "township": "Valdivia",
      "area": "Región de los ríos"
    }]
```

- **Obtener franjas horarias de entrega (delivery slots) por zona y rango de fechas**

  - Método: `GET`
  - Ruta: `/delivery-slots/geographic-zone/{geographicZoneId}`
  - Query Params obligatorios: `dateFrom`, `dateTo`
  - Descripción: Devuelve un mapa donde la clave es la fecha y el valor es la lista de franjas de entrega disponibles para la zona geográfica indicada entre las fechas proporcionadas.
  - Formato de fecha IMPORTANTE: los parámetros `dateFrom` y `dateTo` deben estar en formato ISO 8601 `YYYY-MM-DD` (por ejemplo: `2026-02-08`).
  - Ejemplo (curl):

    ```bash
    curl -G "http://localhost:8080/delivery-slots/geographic-zone/1" \
      --data-urlencode "dateFrom=2026-02-08" \
      --data-urlencode "dateTo=2026-02-10"
    ```

  - Ejemplo de respuesta : 
```json
      {
        "2026-02-09": [
          {
            "id": 11,
            "start": "09:00:00",
            "end": "11:00:00",
            "availability": 5,
            "price": 4500
          },
          {
            "id": 12,
            "start": "10:00:00",
            "end": "12:00:00",
            "availability": 10,
            "price": 4500
          },
          {
            "id": 13,
            "start": "11:00:00",
            "end": "13:00:00",
            "availability": 10,
            "price": 4500
          }],
          "2026-02-10": [
          {
            "id": 45,
            "start": "09:00:00",
            "end": "11:00:00",
            "availability": 30,
            "price": 4500
          },
          {
            "id": 46,
            "start": "10:00:00",
            "end": "12:00:00",
            "availability": 10,
            "price": 4500
          }]

      }
```
- **Crear pedido de entrega (place delivery order)**

  - Método: `POST`
  - Ruta: `/delivery-order`
  - Cuerpo: JSON con la estructura de `DeliveryOrderDto` (ver paquete `domain.model.dto`).
  - Respuesta: devuelve el id de la orden, en formato UUID y código HTTP `201 Created` si el pedido se procesa correctamente.
  - Ejemplo (curl):

    ```bash
    curl -X POST http://localhost:8080/delivery-order \
      -H "Content-Type: application/json" \
      -d '{ "clientName": "Luis García", "clientAddress": "Villa Los Patitos", "deliverySlotId": 11 }'
    ```

      - Ejemplo de respuesta : 
```json
      {
        "orderId" : "574ccb86-2335-46da-9fe1-cc3266c1af74"
      }
```

## Potenciales Errores
- En caso de que el proyecto no compile, asegúrese de que `JAVA_HOME` apunte al JDK y que la versión de Java sea compatible.
- Si obtiene errores al parsear fechas en el endpoint de `delivery-slots`, revise que los parámetros `dateFrom` y `dateTo` tengan el formato `YYYY-MM-DD`.

## Collections 

- Se incorporaron 2 archivos `delivery.json` para facilitar el consumo de la API.  (Bruno y Postman). 

