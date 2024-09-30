package com.mohamed.persistence;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class CustomPersistenceUnit implements PersistenceUnitInfo {
    private final String persistenceName;

    public CustomPersistenceUnit(String persistenceName) {
        this.persistenceName = persistenceName;
    }

    @Override
    public String getPersistenceUnitName() {
        return this.persistenceName;
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        // For H2 Database, use the following JDBC URL
        dataSource.setJdbcUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");

        // No username or password required for in-memory H2 database
        dataSource.setUsername("sa");  // "sa" is the default user for H2
        dataSource.setPassword("");    // Password is empty by default
        return dataSource;
    }

    @Override
    public List<String> getManagedClassNames() {
        return List.of(
                "com.mohamed.singletable.entities.Vehicle",
                "com.mohamed.singletable.entities.Motorbike",
                "com.mohamed.singletable.entities.Car",
                "com.mohamed.joined.entities.Employee",
                "com.mohamed.joined.entities.Manager",
                "com.mohamed.joined.entities.Engineer");
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return List.of();
    }

    @Override
    public List<URL> getJarFileUrls() {
        return List.of();
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }


    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return "";
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer classTransformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
