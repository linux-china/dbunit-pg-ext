DBUnit PostgreSQL Extension
=============================

dbunit-pg-ext is an extension for DBUnit to add more features for PostgreSQL.

Data types of `PostgresqlDataTypeFactory`:

- `uuid`
- `interval`
- `inet`
- `geometry`
- `citext`

Data types of `PostgresqlExtraDataTypeFactory`:

- `json` and `jsonb`
- `XML`
- `vector`: https://github.com/pgvector/pgvector
- `money`
- `_text`: array of text

Extra classes:

- `PostgresqlExtraDataTypeFactory`: extend `PostgresqlDataTypeFactory` and more data types for PostgreSQL
- `PgConnection`: DBUnit `IDatabaseConnection` with `PostgresqlExtraDataTypeFactory`

# Get Started

Add dependency in pom.xml:

```xml

<dependency>
    <groupId>org.mvnsearch</groupId>
    <artifactId>dbunit-pg-ext</artifactId>
    <version>0.1.2</version>
</dependency>
````

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
            <version>42.7.5</version>
        </dependency>
        <dependency>
            <groupId>org.mvnsearch</groupId>
            <artifactId>dbunit-pg-ext</artifactId>
            <version>0.1.2</version>
        </dependency>
    </dependencies>
    <configuration>
        <dbconfig>
            <datatypeFactory>org.mvnsearch.dbunit.ext.postgresql.PostgresqlExtraDataTypeFactory</datatypeFactory>
        </dbconfig>
    </configuration>
</plugin>

```

# References

* PostgreSQL Data Types: https://www.postgresql.org/docs/current/datatype.html
* DBUnit: https://www.dbunit.org/howto.html
* DbUnit and JSON column type support: https://stackoverflow.com/questions/52845001/dbunit-and-json-column-type-support
