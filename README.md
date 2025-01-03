# Spring Boot 2 升級 3

- 這是簡易 Spring Boot 2 升級 Spring boot 3 的範例  
- 可以參考 Spring Boot 官方的[升級文件](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Migration-Guide)
- 需要連結 Redis (Ports:6379)

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

## 改動的步驟

加入  OpenRewrite
```xml
<project>
    <build>
        <plugins>
            <!-- Spring Boot Maven Plugin -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

            <!-- OpenRewrite Plugin -->
            <plugin>
                <groupId>org.openrewrite.maven</groupId>
                <artifactId>rewrite-maven-plugin</artifactId>
                <version>5.25.0</version>
                <configuration>
                    <activeRecipes>
                        <recipe>org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0</recipe>
                    </activeRecipes>
                </configuration>
                <dependencies>
                    <dependency>
                        <groupId>org.openrewrite.recipe</groupId>
                        <artifactId>rewrite-spring</artifactId>
                        <version>5.5.0</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>
</project>
```

```bash
執行 mvn rewrite:run
```

## 執行後效果舉例

### FeignClient 變化
```diff
// 定義 Feign 客戶端，baseUrl
@FeignClient(name = "postsClient", url = "${feign.client.url}")
public interface PostsClient {

- @RequestMapping(method = RequestMethod.GET, value = "/posts/{id}") 
- Post getPosts(@PathVariable("id") Long id); 
+ @GetMapping("/posts/{id}") 
+ Post getPosts(@PathVariable Long id); 

}
```

### javax -> jakarta
```diff
- import javax.persistence.*;
+ import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
```

### 單元測試改動
```diff
- @RunWith(SpringRunner.class)
+ @SpringBootTest
class EmployeeServiceTest {
}
```



