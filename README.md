# UseNullableJMaven

![alt "Build status"](https://travis-ci.org/NawaMan/UseFunctionalJMaven.svg?branch=master)

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
	<version>0.1.59.0</version>
</dependency>
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.11</version>
	<scope>test</scope>
</dependency>
```
See the full code here: [pom.xml](https://github.com/NawaMan/UseFunctionalJMaven/blob/master/pom.xml)

