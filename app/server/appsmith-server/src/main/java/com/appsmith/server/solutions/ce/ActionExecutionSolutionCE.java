package com.appsmith.server.solutions.ce;

import com.appsmith.external.dtos.ExecuteActionDTO;
import com.appsmith.external.models.ActionDTO;
import com.appsmith.external.models.ActionExecutionResult;
import com.appsmith.server.domains.NewAction;
import org.springframework.http.codec.multipart.Part;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface ActionExecutionSolutionCE {
    Mono<ActionExecutionResult> executeAction(Flux<Part> partFlux, String branchName, String environmentName);

    Mono<ActionExecutionResult> executeAction(ExecuteActionDTO executeActionDTO, String environmentName);

    Mono<ActionDTO> getValidActionForExecution(ExecuteActionDTO executeActionDTO, String actionId, NewAction newAction);

    <T> T variableSubstitution(T configuration, Map<String, String> replaceParamsMap);

}
