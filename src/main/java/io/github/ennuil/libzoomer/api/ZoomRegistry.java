package io.github.ennuil.libzoomer.api;

import java.util.HashSet;
import java.util.Set;

/**
 * The class responsible for the handling the zoom instance registry.
 */
public class ZoomRegistry {
    private static final Set<ZoomInstance> zoomInstances = new HashSet<>();

    /**
     * Registers a zoom instance into the internal set of zoom instances.
     * Mandatory in order to make a zoom instance functional. 
     * @param instance An unregistered zoom instance.
     * @return The zoom instance if registered, else, null.
     */
    public static ZoomInstance registerInstance(ZoomInstance instance) {
        for (ZoomInstance zoomInstance : zoomInstances) {
            if (zoomInstance.getInstanceId().equals(instance.getInstanceId())) {
                throw new RuntimeException("Multiple zoom instances with the ID " + zoomInstance.getInstanceId() + " were found!");
            }
        }
        return zoomInstances.add(instance) ? instance : null;
    }

    /**
     * Gets a set of all the registered zoom instances.
     * @return A set of registered zoom instances.
     */
    public static Set<ZoomInstance> getZoomInstances() {
        return zoomInstances;
    }
}
