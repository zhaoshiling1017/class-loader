package cn.situation.plugin;

import cn.situation.service.PluginService;

import java.util.Map;

/**
 * @author lenzhao
 * @date 2019/1/17 11:39
 * @description TODO
 */
public class BPlugin implements PluginService {

    @Override
    public void service(Map<String, String> configs) {
        System.out.println("B客户插件正在执行~");
    }
}
