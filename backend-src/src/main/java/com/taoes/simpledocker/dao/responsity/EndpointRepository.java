package com.taoes.simpledocker.dao.responsity;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taoes.simpledocker.dao.bean.DockerEndpointDao;
import com.taoes.simpledocker.dao.mapper.DockerEndpointMapper;
import org.springframework.stereotype.Repository;

/**
 * ConfigRepository 对象
 *
 * @author 枕上江南 zhoutao925638@vip.qq.com
 * @date 2021/12/15 1:18 下午
 */
@Repository
public class EndpointRepository extends ServiceImpl<DockerEndpointMapper, DockerEndpointDao> {

}
