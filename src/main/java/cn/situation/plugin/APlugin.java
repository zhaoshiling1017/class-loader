package cn.situation.plugin;

import cn.situation.service.PluginService;

import java.util.Map;

/**
 * @author lenzhao
 * @date 2019/1/17 11:37
 * @description TODO
 */
public class APlugin implements PluginService {

    @Override
    public void service(Map<String, String> configs) {
        System.out.println("A客户插件正在执行~");
        System.out.println(configs.get("FTP_IP"));
        System.out.println(configs.get("FTP_PORT"));
        System.out.println(configs.get("FTP_USERNAME"));
        System.out.println(configs.get("FTP_PASSWORD"));
        System.out.println("A客户插件运行结束~");
    }
}
