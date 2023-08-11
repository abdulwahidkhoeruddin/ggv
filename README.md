# GGV - API Pembelian Tiket Bioskop

Aplikasi GGV ini dibuat menggunakan Java Spring Boot. aplikasi ini menerapkan :

- Spring Ioc
- Java Stream
- Native SQL Query
- Restful API

Aplication Properties

Konfigurasi aplikasi berisi setting ke database, config jpa dll

```java
spring.datasource.username={username-datasource}
spring.datasource.password={password-datasource}
spring.datasource.url=jdbc:postgresql://localhost:5432/ggv_db
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.error.include-stacktrace=never
```

Berikut beberapa Endpoint yang tersedia

- POST `/api/v1/film` : Menambahkan data master film

Request Body

```json
{
  "nama": "Hercules",
  "genre": "Fantasy",
  "durasi": "01:51:00",
  "studio": {
    "id": "edac3bf1-c8e8-4d81-b733-c071c1fd4fa1",
    "nama": "Studio A",
    "tanggalTayang": "2020-03-02"
  }
}
```

- POST `/api/v1/studio` : Menambahkan data master studio

Request Body

```json
{
  "nama": "Studio B",
  "tanggalTayang": "2020-04-02"
}
```

- POST `/api/v1/order` : Menambahkan pembelian

Request Body

```json
{
  "filmId": "1f5d76cd-ad44-44af-b0af-cfac89c9fdea",
  "jumlahTiket": 3
}
```

- GET `/api/v1/order/22a66ad2-8943-4461-a578-e9b5498bb9f5` : Mrlihat pembelian berdasarkan id

Response

```json
{
    "statusCode": 200,
    "message": "Successfully get by id",
    "data": {
        "kodeOrder": "22a66ad2-8943-4461-a578-e9b5498bb9f5",
        "namaStudio": "Studio A",
        "namaFilm": "Sonic",
        "jamTayang": "2020-03-02",
        "jumlahTiket": 2,
        "hargaBayar": 45000,
        "biayaLayanan": 2000,
        "totalBayar": 92000
    }
}
```

- GET `/api/v1/order` : Melihat semua pembelian

Response

```json
{
    "statusCode": 200,
    "message": "Successfully get all",
    "data": [
        {
            "kodeOrder": "22a66ad2-8943-4461-a578-e9b5498bb9f5",
            "namaStudio": "Studio A",
            "namaFilm": "Sonic",
            "jamTayang": "2020-03-02",
            "jumlahTiket": 2,
            "hargaBayar": 45000,
            "biayaLayanan": 2000,
            "totalBayar": 92000
        },
        {
            "kodeOrder": "6603f6fd-548e-409f-82ef-0e11c4233697",
            "namaStudio": "Studio A",
            "namaFilm": "Hercules",
            "jamTayang": "2020-03-02",
            "jumlahTiket": 3,
            "hargaBayar": 45000,
            "biayaLayanan": 2000,
            "totalBayar": 137000
        }
    ]
}
```
