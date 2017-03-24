package DAO;

import entities.Project;
import entities.Resources;

import java.util.Date;
import java.util.List;

public interface ResourcesDAO {
    void requestResorce(Resources res);

    void addResource(Resources res);

    void closeResource(Resources res);

    void changeDescription(Resources res, String new_descr);

    void addDescription(Resources res, String descr);

    List<Resources> getAllResources();

    List<Resources> getAllProjectResources(Project pr);

    List<Resources> getActiveResources();

    List<Resources> getExpiredResources();

    List<Resources> getResourcesExpAt(Date date);

    List<Resources> getActiveResourcesAt(Date date);
}
