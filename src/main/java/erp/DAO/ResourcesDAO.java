package erp.DAO;

import erp.entity.Project;
import erp.entity.Resources;

import java.util.Date;
import java.util.List;

public interface ResourcesDAO {
    void requestResource(Resources res);

    void addResource(Resources res);

    void addResource(Resources res, Date d);

    void addResource(Resources res, String description);

    void addResource(Resources res, Date d, String description);

    void declineResource(Resources res, String description);

    void closeResource(Resources res);

    void changeDescription(Resources res, String new_descr);

    List<Resources> getAllResources();

    List<Resources> getAllProjectResources(Project pr);

    List<Resources> getActiveResources();

    List<Resources> getFinishedResources();
}
