# Web Microservices com Spark

Spark pode ser o framework para sua plataforma que você precisa para construir aplicações web que executam na JVM.

Ele contém um servidor web embutido, Jetty, que facilita o inicio do desenvolvimento em minutos.

O projeto contempla uma simples microserviço web.

## Requisitos

JDK 11, podendo codificar em Java 8.

## Execução

A classe WebMicroServicesApplication inicializa o serviço, normalmente na porta 4567.

Segue os endpoints e métodos utilizados:

| Método      | Endpoint |
| ----------- | ----------- |
| GET | /hello/simple |
| GET | /hello/html/:name |
| GET |/hello/simple/:name |
| POST | /hello/complex |
| POST | /hello/name |

### Exemplo de execução de objeto complexo (JSON)
**Endpoint**: *localhost:4567/hello/complex*

**Content-Type:** *application/json*

```json
{
    "name": "Teste"
}
```

Resultado:
```json
{
    "text": "Hello, Teste",
    "generated": 1625146741953
}
```