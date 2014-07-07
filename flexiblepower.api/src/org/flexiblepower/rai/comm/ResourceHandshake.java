package org.flexiblepower.rai.comm;

import java.util.Date;

public abstract class ResourceHandshake extends ResourceInfo {

    private static final long serialVersionUID = 8841022716486854027L;

    public ResourceHandshake(String resourceId, Date timestamp) {
        super(resourceId, timestamp);
    }

}