#FROM amazoncorretto:17 as builder
#WORKDIR workspace
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} catalog-service.jar
#RUN java -Djarmode=layertools -jar catalog-service.jar extract
#
#FROM amazoncorretto:17
#WORKDIR workspace
#COPY --from=builder workspace/dependencies/ ./
#COPY --from=builder workspace/spring-boot-loader/ ./
#COPY --from=builder workspace/snapshot-dependencies/ ./
#COPY --from=builder workspace/application/ ./
#ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]