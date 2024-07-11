package co.base.project.model.task.gateways;

import co.base.project.model.task.dto.TaskInputDomainDTO;
import co.base.project.model.task.dto.TaskOutputDomainDTO;
import co.base.project.model.transversal.gateways.IBusinessGateway;

public interface ITaskBusinessGateway extends IBusinessGateway<TaskInputDomainDTO, TaskOutputDomainDTO> {
}
