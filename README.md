DBUnit PostgreSQL Extension
=============================

`PostgresqlExtraDataTypeFactory` is to extend `PostgresqlDataTypeFactory` to support following data types:

- `json`
- `jsonb`
- `vector`

# Get Started

Add dependency

```xml

<dependency>
    <groupId>org.mvnsearch</groupId>
    <artifactId>dbunit-pg-ext</artifactId>
    <version>0.1.0-SNAPSHOT</version>
</dependency>
````

Then you can use `PostgresqlExtraDataTypeFactory` as data type factory.

# dbunit-maven-plugin configuration

```xml

<plugin>
    <groupId>org.dbunit</groupId>
    <artifactId>dbunit-maven-plugin</artifactId>
    <version>1.2.0</version>
    <dependencies>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>${postgresql.version}</version>
        </dependency>
        <dependency>
            <groupId>org.mvnsearch</groupId>
            <artifactId>dbunit-pg-ext</artifactId>
            <version>0.1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
    <configuration>
        <dbconfig>
            <datatypeFactory>org.mvnsearch.dbunit.ext.postgresql.PostgresqlExtraDataTypeFactory</datatypeFactory
        </dbconfig>
    </configuration>
</plugin>

```

