# Spring Boot 2 升級 3

- 這是簡易 Spring Boot 2 升級 Spring boot 3 的範例  
- 可以參考 Spring Boot 官方的[升級文件](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Migration-Guide)

## Spring Boot 2

| Java | Spring Boot | Branch |
|---|---|---|
|  11 |  2.7.12  | main |

## Spring Boot 3

| Java | Spring Boot | Branch | 
|---|---|---|
|  17 |  3.0.13  | feature/SpringBoot2To3 |

- 使用 OpenRewrite 套件[Migrate to Spring Boot 3.0](https://docs.openrewrite.org/recipes/java/spring/boot3/upgradespringboot_3_0)
- 執行 mvn rewrite:run

