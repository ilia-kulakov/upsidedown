package edu.aem.training.upsidedown.impl;

import edu.aem.training.upsidedown.UpsideDowntService;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;

import javax.jcr.Repository;
import java.util.Dictionary;

/**
 * One implementation of the {@link UpsideDowntService}. Note that
 * the repository is injected, not retrieved.
 */
@Service(UpsideDowntService.class)
@Component(immediate=true, metatype = true)
public class UpsideDowntServiceImpl implements UpsideDowntService {

    @Reference
    private SlingRepository repository;

    public String getRepositoryName() {
        return repository.getDescriptor(Repository.REP_NAME_DESC);
    }

}
