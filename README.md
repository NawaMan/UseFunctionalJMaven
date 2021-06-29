# UseNullableJMaven

![alt "Build status"](https://github.com/NawaMan/UseFunctionalJMaven/actions/workflows/maven.yml/badge.svg)

Example of how to use [FunctionalJ](https://github.com/NawaMan/FunctionalJ) in a Maven project.

It basically boils down to adding the required maven repository (hosted by github).

```xml
<repository>
  <id>Functional-mvn-repo</id>
  <url>https://raw.githubusercontent.com/nawaman/nawaman-maven-repository/master/</url>
  <snapshots>
    <enabled>true</enabled>
    <updatePolicy>always</updatePolicy>
  </snapshots>
</repository>
```

and the required dependencies ...

```xml
<dependency>
  <groupId>functionalj</groupId>
  <artifactId>functionalj-core</artifactId>
  <version>0.5.1.0</version>
</dependency>
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>4.13.2</version>
  <scope>test</scope>
</dependency>
```
See the full code here: [pom.xml](https://github.com/NawaMan/UseFunctionalJMaven/blob/master/pom.xml)

