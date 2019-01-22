package edu.aem.training.upsidedown;

/**
 * A simple service interface
 */
public interface UpsideDowntService {
    
    /**
     * @return the name of the underlying JCR repository implementation
     */
    String getRepositoryName();
}