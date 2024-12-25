# Указываем базовый образ с поддержкой Java
FROM maven:3.9.5-eclipse-temurin-17 AS builder

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файлы проекта в контейнер
COPY pom.xml .
COPY src ./src

# Собираем проект в архив .jar
RUN mvn clean package -DskipTests

# Используем легковесный JRE-образ для запуска
FROM eclipse-temurin:17-jre

# Указываем рабочую директорию для приложения
WORKDIR /app

# Копируем собранный jar из предыдущего этапа
COPY --from=builder /app/target/*.jar app.jar

# Указываем команду запуска
ENTRYPOINT ["java", "-jar", "app.jar"]
