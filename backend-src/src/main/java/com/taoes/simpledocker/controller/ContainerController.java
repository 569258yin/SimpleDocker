package com.taoes.simpledocker.controller;

import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.command.TopContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.taoes.simpledocker.controller.container.OperateContainerRequest;
import com.taoes.simpledocker.controller.container.RunNewContainerRequest;
import com.taoes.simpledocker.model.ResponseModel;
import com.taoes.simpledocker.model.enums.ContainerOperate;
import com.taoes.simpledocker.service.ContainerService;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 容器相关服务
 *
 * @author 枕上江南 zhoutao925638@vip.qq.com
 * @date 2021/12/4 11:35 下午
 */
@Slf4j
@RestController
@RequestMapping("/api/container")
@AllArgsConstructor
public class ContainerController extends BaseController {

  private ContainerService service;

  @GetMapping
  public ResponseModel< List<Container>> list() {
    final List<Container> containers = service.list(true);
    return ResponseModel.ok(containers);
  }

  @GetMapping("/{containerId}")
  public InspectContainerResponse inspect(@PathVariable String containerId) {
    return service.inspect(containerId);
  }

  @PostMapping("/new")
  public CreateContainerResponse run(@RequestBody RunNewContainerRequest request) {
    return service.run(request);
  }

  @GetMapping("/{containerId}/top")
  public TopContainerResponse top(@PathVariable String containerId, String psArgs) {
    return service.top(containerId, psArgs);
  }

  @PostMapping("/operator/{operate}")
  public ResponseModel<Boolean> operateContainer(
      @PathVariable ContainerOperate operate,
      @RequestBody OperateContainerRequest request) {

    final String containerId = request.getContainerId();
    final Map<String, String> properties = request.findProperties();
    final List<String> authentication = getAuthentication();
    try {
      switch (operate) {
        case START:
          service.start(containerId);
          break;
        case STOP:
          service.stop(containerId);
          break;
        case PAUSE:
          service.pause(containerId);
          break;
        case UNPAUSE:
          service.unpause(containerId);
          break;
        case REMOVE:
          service.remove(containerId, properties);
          break;
        case EXPORT_LOCAL:
        default:
      }
    } catch (Exception e) {
      throw new RuntimeException("操作失败:" + e.getMessage());
    }
    return ResponseModel.ok(Boolean.TRUE);
  }

}
